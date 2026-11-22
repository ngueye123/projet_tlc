/*
 *  While.g  -  Grammaire ANTLR 3 du langage While (front-end du compilateur)
 *
 *  Rôle : analyse lexicale + analyse syntaxique + construction de l'AST.
 *
 *  La grammaire suit la spécification "Specifications_while.pdf" (section A).
 *  Elle est décorée par des règles de réécriture (->) qui produisent un
 *  arbre de syntaxe abstraite (AST) dont la forme est décrite ci-dessous.
 *  Cette forme est un CONTRAT pour les passes suivantes (analyse sémantique,
 *  génération de code 3 adresses) : ne pas la modifier sans prévenir l'équipe.
 *
 * Forme de l'AST (notation ANTLR ^(racine fils)) :
 *
 *    PROGRAM  -> ^(PROGRAM FUNCTION+)
 *    FUNCTION -> ^(FUNCTION Symbol ^(INPUT Variable*) ^(COMMANDS cmd+) ^(OUTPUT Variable+))
 *    cmd      -> NOP
 *              | ^(ASSIGN ^(VARS Variable+) ^(EXPRS expr+))
 * | ^(IF expr ^(COMMANDS ) ^(COMMANDS )?)      (2e COMMANDS = else)
 * | ^(WHILE expr ^(COMMANDS ))
 * | ^(FOR expr ^(COMMANDS ))
 * | ^(FOREACH Variable expr ^(COMMANDS ))
 *    expr     -> NIL | Variable | Symbol
 *              | ^(CONS expr*) | ^(LIST expr*) | ^(HD expr) | ^(TL expr)
 *              | ^(CALL Symbol expr*) | ^(EQ expr expr)
 *
 * Les nœuds "imaginaires" (PROGRAM, FUNCTION, IF, ) sont créés avec la
 *  position (ligne/colonne) du mot-clé source correspondant, grâce à la
 *  syntaxe IMAG[$tok, "TEXTE"]. Ainsi getLine() fonctionne sur tous les
 *  nœuds de l'AST, ce qui permet des messages d'erreur précis.
 *
 *  Gestion des erreurs : au lieu d'afficher les erreurs sur stderr (comportement
 *  par défaut d'ANTLR), lexer et parser les transmettent à un ErrorReporter
 *  (whilec.diagnostics) avec un message en français.
 */
grammar While;

options {
  output = AST;          // le parser construit un arbre (CommonTree)
  ASTLabelType = CommonTree;
}

/* Lexèmes imaginaires : ils n'apparaissent pas dans le texte source,
 * ils servent uniquement d'étiquettes aux nœuds de l'AST. */
tokens {
  PROGRAM; FUNCTION; INPUT; OUTPUT; COMMANDS;
  ASSIGN; VARS; EXPRS;
  IF; WHILE; FOR; FOREACH; NOP;
  NIL; CONS; LIST; HD; TL; CALL; EQ;
}

@parser::header { package whilec.frontend; import whilec.diagnostics.ErrorReporter; }
@lexer::header  { package whilec.frontend; import whilec.diagnostics.ErrorReporter; }

@parser::members {
  /** Collecteur d'erreurs (positionné par Frontend avant l'analyse). */
  private ErrorReporter reporter;
  public void setErrorReporter(ErrorReporter r) { this.reporter = r; }

  /** Redirige les erreurs de syntaxe vers le reporter, en français. */
  @Override
  public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    String msg = SyntaxErrors.describe(e, tokenNames);
    if (reporter != null) reporter.syntaxError(e.line, e.charPositionInLine, msg);
    else super.displayRecognitionError(tokenNames, e);
  }
}

@lexer::members {
  private ErrorReporter reporter;
  public void setErrorReporter(ErrorReporter r) { this.reporter = r; }

  /* * Erreurs lexicales (caractère inconnu, ) envoyées au reporter. */
  @Override
  public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    String msg = SyntaxErrors.describeLexical(e);
    if (reporter != null) reporter.lexicalError(e.line, e.charPositionInLine, msg);
    else super.displayRecognitionError(tokenNames, e);
  }
}

/* Règles */

/* Program -> Function Program | Function */
program
  : function+ EOF -> ^(PROGRAM function+)
  ;

/* Function -> 'function' Symbol ':' Definition */
function
  : k='function' Symbol ':' definition
      -> ^(FUNCTION[$k, "FUNCTION"] Symbol definition)
  ;

/* Definition -> 'read' Input '%' Commands '%' 'write' Output
 * Produit trois fils : INPUT, COMMANDS, OUTPUT (le Symbol est ajouté par function). */
definition
  : r='read' input '%' commands '%' w='write' output
      -> ^(INPUT[$r, "INPUT"] input?) commands ^(OUTPUT[$w, "OUTPUT"] output)
  ;

/* Input -> InputSub | epsilon ; InputSub -> Variable ',' InputSub | Variable */
input
  : (Variable (',' Variable)*)? -> Variable*
  ;

/* Output -> Variable ',' Output | Variable  (au moins une valeur de retour) */
output
  : Variable (',' Variable)* -> Variable+
  ;

/* Commands -> Command ';' Commands | Command
 * Le ';' est un séparateur : il disparaît de l'AST. */
commands
  : c=command (';' command)* -> ^(COMMANDS[$c.start, "COMMANDS"] command+)
  ;

command
  /* Command -> 'nop' */
  : k='nop' -> NOP[$k, "NOP"]

  /* Command -> Vars ':=' Exprs  (affectation simple ou multiple) */
  | vars k=':=' exprs -> ^(ASSIGN[$k, "ASSIGN"] vars exprs)

  /* Command -> 'if' Expression 'then' Commands ['else' Commands] 'fi' */
  | k='if' expression 'then' c1=commands ('else' c2=commands)? 'fi'
      -> ^(IF[$k, "IF"] expression $c1 $c2?)

  /* Command -> 'while' Expression 'do' Commands 'od' */
  | k='while' expression 'do' commands 'od'
      -> ^(WHILE[$k, "WHILE"] expression commands)

  /* Command -> 'for' Expression 'do' Commands 'od' */
  | k='for' expression 'do' commands 'od'
      -> ^(FOR[$k, "FOR"] expression commands)

  /* Command -> 'foreach' Variable 'in' Expression 'do' Commands 'od' */
  | k='foreach' Variable 'in' expression 'do' commands 'od'
      -> ^(FOREACH[$k, "FOREACH"] Variable expression commands)
  ;

/* Vars -> Variable ',' Vars | Variable */
vars
  : v=Variable (',' Variable)* -> ^(VARS[$v, "VARS"] Variable+)
  ;

/* Exprs -> Expression ',' Exprs | Expression */
exprs
  : e=expression (',' expression)* -> ^(EXPRS[$e.start, "EXPRS"] expression+)
  ;

/* Expression -> ExprBase | ExprBase '=?' ExprBase */
expression
  : a=exprBase ( k='=?' b=exprBase -> ^(EQ[$k, "EQ"] $a $b)
               |                   -> $a
               )
  ;

/* ExprBase : expressions de base. Les parenthèses disparaissent de l'AST. */
exprBase
  : k='nil'                       -> NIL[$k, "NIL"]
  | Variable                                          // variable : feuille de type Variable
  | Symbol                                            // symbole constant : feuille de type Symbol
  | '(' k='cons' lexpr ')'        -> ^(CONS[$k, "CONS"] lexpr?)
  | '(' k='list' lexpr ')'        -> ^(LIST[$k, "LIST"] lexpr?)
  | '(' k='hd'   exprBase ')'     -> ^(HD[$k, "HD"] exprBase)
  | '(' k='tl'   exprBase ')'     -> ^(TL[$k, "TL"] exprBase)
  | '(' s=Symbol lexpr ')'        -> ^(CALL[$s, "CALL"] Symbol lexpr?)   // appel de fonction
  ;

/* LExpr -> ExprBase LExpr | epsilon */
lexpr
  : exprBase*
  ;

/* Lexèmes */

/* Variable = Maj (Maj|Min|Dec)* ('!'|'?')? */
Variable : 'A'..'Z' ('A'..'Z' | 'a'..'z' | '0'..'9')* ('!' | '?')? ;

/* Symbol = Min (Maj|Min|Dec)* ('!'|'?')?
 * Les mots-clés (nil, cons, if, ) sont prioritaires : ce sont des lexèmes
 * implicites définis par les chaînes 'xxx' utilisées dans les règles. */
Symbol   : 'a'..'z' ('A'..'Z' | 'a'..'z' | '0'..'9')* ('!' | '?')? ;

/* Blancs et commentaires : envoyés sur le canal caché (ignorés par le parser). */
WS       : (' ' | '\t' | '\r' | '\n')+ { $channel = HIDDEN; } ;
COMMENT  : '//' ~('\n' | '\r')*         { $channel = HIDDEN; } ;
ML_COMMENT : '/*' ( options { greedy = false; } : . )* '*/' { $channel = HIDDEN; } ;
