package whilec.ast;

import org.antlr.runtime.tree.Tree;

/**
 * Affichage lisible de l'AST, un nœud par ligne, indenté selon la profondeur.
 *
 * <pre>
 * PROGRAM
 *   FUNCTION
 *     add               (Symbol)
 *     INPUT
 *       Op1             (Variable)
 * </pre>
 *
 * Les feuilles Variable et Symbol sont annotées de leur type pour lever toute
 * ambiguïté. Avec {@code showLines = true}, chaque nœud porte sa position
 * source "@ligne:colonne".
 */
public final class AstPrinter {

    private final boolean showLines;
    private final StringBuilder out = new StringBuilder();

    public AstPrinter(boolean showLines) { this.showLines = showLines; }

    /** Produit la représentation textuelle de l'arbre t. */
    public static String print(Tree t, boolean showLines) {
        AstPrinter p = new AstPrinter(showLines);
        p.print(t, 0);
        return p.out.toString();
    }

    private void print(Tree t, int depth) {
        StringBuilder line = new StringBuilder();
        line.append("  ".repeat(depth)).append(t.getText());
        String kind = Ast.kind(t);
        if (kind.equals("Variable") || kind.equals("Symbol")) {
            pad(line, 30).append('(').append(kind).append(')');
        }
        if (showLines && t.getLine() > 0) {
            pad(line, 44).append('@').append(t.getLine()).append(':').append(t.getCharPositionInLine());
        }
        out.append(line).append('\n');
        for (int i = 0; i < t.getChildCount(); i++) print(t.getChild(i), depth + 1);
    }

    /** Complète avec des espaces jusqu'à la colonne voulue (au moins un espace). */
    private static StringBuilder pad(StringBuilder sb, int col) {
        sb.append(' ');
        while (sb.length() < col) sb.append(' ');
        return sb;
    }
}
