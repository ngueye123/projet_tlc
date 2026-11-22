package whilec.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.runtime.tree.Tree;

import whilec.frontend.WhileParser;

/**
 * Fonctions utilitaires pour lire l'AST produit par la grammaire While.g.
 *
 * <p>L'AST est un arbre ANTLR ({@link Tree} / {@code CommonTree}) : chaque nœud
 * a un <b>type</b> ({@code t.getType()}, comparé aux constantes de {@link WhileParser}),
 * un <b>texte</b> ({@code t.getText()}) et des <b>fils</b>. Cette classe évite aux
 * autres passes de manipuler des indices de fils "magiques" : elle donne un nom
 * à chaque partie d'une construction, conformément au contrat d'AST :
 *
 * <pre>
 *  ^(FUNCTION Symbol ^(INPUT Variable*) ^(COMMANDS cmd+) ^(OUTPUT Variable+))
 *  ^(ASSIGN ^(VARS Variable+) ^(EXPRS expr+))
 *  ^(IF cond ^(COMMANDS..) ^(COMMANDS..)?)    ^(WHILE cond ^(COMMANDS..))
 *  ^(FOR count ^(COMMANDS..))                 ^(FOREACH Variable list ^(COMMANDS..))
 *  ^(CONS expr*) ^(LIST expr*) ^(HD e) ^(TL e) ^(CALL Symbol expr*) ^(EQ e1 e2)
 *  feuilles : NIL, Variable, Symbol, NOP
 * </pre>
 */
public final class Ast {

    private Ast() { }

    // généralités

    /** Ligne source du nœud (1 = première ligne ; 0 si inconnue, ex. PROGRAM). */
    public static int line(Tree t) { return t.getLine(); }

    /** Colonne source du nœud (0 = première colonne). */
    public static int column(Tree t) { return t.getCharPositionInLine(); }

    /* * Nom du type de nœud : "FUNCTION", "IF", "Variable", "Symbol", */
    public static String kind(Tree t) {
        int type = t.getType();
        return (type >= 0 && type < WhileParser.tokenNames.length) ? WhileParser.tokenNames[type] : "?" + type;
    }

    /** Liste des fils d'un nœud (liste vide si feuille). */
    public static List<Tree> children(Tree t) {
        int n = t.getChildCount();
        if (n == 0) return Collections.emptyList();
        List<Tree> l = new ArrayList<>(n);
        for (int i = 0; i < n; i++) l.add(t.getChild(i));
        return l;
    }

    /** Textes des fils (utile pour INPUT, OUTPUT, VARS : listes de noms de variables). */
    public static List<String> childTexts(Tree t) {
        List<String> l = new ArrayList<>();
        for (Tree c : children(t)) l.add(c.getText());
        return l;
    }

    /** Vrai si le nœud est du type donné (constante de WhileParser). */
    public static boolean is(Tree t, int type) { return t != null && t.getType() == type; }

    // programme

    /** Fonctions du programme (fils de PROGRAM), dans l'ordre du source. */
    public static List<Tree> functions(Tree program) { return children(program); }

    // fonction

    /** Nom de la fonction (ex. "add"). */
    public static String functionName(Tree fn)      { return fn.getChild(0).getText(); }
    /** Nœud Symbol portant le nom de la fonction (pour sa position). */
    public static Tree functionNameNode(Tree fn)    { return fn.getChild(0); }
    /** Nœud INPUT (paramètres). */
    public static Tree functionInputNode(Tree fn)   { return fn.getChild(1); }
    /** Nœud COMMANDS (corps). */
    public static Tree functionBody(Tree fn)        { return fn.getChild(2); }
    /** Nœud OUTPUT (valeurs de retour). */
    public static Tree functionOutputNode(Tree fn)  { return fn.getChild(3); }
    /** Noms des paramètres (éventuellement aucun). */
    public static List<String> functionInputs(Tree fn)  { return childTexts(fn.getChild(1)); }
    /** Noms des variables retournées (au moins une). */
    public static List<String> functionOutputs(Tree fn) { return childTexts(fn.getChild(3)); }

    // commandes

    /** ASSIGN : nœud VARS (partie gauche). */
    public static Tree assignVars(Tree assign)   { return assign.getChild(0); }
    /** ASSIGN : nœud EXPRS (partie droite). */
    public static Tree assignExprs(Tree assign)  { return assign.getChild(1); }

    /** IF / WHILE / FOR : expression de condition (ou de comptage pour FOR). */
    public static Tree condition(Tree t)         { return t.getChild(0); }
    /** IF : bloc "then". */
    public static Tree ifThen(Tree ifNode)       { return ifNode.getChild(1); }
    /** IF : bloc "else", ou null s'il n'y en a pas. */
    public static Tree ifElse(Tree ifNode)       { return ifNode.getChildCount() > 2 ? ifNode.getChild(2) : null; }
    /** WHILE / FOR : corps de la boucle. */
    public static Tree loopBody(Tree loop)       { return loop.getChild(1); }

    /** FOREACH : nom de la variable de boucle. */
    public static String foreachVar(Tree fe)     { return fe.getChild(0).getText(); }
    /** FOREACH : expression parcourue. */
    public static Tree foreachList(Tree fe)      { return fe.getChild(1); }
    /** FOREACH : corps. */
    public static Tree foreachBody(Tree fe)      { return fe.getChild(2); }

    // expressions

    /** CALL : nom de la fonction appelée. */
    public static String callName(Tree call)     { return call.getChild(0).getText(); }
    /** CALL : arguments (tous les fils sauf le premier). */
    public static List<Tree> callArgs(Tree call) {
        List<Tree> all = children(call);
        return all.isEmpty() ? all : all.subList(1, all.size());
    }
}
