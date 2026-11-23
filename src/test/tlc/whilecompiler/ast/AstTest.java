package tlc.whilecompiler.ast;
import fr.tlc.whilecompiler.ast.Ast;
import org.antlr.runtime.tree.CommonTree;

public class AstTest {

    public static void main(String[] args) throws Exception {
        //Programme WHILE de test
        String source = "function test: read X % Y := X % write Y";
        //Analyse le programme et construit l'AST
        CommonTree tree = Ast.parse(source);
        //Affiche l'arbre syntaxique
        System.out.println(tree.toStringTree());
    }
}