package whilec.ast;

import org.antlr.runtime.tree.Tree;

import whilec.diagnostics.ErrorReporter;
import whilec.frontend.WhileParser;

/**
 * Vérifie que l'AST produit par le parser respecte exactement le <b>contrat d'AST</b>
 * (nombre et type des fils de chaque nœud).
 *
 * <p>Ce n'est PAS l'analyse sémantique : un programme correct syntaxiquement
 * produit toujours un AST conforme. Ce vérificateur sert de garde-fou :
 * si la grammaire est modifiée et casse le contrat, les passes suivantes
 * (sémantique, code 3 adresses) seraient faussées ; il le détecte
 * immédiatement et signale une "erreur interne".
 *
 * <p>C'est aussi un exemple complet d'utilisation de {@link AstVisitor}.
 */
public final class AstShapeChecker extends AstVisitor<Void> {

    private final ErrorReporter reporter;

    public AstShapeChecker(ErrorReporter reporter) { this.reporter = reporter; }

    /** Vérifie tout l'arbre. @return true si l'AST est conforme. */
    public boolean check(Tree program) {
        int before = reporter.errorCount();
        if (!Ast.is(program, WhileParser.PROGRAM)) fail(program, "la racine doit être PROGRAM");
        else visit(program);
        return reporter.errorCount() == before;
    }

    // structure

    @Override public Void visitProgram(Tree t) {
        atLeast(t, 1);
        for (Tree f : Ast.children(t)) expect(f, WhileParser.FUNCTION);
        return visitChildren(t);
    }

    @Override public Void visitFunction(Tree t) {
        if (exactly(t, 4)) {
            expect(t.getChild(0), WhileParser.Symbol);
            expect(t.getChild(1), WhileParser.INPUT);
            expect(t.getChild(2), WhileParser.COMMANDS);
            expect(t.getChild(3), WhileParser.OUTPUT);
        }
        return visitChildren(t);
    }

    @Override public Void visitInput(Tree t) {
        allOfType(t, WhileParser.Variable);          // 0 paramètre autorisé
        return null;
    }

    @Override public Void visitOutput(Tree t) {
        atLeast(t, 1);                                // au moins une valeur de retour
        allOfType(t, WhileParser.Variable);
        return null;
    }

    @Override public Void visitCommands(Tree t) {
        atLeast(t, 1);
        return visitChildren(t);
    }

    // commandes

    @Override public Void visitNop(Tree t) { exactly(t, 0); return null; }

    @Override public Void visitAssign(Tree t) {
        if (exactly(t, 2)) {
            expect(t.getChild(0), WhileParser.VARS);
            expect(t.getChild(1), WhileParser.EXPRS);
        }
        return visitChildren(t);
    }

    @Override public Void visitVars(Tree t)  { atLeast(t, 1); allOfType(t, WhileParser.Variable); return null; }
    @Override public Void visitExprs(Tree t) { atLeast(t, 1); return visitChildren(t); }

    @Override public Void visitIf(Tree t) {
        if (between(t, 2, 3)) {
            expect(t.getChild(1), WhileParser.COMMANDS);
            if (t.getChildCount() == 3) expect(t.getChild(2), WhileParser.COMMANDS);
        }
        return visitChildren(t);
    }

    @Override public Void visitWhile(Tree t) { return loop(t); }
    @Override public Void visitFor(Tree t)   { return loop(t); }

    private Void loop(Tree t) {
        if (exactly(t, 2)) expect(t.getChild(1), WhileParser.COMMANDS);
        return visitChildren(t);
    }

    @Override public Void visitForeach(Tree t) {
        if (exactly(t, 3)) {
            expect(t.getChild(0), WhileParser.Variable);
            expect(t.getChild(2), WhileParser.COMMANDS);
        }
        return visitChildren(t);
    }

    // expressions

    @Override public Void visitNil(Tree t)      { exactly(t, 0); return null; }
    @Override public Void visitVariable(Tree t) { exactly(t, 0); return null; }
    @Override public Void visitSymbol(Tree t)   { exactly(t, 0); return null; }
    @Override public Void visitHd(Tree t)       { exactly(t, 1); return visitChildren(t); }
    @Override public Void visitTl(Tree t)       { exactly(t, 1); return visitChildren(t); }
    @Override public Void visitEq(Tree t)       { exactly(t, 2); return visitChildren(t); }

    @Override public Void visitCall(Tree t) {
        if (atLeast(t, 1)) expect(t.getChild(0), WhileParser.Symbol);
        // les arguments (fils 1..n) sont des expressions
        for (int i = 1; i < t.getChildCount(); i++) visit(t.getChild(i));
        return null;
    }
    // CONS et LIST : 0..n expressions, comportement par défaut (visite des fils).

    // outils

    private boolean exactly(Tree t, int n) {
        if (t.getChildCount() != n) { fail(t, Ast.kind(t) + " doit avoir " + n + " fils, trouvé " + t.getChildCount()); return false; }
        return true;
    }

    private boolean atLeast(Tree t, int n) {
        if (t.getChildCount() < n) { fail(t, Ast.kind(t) + " doit avoir au moins " + n + " fils"); return false; }
        return true;
    }

    private boolean between(Tree t, int min, int max) {
        int c = t.getChildCount();
        if (c < min || c > max) { fail(t, Ast.kind(t) + " doit avoir entre " + min + " et " + max + " fils"); return false; }
        return true;
    }

    private void expect(Tree t, int type) {
        if (t.getType() != type) fail(t, "nœud " + WhileParser.tokenNames[type] + " attendu, trouvé " + Ast.kind(t));
    }

    private void allOfType(Tree t, int type) {
        for (Tree c : Ast.children(t)) expect(c, type);
    }

    private void fail(Tree t, String msg) {
        reporter.internalError(t.getLine(), t.getCharPositionInLine(), "AST non conforme au contrat : " + msg);
    }
}
