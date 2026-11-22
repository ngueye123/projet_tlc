package whilec.ast;

import org.antlr.runtime.tree.Tree;

import whilec.frontend.WhileParser;

/**
 * Patron de conception <b>Visiteur</b> adapté à l'AST ANTLR de While.
 *
 * <p>ANTLR 3 ne fournit qu'un type de nœud générique ({@link Tree}) ; le type
 * réel de la construction est un entier ({@code getType()}). La méthode
 * {@link #visit(Tree)} fait donc l'aiguillage ("dispatch") vers la méthode
 * {@code visitXxx} correspondante.
 *
 * <p>Par défaut, chaque {@code visitXxx} visite simplement les fils
 * ({@link #visitChildren}). Pour écrire une nouvelle passe (analyse sémantique,
 * génération de code 3 adresses, affichage), il suffit d'hériter de cette
 * classe et de redéfinir les méthodes utiles :
 *
 * <pre>
 *   // Compte les appels de fonction d'un programme
 *   class CallCounter extends AstVisitor&lt;Integer&gt; {
 *       protected Integer defaultResult() { return 0; }
 *       protected Integer aggregate(Integer acc, Integer child) { return acc + child; }
 *       public Integer visitCall(Tree t) { return 1 + visitChildren(t); }
 *   }
 *   int n = new CallCounter().visit(ast);
 * </pre>
 *
 * @param <R> type du résultat renvoyé par les méthodes de visite
 * (Void si la passe ne renvoie rien, String, List&lt;Instr&gt;, )
 */
public abstract class AstVisitor<R> {

    /** Aiguille vers la méthode correspondant au type du nœud. */
    public R visit(Tree t) {
        switch (t.getType()) {
            // structure du programme
            case WhileParser.PROGRAM:  return visitProgram(t);
            case WhileParser.FUNCTION: return visitFunction(t);
            case WhileParser.INPUT:    return visitInput(t);
            case WhileParser.OUTPUT:   return visitOutput(t);
            case WhileParser.COMMANDS: return visitCommands(t);
            // commandes
            case WhileParser.NOP:      return visitNop(t);
            case WhileParser.ASSIGN:   return visitAssign(t);
            case WhileParser.VARS:     return visitVars(t);
            case WhileParser.EXPRS:    return visitExprs(t);
            case WhileParser.IF:       return visitIf(t);
            case WhileParser.WHILE:    return visitWhile(t);
            case WhileParser.FOR:      return visitFor(t);
            case WhileParser.FOREACH:  return visitForeach(t);
            // expressions
            case WhileParser.NIL:      return visitNil(t);
            case WhileParser.Variable: return visitVariable(t);
            case WhileParser.Symbol:   return visitSymbol(t);
            case WhileParser.CONS:     return visitCons(t);
            case WhileParser.LIST:     return visitList(t);
            case WhileParser.HD:       return visitHd(t);
            case WhileParser.TL:       return visitTl(t);
            case WhileParser.CALL:     return visitCall(t);
            case WhileParser.EQ:       return visitEq(t);
            default:
                throw new IllegalStateException("type de nœud inattendu dans l'AST : "
                        + Ast.kind(t) + " (ligne " + t.getLine() + ")");
        }
    }

    /** Résultat par défaut (feuilles, ou nœud sans fils). Par défaut : null. */
    protected R defaultResult() { return null; }

    /** Combine le résultat accumulé avec celui d'un fils. Par défaut : garde le dernier. */
    protected R aggregate(R accumulated, R childResult) { return childResult; }

    /** Visite tous les fils de t dans l'ordre et combine leurs résultats. */
    protected R visitChildren(Tree t) {
        R result = defaultResult();
        for (int i = 0; i < t.getChildCount(); i++) {
            result = aggregate(result, visit(t.getChild(i)));
        }
        return result;
    }

    // structure : ^(PROGRAM FUNCTION+) ; ^(FUNCTION Symbol INPUT COMMANDS OUTPUT)
    public R visitProgram(Tree t)  { return visitChildren(t); }
    public R visitFunction(Tree t) { return visitChildren(t); }
    public R visitInput(Tree t)    { return visitChildren(t); }
    public R visitOutput(Tree t)   { return visitChildren(t); }
    public R visitCommands(Tree t) { return visitChildren(t); }

    // commandes
    public R visitNop(Tree t)      { return defaultResult(); }
    public R visitAssign(Tree t)   { return visitChildren(t); }
    public R visitVars(Tree t)     { return visitChildren(t); }
    public R visitExprs(Tree t)    { return visitChildren(t); }
    public R visitIf(Tree t)       { return visitChildren(t); }
    public R visitWhile(Tree t)    { return visitChildren(t); }
    public R visitFor(Tree t)      { return visitChildren(t); }
    public R visitForeach(Tree t)  { return visitChildren(t); }

    // expressions
    public R visitNil(Tree t)      { return defaultResult(); }
    public R visitVariable(Tree t) { return defaultResult(); }
    public R visitSymbol(Tree t)   { return defaultResult(); }
    public R visitCons(Tree t)     { return visitChildren(t); }
    public R visitList(Tree t)     { return visitChildren(t); }
    public R visitHd(Tree t)       { return visitChildren(t); }
    public R visitTl(Tree t)       { return visitChildren(t); }
    public R visitCall(Tree t)     { return visitChildren(t); }
    public R visitEq(Tree t)       { return visitChildren(t); }
}
