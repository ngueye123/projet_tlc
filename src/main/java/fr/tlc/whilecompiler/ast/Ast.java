package fr.tlc.whilecompiler.ast;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import fr.tlc.whilecompiler.WhileLexer;
import fr.tlc.whilecompiler.WhileParser;

public final class Ast {
    //Empêche la création d'objets de cette classe
    private Ast() {}

    //Analyse le code source et construit son arbre syntaxique
    public static CommonTree parse(String source) throws RecognitionException {

        //Transforme le texte en flux de caractères
        var lexer = new WhileLexer(new ANTLRStringStream(source));

        //Regroupe les tokens générés par le lexer
        var tokens = new CommonTokenStream(lexer);

        //Crée le parser à partir des tokens
        var parser = new WhileParser(tokens);

        //Analyse le programme et récupère son arbre syntaxique
        var result = parser.program();

        //Vérifie s'il existe des erreurs lexicales ou syntaxiques
        if (parser.getNumberOfSyntaxErrors() != 0 || lexer.getNumberOfSyntaxErrors() != 0) {
            throw new IllegalArgumentException("Le source contient une erreur lexicale ou syntaxique.");
        }

        //Retourne l'arbre syntaxique construit
        return (CommonTree) result.getTree();
    }
}