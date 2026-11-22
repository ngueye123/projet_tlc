package whilec.diagnostics;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collecteur de diagnostics partagé par toutes les phases du compilateur.
 *
 * <p>Plutôt que d'arrêter le compilateur à la première erreur, chaque phase
 * enregistre ses erreurs ici ; le pilote ({@code whilec.Whilec}) décide ensuite
 * s'il faut continuer (aucune erreur) ou s'arrêter et tout afficher.
 *
 * <p>Utilisation typique (exemple pour l'analyse sémantique) :
 * <pre>
 *   reporter.semanticError(Ast.line(node), Ast.column(node),
 *                          "fonction 'foo' définie deux fois");
 *   if (reporter.hasErrors()) { reporter.printAll(System.err); return; }
 * </pre>
 */
public final class ErrorReporter {

    private final String fileName;
    private final List<Diagnostic> diagnostics = new ArrayList<>();
    private int errorCount = 0;

    /** @param fileName nom du fichier source, utilisé en préfixe des messages (peut être null). */
    public ErrorReporter(String fileName) {
        this.fileName = fileName;
    }

    // ajout

    /** Ajoute un diagnostic quelconque. */
    public void report(Diagnostic d) {
        diagnostics.add(d);
        if (d.severity() == Diagnostic.Severity.ERROR) errorCount++;
    }

    /* * Erreur produite par l'analyseur lexical (caractère interdit, ). */
    public void lexicalError(int line, int column, String message) {
        report(new Diagnostic(Diagnostic.Severity.ERROR, Diagnostic.Kind.LEXICAL, fileName, line, column, message));
    }

    /** Erreur produite par l'analyseur syntaxique (le texte ne respecte pas la grammaire). */
    public void syntaxError(int line, int column, String message) {
        report(new Diagnostic(Diagnostic.Severity.ERROR, Diagnostic.Kind.SYNTAX, fileName, line, column, message));
    }

    /* * Erreur produite par l'analyse sémantique (fonction inconnue, mauvaise arité, ). */
    public void semanticError(int line, int column, String message) {
        report(new Diagnostic(Diagnostic.Severity.ERROR, Diagnostic.Kind.SEMANTIC, fileName, line, column, message));
    }

    /* * Erreur interne : bug du compilateur lui-même (AST mal formé, ). */
    public void internalError(int line, int column, String message) {
        report(new Diagnostic(Diagnostic.Severity.ERROR, Diagnostic.Kind.INTERNAL, fileName, line, column, message));
    }

    /** Avertissement : n'empêche pas la compilation. */
    public void warning(int line, int column, String message) {
        report(new Diagnostic(Diagnostic.Severity.WARNING, Diagnostic.Kind.WARNING, fileName, line, column, message));
    }

    // consultation

    public boolean hasErrors()   { return errorCount > 0; }
    public int errorCount()      { return errorCount; }
    public String fileName()     { return fileName; }

    /** Liste (non modifiable) des diagnostics, dans l'ordre d'apparition. */
    public List<Diagnostic> diagnostics() {
        return Collections.unmodifiableList(diagnostics);
    }

    /** Affiche tous les diagnostics, un par ligne. */
    public void printAll(PrintStream out) {
        for (Diagnostic d : diagnostics) out.println(d);
    }
}
