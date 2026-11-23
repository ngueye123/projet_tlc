
# AST

## Programme

```mermaid
graph TD
prog[PROGRAM] --> func[FUNCTION]
```

Le noeud `PROGRAM` contient une ou plusieurs fonctions, dans l'ordre où elles sont définies.

## Fonction

```mermaid
graph TD
func[FUNCTION] --> name[main]
func --> inputs[INPUTS]
func --> commands[COMMANDS]
func --> outputs[OUTPUTS]
```

Le noeud `FUNCTION` comprend 4 noeuds :

- Le premier correspond au nom de la fonction (`main`).
- Le deuxième `INPUTS` correspond aux variables d'entrée.
- Le troisième `COMMANDS` correspond au corps de la fonction.
- Le dernier `OUTPUTS` correspond aux variables de sortie.

## Inputs

```mermaid
graph TD
INPUTS --> X[Variable X]
```

Le noeud `INPUTS` contient les variables utilisées comme paramètres d'entrée de la fonction. Dans cet arbre, il contient une seule variable : `X`.

## Outputs

```mermaid
graph TD
OUTPUTS --> Z[Variable Z]
```

Le noeud `OUTPUTS` contient les variables de sortie de la fonction. Dans cet arbre, il contient une seule variable : `Z`.

## Commands

```mermaid
graph TD
cmds[COMMANDS] --> A1[ASSIGN]
cmds --> A2[ASSIGN]
cmds --> IF
cmds --> WHILE
```

Le noeud `COMMANDS` contient plusieurs commandes, dans l'ordre où elles sont exécutées.

Dans cet arbre, il contient deux affectations, une condition `IF` et une boucle `WHILE`.

## Assign

```mermaid
graph TD
ASSIGN --> VARS
ASSIGN --> EXPRS
VARS --> Y[Variable Y]
EXPRS --> CONS
CONS --> VAR
CONS --> NIL
VAR --> X[Variable X]
```

Le noeud `ASSIGN` comprend 2 noeuds :

- Le premier `VARS` correspond aux variables qui seront affectées.
- Le deuxième `EXPRS` correspond aux expressions dont les valeurs seront affectées aux variables définies dans le noeud `VARS`.

Dans cet arbre, la première affectation construit une liste contenant la variable `X` et `NIL`, puis affecte cette liste à `Y`.

La deuxième affectation construit une liste contenant `Y` et `NIL`, puis affecte cette liste à `Z`.

## If

```mermaid
graph TD
IF --> EQ
IF --> THEN[COMMANDS THEN]
IF --> ELSE[COMMANDS ELSE]

EQ --> VAR
EQ --> NIL
VAR --> Y[Variable Y]

THEN --> A1[ASSIGN]
A1 --> V1[VARS]
A1 --> E1[EXPRS]
V1 --> Z1[Variable Z]
E1 --> NIL1[NIL]

ELSE --> A2[ASSIGN]
A2 --> V2[VARS]
A2 --> E2[EXPRS]
V2 --> Z2[Variable Z]
E2 --> HD
HD --> VAR2[VAR]
VAR2 --> Y2[Variable Y]
```

Le noeud `IF` comprend 3 noeuds :

- Le premier `EQ` correspond à la condition d'exécution. Il teste l'égalité entre `Y` et `NIL`.
- Le deuxième `COMMANDS` correspond aux instructions exécutées si la condition est vraie.
- Le troisième `COMMANDS` correspond aux instructions exécutées si la condition est fausse.

Dans cet arbre :

- Si `Y` est égal à `NIL`, on affecte `NIL` à `Z`.
- Sinon, on affecte le premier élément de `Y` à `Z` grâce à l'opération `HD`.

## While

```mermaid
graph TD
WHILE --> EQ
WHILE --> COMMANDS

EQ --> VAR
EQ --> NIL
VAR --> Z[Variable Z]

COMMANDS --> ASSIGN
ASSIGN --> VARS
ASSIGN --> EXPRS
VARS --> Z2[Variable Z]
EXPRS --> TL
TL --> VAR2[VAR]
VAR2 --> Y[Variable Y]
```

Le noeud `WHILE` comprend 2 noeuds :

- Le premier `EQ` correspond à la condition de la boucle. Il teste l'égalité entre `Z` et `NIL`.
- Le deuxième `COMMANDS` correspond aux instructions répétées tant que la condition est vraie.

Dans cet arbre, tant que `Z` est égal à `NIL`, on affecte à `Z` le résultat de l'opération `TL` appliquée à `Y`.

## Eq

```mermaid
graph TD
EQ --> L[exprBase gauche]
EQ --> R[exprBase droite]
```

Le noeud `EQ` comprend 2 noeuds : les deux expressions dont on teste l'égalité avec l'opérateur `=?`.

Dans cet arbre, il est utilisé dans les conditions du `IF` et du `WHILE`.

## Vars

```mermaid
graph TD
VARS --> V1[Variable]
VARS --> V2["..."]
```

Le noeud `VARS` contient une ou plusieurs variables auxquelles les valeurs seront affectées.

## Exprs

```mermaid
graph TD
EXPRS --> E1[exprBase]
EXPRS --> E2["..."]
```

Le noeud `EXPRS` contient une ou plusieurs expressions correspondant aux valeurs à affecter aux variables du noeud `VARS`.

## Var

```mermaid
graph TD
VAR --> X[Variable]
```

Le noeud `VAR` comprend un seul enfant : le nom de la variable.

Dans cet arbre, les variables utilisées sont `X`, `Y` et `Z`.

## Nil

```mermaid
graph TD
NIL
```

Le noeud `NIL` n'a aucun enfant : il représente la liste vide.

## Cons

```mermaid
graph TD
CONS --> E1[exprBase]
CONS --> E2[exprBase]
```

Le noeud `CONS` contient zéro ou plusieurs expressions. Il permet de construire une liste à partir de ses éléments.

Dans cet arbre, il est utilisé pour construire deux listes :

- Une première liste contenant `X` et `NIL`.
- Une deuxième liste contenant `Y` et `NIL`.

## Hd

```mermaid
graph TD
HD --> E[exprBase]
```

Le noeud `HD` comprend un seul enfant : l'expression sur laquelle l'opération s'applique.

Il permet de récupérer le premier élément d'une liste.

Dans cet arbre, il est appliqué à la variable `Y`.

## Tl

```mermaid
graph TD
TL --> E[exprBase]
```

Le noeud `TL` comprend un seul enfant : l'expression sur laquelle l'opération s'applique.

Il permet de récupérer la liste privée de son premier élément.

Dans cet arbre, il est appliqué à la variable `Y`.
