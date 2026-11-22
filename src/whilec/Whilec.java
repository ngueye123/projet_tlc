package whilec;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

import whilec.ast.Ast;
import whilec.ast.AstDotExporter;
import whilec.ast.AstPrinter;
import whilec.ast.AstShapeChecker;
import whilec.diagnostics.ErrorReporter;
import whilec.frontend.Frontend;

/**
 * Pilote du compilateur While (point d'entrée en ligne de commande).
 *
 * <p>Enchaîne les phases de compilation :
 * <ol>
 *   <li><b>Front-end</b> (implémenté) : analyse lexicale + syntaxique, construction
 *       de l'AST, vérification de sa forme ;</li>
 *   <li><b>Analyse sémantique</b> (à brancher, tâche de Mohamed) ;</li>
 *   <li><b>Génération du code 3 adresses</b> (à brancher, tâche d'Imrane) ;</li>
 *   <li><b>Backend Java + runtime</b> (à brancher, tâche de Nour).</li>
 * </ol>
 *
 * <p>Codes de sortie : 0 = succès, 1 = erreur dans le programme While,
 * 2 = mauvaise utilisation (options, fichier introuvable).
 *
 * <p>Usage : {@code ./whilec [options] fichier.while} (voir {@link #usage()}).
 */
public final class Whilec {

    public static final int EXIT_OK = 0;
    public static final int EXIT_COMPILE_ERROR = 1;
    public static final int EXIT_USAGE = 2;

    // options de la ligne de commande
    private boolean printAst = false;
    private boolean printAstLines = false;
    private boolean printLisp = false;
    private boolean printTokens = false;
    private boolean quiet = false;
    private String dotFile = null;
    private String sourceFile = null;

    public static void main(String[] args) {
        System.exit(new Whilec().run(args));
    }

    /** Analyse les options puis lance la compilation. @return le code de sortie. */
    public int run(String[] args) {
        if (!parseArgs(args)) return EXIT_USAGE;
        try {
            return compile();
        } catch (NoSuchFileException e) {
            System.err.println("whilec : fichier introuvable : " + e.getFile());
            return EXIT_USAGE;
        } catch (IOException e) {
            System.err.println("whilec : erreur d'entrée/sortie : " + e.getMessage());
            return EXIT_USAGE;
        }
    }

    /** La chaîne de compilation proprement dite. */
    private int compile() throws IOException {
        if (!Files.exists(Path.of(sourceFile))) throw new NoSuchFileException(sourceFile);
        ErrorReporter reporter = new ErrorReporter(sourceFile);

        // Option de mise au point : liste des lexèmes (sortie de l'analyse lexicale)
        if (printTokens) {
            List<Token> tokens = Frontend.tokenize(sourceFile, reporter);
            for (Token t : tokens) {
                System.out.printf("%4d:%-3d %-12s %s%n", t.getLine(), t.getCharPositionInLine(),
                        Frontend.tokenTypeName(t.getType()), t.getText());
            }
            if (reporter.hasErrors()) { reporter.printAll(System.err); return EXIT_COMPILE_ERROR; }
        }

        // Étape 1 : front-end (texte -> AST)
        CommonTree ast = Frontend.parseFile(sourceFile, reporter);
        if (ast == null || reporter.hasErrors()) {
            reporter.printAll(System.err);
            System.err.println(reporter.errorCount() + " erreur(s), compilation interrompue.");
            return EXIT_COMPILE_ERROR;
        }
        // Garde-fou : l'AST respecte-t-il le contrat attendu par les passes suivantes ?
        if (!new AstShapeChecker(reporter).check(ast)) {
            reporter.printAll(System.err);
            return EXIT_COMPILE_ERROR;
        }

        if (printAst || printAstLines) System.out.print(AstPrinter.print(ast, printAstLines));
        if (printLisp) System.out.println(ast.toStringTree());
        if (dotFile != null) {
            Files.writeString(Path.of(dotFile), AstDotExporter.export(ast), StandardCharsets.UTF_8);
            if (!quiet) System.err.println("AST exporté dans " + dotFile
                    + " (image : dot -Tpng " + dotFile + " -o ast.png)");
        }

        // Étape 2 : analyse sémantique (Mohamed)
        // TODO brancher ici : new SemanticAnalyzer(reporter).analyze(ast)
        //      -> table des symboles + vérifications ; arrêter si reporter.hasErrors().

        // Étape 3 : génération du code 3 adresses (Imrane)
        // TODO brancher ici : List<IRFunction> ir = new ThreeAddressGenerator(symbols).generate(ast);

        // Étape 4 : backend Java + runtime (Nour)
        // TODO brancher ici : new JavaBackend().emit(ir, outputDir);

        reporter.printAll(System.err);   // avertissements éventuels
        if (!quiet && !(printAst || printAstLines || printLisp || printTokens)) {
            System.out.println(sourceFile + " : analyse syntaxique réussie ("
                    + Ast.functions(ast).size() + " fonction(s) : "
                    + String.join(", ", functionNames(ast)) + ").");
        }
        return EXIT_OK;
    }

    private static List<String> functionNames(CommonTree ast) {
        return Ast.functions(ast).stream().map(Ast::functionName).toList();
    }

    // options

    private boolean parseArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String a = args[i];
            switch (a) {
                case "-h": case "--help": usage(); return false;
                case "--ast":        printAst = true; break;
                case "--ast-lines":  printAstLines = true; break;
                case "--lisp":       printLisp = true; break;
                case "--tokens":     printTokens = true; break;
                case "-q": case "--quiet": quiet = true; break;
                case "--dot":
                    if (i + 1 >= args.length) { System.err.println("whilec : --dot attend un nom de fichier"); return false; }
                    dotFile = args[++i];
                    break;
                default:
                    if (a.startsWith("-")) { System.err.println("whilec : option inconnue : " + a); usage(); return false; }
                    if (sourceFile != null) { System.err.println("whilec : un seul fichier source attendu"); return false; }
                    sourceFile = a;
            }
        }
        if (sourceFile == null) { usage(); return false; }
        return true;
    }

    private static void usage() {
        System.err.println(String.join("\n",
            "Usage : whilec [options] fichier.while",
            "",
            "Options :",
            "  --ast          affiche l'AST (arbre indenté)",
            "  --ast-lines    affiche l'AST avec la position source (@ligne:colonne) de chaque nœud",
            "  --lisp         affiche l'AST au format parenthésé d'ANTLR",
            "  --tokens       affiche la liste des lexèmes (sortie de l'analyse lexicale)",
            "  --dot FICHIER  exporte l'AST au format Graphviz (dot -Tpng FICHIER -o ast.png)",
            "  -q, --quiet    n'affiche que les erreurs",
            "  -h, --help     affiche cette aide",
            "",
            "Codes de retour : 0 = succès, 1 = erreur dans le programme, 2 = erreur d'utilisation."));
    }
}
