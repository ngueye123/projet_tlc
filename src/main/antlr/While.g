
grammar While;

options {
    output = AST;
    backtrack = true;
    memoize = true;
}

// Jetons imaginaires : étiquettes des noeuds de l'AST
tokens {
    PROGRAM;
    FUNCTION;
    INPUTS;
    OUTPUTS;
    COMMANDS;
    ASSIGN;
    VARS;
    EXPRS;
    IF;
    WHILE;
    FOR;
    FOREACH;
    NOP;
    NIL;
    VAR;
    ATOM;
    CALL;
    CONS;
    LIST;
    HD;
    TL;
    EQ;
}

@header {
    package fr.tlc.whilecompiler;
}

@lexer::header {
    package fr.tlc.whilecompiler;
}

// Gestion des commentaires
COMMENT
    : '//' ~('\r' | '\n')* ('\r'? '\n' | EOF) {$channel=HIDDEN;}
    | '/*' (options {greedy=false;} : .)* '*/' {$channel=HIDDEN;}
    ;

WS
    : (' ' | '\t' | '\r' | '\n')+ {$channel=HIDDEN;}
    ;

// Programme principal
program
    : function+ EOF -> ^(PROGRAM function+)
    ;

// Déclaration d'une fonction
function
    : 'function' name=Symbol ':' 'read'
      in=inputs '%' cmd=commands '%' 'write' out=outputs
      -> ^(FUNCTION $name $in $cmd $out)
    ;

// Liste des entrées (peut être vide)
inputs
    : (Variable (',' Variable)*)?
      -> ^(INPUTS Variable*)
    ;

// Liste des sorties
outputs
    : Variable (',' Variable)*
      -> ^(OUTPUTS Variable+)
    ;

// Liste des commandes
commands
    : command (';' command)*
      -> ^(COMMANDS command+)
    ;

// Différents types de commandes
command
    : 'nop'
      -> NOP

    | vars ':=' exprs
      -> ^(ASSIGN vars exprs)

    | 'if' expression 'then' yes=commands 'else' no=commands 'fi'
      -> ^(IF expression $yes $no)

    | 'if' expression 'then' yes=commands 'fi'
      -> ^(IF expression $yes)

    | 'while' expression 'do' commands 'od'
      -> ^(WHILE expression commands)

    | 'for' expression 'do' commands 'od'
      -> ^(FOR expression commands)

    | 'foreach' Variable 'in' expression 'do' commands 'od'
      -> ^(FOREACH Variable expression commands)
    ;

// Liste de variables
vars
    : Variable (',' Variable)*
      -> ^(VARS Variable+)
    ;

// Liste d'expressions
exprs
    : expression (',' expression)*
      -> ^(EXPRS expression+)
    ;

// Test d'égalité entre deux expressions
expression
    : left=exprBase '=?' right=exprBase
      -> ^(EQ $left $right)

    | exprBase
      -> exprBase
    ;

// Expressions de base
exprBase
    : 'nil'
      -> NIL

    | Variable
      -> ^(VAR Variable)

    | Symbol
      -> ^(ATOM Symbol)

    | '(' 'cons' exprBase* ')'
      -> ^(CONS exprBase*)

    | '(' 'list' exprBase* ')'
      -> ^(LIST exprBase*)

    | '(' 'hd' exprBase ')'
      -> ^(HD exprBase)

    | '(' 'tl' exprBase ')'
      -> ^(TL exprBase)

    | '(' functionName=Symbol exprBase* ')'
      -> ^(CALL $functionName exprBase*)
    ;

// Variable : commence par une majuscule
// Symbole : commence par une minuscule
Variable
    : Maj (Maj | Min | Dec)* ('!' | '?')?
    ;

Symbol
    : Min (Maj | Min | Dec)* ('!' | '?')?
    ;

fragment Maj : 'A'..'Z';
fragment Min : 'a'..'z';
fragment Dec : '0'..'9';
