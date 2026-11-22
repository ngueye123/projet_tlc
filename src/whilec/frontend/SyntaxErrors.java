package whilec.frontend;

import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.MissingTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.UnwantedTokenException;

/**
 * Traduit les exceptions de reconnaissance d'ANTLR 3 en messages d'erreur
 * lisibles, en français.
 *
 * <p>ANTLR produit par défaut des messages anglais assez cryptiques
 * ("no viable alternative at input 'od'"). Cette classe est appelée depuis
 * {@code displayRecognitionError} (voir les sections {@code @members} de
 * While.g) pour produire par exemple : {@code attendu : 'fi', trouvé : 'od'}.
 */
public final class SyntaxErrors {

    private SyntaxErrors() { }

    /**
     * Message pour une erreur de l'analyseur syntaxique.
     *
     * @param e          exception levée par le parser
     * @param tokenNames table des noms de lexèmes ({@code WhileParser.tokenNames})
     */
    public static String describe(RecognitionException e, String[] tokenNames) {
        // L'ordre des tests compte : MissingToken et UnwantedToken héritent de MismatchedToken.
        if (e instanceof MissingTokenException) {
            MissingTokenException m = (MissingTokenException) e;
            return "il manque " + tokenName(m.expecting, tokenNames) + " avant " + tokenText(e.token);
        }
        if (e instanceof UnwantedTokenException) {
            UnwantedTokenException u = (UnwantedTokenException) e;
            return "lexème inattendu " + tokenText(u.getUnexpectedToken())
                    + " (attendu : " + tokenName(u.expecting, tokenNames) + ")";
        }
        if (e instanceof MismatchedTokenException) {
            MismatchedTokenException m = (MismatchedTokenException) e;
            return "attendu : " + tokenName(m.expecting, tokenNames) + ", trouvé : " + tokenText(e.token);
        }
        if (e instanceof MismatchedSetException) {
            return "lexème inattendu " + tokenText(e.token);
        }
        if (e instanceof NoViableAltException) {
            return "construction invalide à " + tokenText(e.token)
                    + " (commande, expression ou mot-clé attendu)";
        }
        if (e instanceof EarlyExitException) {
            return "il manque au moins un élément obligatoire (ex. une fonction, une commande) avant " + tokenText(e.token);
        }
        return "erreur de syntaxe à " + tokenText(e.token);
    }

    /* * Message pour une erreur de l'analyseur lexical (caractère non reconnu, ). */
    public static String describeLexical(RecognitionException e) {
        if (e.c == Token.EOF) return "fin de fichier inattendue (commentaire non fermé ?)";
        return "caractère inattendu " + charText(e.c);
    }

    // helpers

    /** Texte d'un lexème tel qu'il apparaît dans le source, entre quotes. */
    static String tokenText(Token t) {
        if (t == null) return "?";
        if (t.getType() == Token.EOF) return "la fin du fichier";
        return "'" + t.getText() + "'";
    }

    /* * Nom lisible d'un type de lexème : 'fi', Variable, Symbol, fin de fichier */
    static String tokenName(int type, String[] tokenNames) {
        if (type == Token.EOF) return "fin de fichier";
        if (tokenNames != null && type >= 0 && type < tokenNames.length) {
            String n = tokenNames[type];
            if ("Variable".equals(n)) return "une Variable (identifiant commençant par une majuscule)";
            if ("Symbol".equals(n)) return "un Symbol (identifiant commençant par une minuscule)";
            return n;   // les mots-clés sont déjà de la forme 'fi'
        }
        return "lexème n°" + type;
    }

    private static String charText(int c) {
        switch (c) {
            case '\n': return "'\\n'";
            case '\t': return "'\\t'";
            case '\r': return "'\\r'";
            default:   return "'" + (char) c + "'";
        }
    }
}
