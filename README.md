# Compilateur While (projet TLC, ESIR2)

Compilateur du langage **While** (spécification : `Specifications_while.pdf`) écrit en Java avec **ANTLR 3.5.3**.
Le langage cible est **Java**.

Équipe : Ndiaga, Mohamed, Imrane, Nour.

| Phase | Responsable | État |
|---|---|---|
| 1. Front-end : grammaire ANTLR, AST, pilote `whilec`, tests de syntaxe | Ndiaga | **fait** (ce document) |
| 2. Analyse sémantique, table des symboles | Mohamed | à brancher |
| 3. Génération du code 3 adresses (+ optimisations) | Imrane | à brancher |
| 4. Backend 3A → Java, bibliothèque runtime, script final | Nour | à brancher |

La documentation détaillée du front-end est dans [`docs/Frontend_While.pdf`](docs/Frontend_While.pdf).

## 1. Démarrage rapide

Prérequis : un **JDK 17 ou plus récent** (`java` et `javac`) et bash. ANTLR est fourni dans `lib/`.

```bash
./build.sh                                              # génère le parser + compile (≈ 3 s)
./whilec tests/syntax/ok/04_arithmetique.while          # analyse un programme
./whilec --ast tests/syntax/ok/04_arithmetique.while    # affiche son AST
./run_tests.sh                                          # lance les 26 tests de non-régression
```

Exemple de sortie :

```
$ ./whilec tests/syntax/ok/04_arithmetique.while
tests/syntax/ok/04_arithmetique.while : analyse syntaxique réussie (3 fonction(s) : add, sub, mul).

$ ./whilec tests/syntax/ko/02_fi_manquant.while
tests/syntax/ko/02_fi_manquant.while:4:19: erreur de syntaxe : attendu : 'fi', trouvé : 'od'
1 erreur(s), compilation interrompue.
```

## 2. Options de `whilec`

```
Usage : whilec [options] fichier.while

  --ast          affiche l'AST (arbre indenté)
  --ast-lines    affiche l'AST avec la position source (@ligne:colonne) de chaque nœud
  --lisp         affiche l'AST au format parenthésé d'ANTLR
  --tokens       affiche la liste des lexèmes (sortie de l'analyse lexicale)
  --dot FICHIER  exporte l'AST au format Graphviz (dot -Tpng FICHIER -o ast.png)
  -q, --quiet    n'affiche que les erreurs
  -h, --help     affiche l'aide
```

Codes de retour : `0` succès, `1` erreur dans le programme While, `2` mauvaise utilisation (option inconnue, fichier introuvable).

Pour obtenir une image de l'AST, installez Graphviz (`sudo apt install graphviz`), puis lancez
`./whilec --dot ast.dot prog.while && dot -Tpng ast.dot -o ast.png`.

## 3. Organisation des fichiers

```
projet_tlc/
├── build.sh                    construit le compilateur (ANTLR puis javac)
├── whilec                      lanceur : ./whilec [options] fichier.while
├── run_tests.sh                tests de non-régression (--update pour régénérer les attendus)
├── lib/                        jars ANTLR (on utilise antlr-3.5.3-complete-no-st3.jar)
├── src/whilec/
│   ├── Whilec.java             pilote : options, enchaînement des phases (points de branchement TODO)
│   ├── frontend/
│   │   ├── While.g             GRAMMAIRE ANTLR décorée (lexèmes, règles, réécriture en AST)
│   │   ├── Frontend.java       texte -> AST (lexer + parser), liste des lexèmes
│   │   └── SyntaxErrors.java   traduction des erreurs ANTLR en messages français
│   ├── ast/
│   │   ├── Ast.java            accès nommés aux parties de l'AST (functionName, ifElse, callArgs...)
│   │   ├── AstVisitor.java     patron Visiteur générique : base de toutes les passes
│   │   ├── AstShapeChecker.java  vérifie que l'AST respecte le contrat (exemple de visiteur)
│   │   ├── AstPrinter.java     affichage indenté (--ast, --ast-lines)
│   │   └── AstDotExporter.java export Graphviz (--dot)
│   └── diagnostics/
│       ├── Diagnostic.java     un message d'erreur positionné (fichier:ligne:colonne)
│       └── ErrorReporter.java  collecteur d'erreurs partagé par toutes les phases
├── gen/                        (généré) WhileLexer.java, WhileParser.java
├── build/                      (généré) fichiers .class
├── tests/syntax/
│   ├── ok/   11 programmes valides  + leur AST attendu (.ast)
│   └── ko/   15 programmes invalides + les messages attendus (.err)
└── docs/Frontend_While.pdf     documentation détaillée du front-end
```

`gen/` et `build/` ne sont pas versionnés : `./build.sh` les recrée.

**IntelliJ** : clic droit sur `src` puis *Mark Directory as > Sources Root*, et pareil pour `gen` (après un premier `./build.sh`).
Il faut aussi relancer `./build.sh` après chaque modification de `While.g`.

## 4. Le langage reconnu (rappel)

```
// commentaires : // jusqu'à la fin de ligne, ou /* ... */
function add :                 // nom de fonction = Symbol (minuscule au début)
read Op1, Op2                  // paramètres = Variables (majuscule au début), 0 ou plus
%
  Result := Op1 ;              // les commandes sont SÉPARÉES par ';' (pas de ';' final)
  for Op2 do
    Result := (cons nil Result)
  od
%
write Result                   // au moins une valeur de retour
```

* **Commandes :** `nop`, `V1, ..., Vn := E1, ..., En`, `if E then C [else C] fi`, `while E do C od`, `for E do C od`, `foreach V in E do C od`.
* **Expressions :** `nil`, `Variable`, `symbole`, `(cons E*)`, `(list E*)`, `(hd E)`, `(tl E)`, `(f E*)` (appel de fonction), `E =? E`.
* **Identifiants :** `Variable = [A-Z][A-Za-z0-9]*[!?]?`, `Symbol = [a-z][A-Za-z0-9]*[!?]?`.
  Les mots-clés (`nil`, `cons`, `if`...) sont réservés, mais `consume` ou `iffy` sont des symboles ordinaires.

## 5. L'AST : contrat pour les phases suivantes

L'AST est un arbre ANTLR `CommonTree`. Le type d'un nœud s'obtient avec `t.getType()` et se compare aux constantes
`WhileParser.XXX`. Chaque nœud porte sa position dans le source (`t.getLine()`, `t.getCharPositionInLine()`).

```
PROGRAM  -> ^(PROGRAM FUNCTION+)
FUNCTION -> ^(FUNCTION Symbol ^(INPUT Variable*) ^(COMMANDS cmd+) ^(OUTPUT Variable+))
cmd      -> NOP
          | ^(ASSIGN ^(VARS Variable+) ^(EXPRS expr+))
          | ^(IF expr ^(COMMANDS ..) ^(COMMANDS ..)?)        // le 2e COMMANDS est le else
          | ^(WHILE expr ^(COMMANDS ..))
          | ^(FOR expr ^(COMMANDS ..))
          | ^(FOREACH Variable expr ^(COMMANDS ..))
expr     -> NIL | Variable | Symbol                          // un Symbol seul est une constante
          | ^(CONS expr*) | ^(LIST expr*) | ^(HD expr) | ^(TL expr)
          | ^(CALL Symbol expr*) | ^(EQ expr expr)
```

Exemple : pour `if X =? nil then Y := (f X) fi`, on obtient

```
IF
  EQ
    X          (Variable)
    NIL
  COMMANDS
    ASSIGN
      VARS
        Y      (Variable)
      EXPRS
        CALL
          f    (Symbol)
          X    (Variable)
```

À chaque compilation, `AstShapeChecker` vérifie automatiquement ce contrat.
**Ne modifiez pas la forme de l'AST sans prévenir l'équipe**, puis lancez `./run_tests.sh`.

## 6. Écrire une nouvelle passe (Mohamed, Imrane)

On hérite de `AstVisitor<R>` et on redéfinit les méthodes `visitXxx` utiles. Par défaut, chaque méthode visite les fils.
`Ast` donne un nom à chaque partie de l'arbre, ce qui évite de manipuler des indices `getChild(i)`.

```java
import org.antlr.runtime.tree.Tree;
import whilec.ast.*;
import whilec.diagnostics.ErrorReporter;

/** Exemple : signale les appels à des fonctions qui n'existent pas. */
class UndefinedCallChecker extends AstVisitor<Void> {
    private final java.util.Set<String> defined = new java.util.HashSet<>();
    private final ErrorReporter reporter;

    UndefinedCallChecker(ErrorReporter r) { reporter = r; }

    @Override public Void visitProgram(Tree t) {
        for (Tree f : Ast.functions(t)) defined.add(Ast.functionName(f));  // 1er passage : déclarations
        return visitChildren(t);                                           // 2e passage : utilisations
    }

    @Override public Void visitCall(Tree t) {
        if (!defined.contains(Ast.callName(t)))
            reporter.semanticError(Ast.line(t), Ast.column(t),
                                   "fonction '" + Ast.callName(t) + "' non définie");
        return visitChildren(t);
    }
}
```

On branche ensuite la passe dans `Whilec.compile()`, à l'endroit marqué `TODO` (étape 2, 3 ou 4) :

```java
new UndefinedCallChecker(reporter).visit(ast);
if (reporter.hasErrors()) { reporter.printAll(System.err); return EXIT_COMPILE_ERROR; }
```

Pour un visiteur qui produit un résultat, comme une liste d'instructions 3A, il faut redéfinir
`defaultResult()` et `aggregate()` (voir la Javadoc de `AstVisitor`).

## 7. Tests

* `tests/syntax/ok/` contient les programmes qui doivent être acceptés : tous les exemples de la spécification
  (true, false, not, and, add, sub, mul), ainsi que les if/while/for/foreach, les formes de cons/list,
  l'affectation multiple, les fonctions à plusieurs retours, les identifiants limites et les commentaires.
* `tests/syntax/ko/` contient les programmes qui doivent être refusés, avec le message attendu : parenthèse,
  `fi`, `od` ou `;` manquant, `;` final, variable en minuscule, `write` vide, corps vide, caractère interdit,
  `=?` chaîné, `hd` à deux arguments, fichier vide, commentaire non fermé, `read` manquant.
* Pour ajouter un test, déposez un `.while` dans `ok/` ou `ko/`, lancez `./run_tests.sh --update`, puis relisez
  le `.ast` ou le `.err` généré avant de le commiter.

## 8. Choix techniques (résumé)

* **ANTLR 3 avec règles de réécriture (`->`)** : l'AST est construit pendant l'analyse, sans passe supplémentaire.
  Les séparateurs (`;`, `,`, `%`, parenthèses, `then`, `do`...) disparaissent de l'arbre.
* **Nœuds imaginaires positionnés** (`IF[$k, "IF"]`) : même les nœuds absents du texte connaissent leur ligne,
  ce qui permet aux erreurs sémantiques d'être localisées.
* **Erreurs collectées, pas affichées** : lexer et parser envoient leurs erreurs à un `ErrorReporter` partagé,
  avec des messages en français et la position exacte. Si le programme contient des erreurs, aucun AST
  n'est transmis aux phases suivantes.
* **Visiteur générique** : une seule méthode d'aiguillage, réutilisée par toutes les passes.
