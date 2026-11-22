package whilec.diagnostics;

/**
 * Un message produit par le compilateur (erreur ou avertissement), rattaché
 * à une position dans le fichier source.
 *
 * <p>Format d'affichage (proche de gcc/javac, pratique dans un terminal ou un IDE) :
 * <pre>  fichier.while:12:4: erreur de syntaxe : attendu : 'fi', trouvé : 'od'</pre>
 *
 * <p>Classe immuable, partagée par toutes les passes du compilateur.
 */
public final class Diagnostic {

    /** Gravité du message. */
    public enum Severity { ERROR, WARNING }

    /** Phase du compilateur qui a produit le message. */
    public enum Kind {
        LEXICAL("erreur lexicale"),
        SYNTAX("erreur de syntaxe"),
        SEMANTIC("erreur sémantique"),
        INTERNAL("erreur interne"),
        WARNING("avertissement");

        private final String label;
        Kind(String label) { this.label = label; }
        public String label() { return label; }
    }

    private final Severity severity;
    private final Kind kind;
    private final String file;
    private final int line;    // commence à 1 (0 = inconnue)
    private final int column;  // commence à 0 (convention ANTLR)
    private final String message;

    public Diagnostic(Severity severity, Kind kind, String file, int line, int column, String message) {
        this.severity = severity;
        this.kind = kind;
        this.file = file;
        this.line = line;
        this.column = column;
        this.message = message;
    }

    public Severity severity() { return severity; }
    public Kind kind()         { return kind; }
    public String file()       { return file; }
    public int line()          { return line; }
    public int column()        { return column; }
    public String message()    { return message; }

    /** Représentation textuelle : {@code fichier:ligne:colonne: type : message}. */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (file != null) sb.append(file).append(':');
        if (line > 0) sb.append(line).append(':').append(column).append(':');
        if (sb.length() > 0) sb.append(' ');
        sb.append(kind.label()).append(" : ").append(message);
        return sb.toString();
    }
}
