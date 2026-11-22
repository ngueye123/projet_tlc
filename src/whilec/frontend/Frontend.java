package whilec.frontend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

import whilec.diagnostics.ErrorReporter;

/**
 * Point d'entrée du front-end : texte source While -> AST.
 *
 * <p>Enchaîne l'analyse lexicale ({@link WhileLexer}) et l'analyse syntaxique
 * ({@link WhileParser}), deux classes générées par ANTLR à partir de While.g.
 * Les erreurs sont enregistrées dans l'{@link ErrorReporter} fourni.
 *
 * <p>Exemple :
 * <pre>
 *   ErrorReporter rep = new ErrorReporter("prog.while");
 *   CommonTree ast = Frontend.parseFile("prog.while", rep);
 *   if (ast == null) { rep.printAll(System.err); }   // erreurs de syntaxe
 * </pre>
 */
public final class Frontend {

    private Frontend() { }

    /** Analyse un fichier. @return l'AST (racine PROGRAM), ou null en cas d'erreur. */
    public static CommonTree parseFile(String path, ErrorReporter reporter) throws IOException {
        return parse(new ANTLRFileStream(path, "UTF-8"), reporter);
    }

    /** Analyse une chaîne (pratique pour les tests). @return l'AST, ou null en cas d'erreur. */
    public static CommonTree parseString(String source, ErrorReporter reporter) {
        return parse(new ANTLRStringStream(source), reporter);
    }

    /** Cœur de l'analyse : lexer -> flux de lexèmes -> parser -> AST. */
    private static CommonTree parse(CharStream input, ErrorReporter reporter) {
        WhileLexer lexer = new WhileLexer(input);
        lexer.setErrorReporter(reporter);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        WhileParser parser = new WhileParser(tokens);
        parser.setErrorReporter(reporter);

        CommonTree ast;
        try {
            ast = parser.program().getTree();
        } catch (RecognitionException e) {
            // Normalement ANTLR récupère lui-même les erreurs ; filet de sécurité.
            reporter.syntaxError(e.line, e.charPositionInLine,
                    SyntaxErrors.describe(e, WhileParser.tokenNames));
            return null;
        }
        // En cas d'erreur, ANTLR a tenté de se rattraper : l'arbre est partiel,
        // on ne le transmet pas aux phases suivantes.
        return reporter.hasErrors() ? null : ast;
    }

    /**
     * Liste des lexèmes significatifs d'un fichier (canal par défaut, hors
     * blancs et commentaires). Utilisé par l'option {@code --tokens}.
     */
    public static List<Token> tokenize(String path, ErrorReporter reporter) throws IOException {
        WhileLexer lexer = new WhileLexer(new ANTLRFileStream(path, "UTF-8"));
        lexer.setErrorReporter(reporter);
        List<Token> result = new ArrayList<>();
        for (Token t = lexer.nextToken(); t.getType() != Token.EOF; t = lexer.nextToken()) {
            if (t.getChannel() == Token.DEFAULT_CHANNEL) result.add(t);
        }
        return result;
    }

    /** Nom lisible d'un type de lexème (ex. "Variable", "'while'", "IF"). */
    public static String tokenTypeName(int type) {
        if (type == Token.EOF) return "EOF";
        return (type >= 0 && type < WhileParser.tokenNames.length) ? WhileParser.tokenNames[type] : "?" + type;
    }
}
