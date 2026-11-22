package whilec.ast;

import org.antlr.runtime.tree.Tree;

import whilec.frontend.WhileParser;

/**
 * Export de l'AST au format Graphviz (DOT), pour le visualiser sous forme d'image :
 * <pre>
 *   ./whilec --dot ast.dot prog.while
 *   dot -Tpng ast.dot -o ast.png
 * </pre>
 * Code couleur : structure en gris, commandes en bleu, expressions en vert,
 * variables en jaune, symboles en orange.
 */
public final class AstDotExporter {

    private final StringBuilder out = new StringBuilder();
    private int nextId = 0;

    /** Produit le texte DOT complet représentant l'arbre t. */
    public static String export(Tree t) {
        AstDotExporter e = new AstDotExporter();
        e.out.append("digraph AST {\n")
             .append("  node [fontname=\"Helvetica\", fontsize=11, style=filled];\n")
             .append("  edge [arrowsize=0.6];\n");
        e.node(t);
        e.out.append("}\n");
        return e.out.toString();
    }

    /** Écrit le nœud t puis ses fils ; renvoie l'identifiant DOT du nœud. */
    private String node(Tree t) {
        String id = "n" + (nextId++);
        out.append("  ").append(id)
           .append(" [label=\"").append(escape(t.getText())).append("\", ")
           .append(style(t)).append("];\n");
        for (int i = 0; i < t.getChildCount(); i++) {
            String child = node(t.getChild(i));
            out.append("  ").append(id).append(" -> ").append(child).append(";\n");
        }
        return id;
    }

    private static String style(Tree t) {
        switch (t.getType()) {
            case WhileParser.Variable:
                return "shape=ellipse, fillcolor=\"#fff2b3\"";
            case WhileParser.Symbol:
                return "shape=ellipse, fillcolor=\"#ffd8b0\"";
            case WhileParser.PROGRAM: case WhileParser.FUNCTION: case WhileParser.INPUT:
            case WhileParser.OUTPUT: case WhileParser.COMMANDS:
                return "shape=box, fillcolor=\"#e6e6e6\"";
            case WhileParser.NOP: case WhileParser.ASSIGN: case WhileParser.VARS: case WhileParser.EXPRS:
            case WhileParser.IF: case WhileParser.WHILE: case WhileParser.FOR: case WhileParser.FOREACH:
                return "shape=box, fillcolor=\"#cfe2ff\"";
            default: // expressions
                return "shape=box, fillcolor=\"#d4f4d4\"";
        }
    }

    private static String escape(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
