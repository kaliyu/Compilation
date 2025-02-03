grammar bibi;

// 1. Lexèmes de base
types       : 'bool' | 'int' | 'float';

ID          : [a-zA-Z_][a-zA-Z0-9_]*;  // Identifiants, commencent par une lettre ou un underscore
INT         : [0-9]+;                   // Entiers
FLOAT       : [0-9]+ '.' [0-9]+ | [0-9]+ '.' ; // Flottants sous forme x.y ou x.
BOOL        : 'true' | 'false';         // Booléens
WS          : [ \t\n\r]+ -> skip;       // Espaces blancs

// 2. Expressions
expr        : expr ('+'|'-'|'*'|'/'|'%'| '=='| '<'| '>'| '&&'|'||') expr
            | '(' expr ')'
            | BOOL
            | INT
            | FLOAT
            | ID
            | ID '[' expr ']'    // Accès à un élément de tableau
            ;

// 3. Instructions
prog      : stmt+;

stmt        : print_stmt  #print
            | read_stmt  #read
            | assign_stmt  #assign
            | decl_stmt  #decl
            | cond_stmt  #cond
            | while_stmt  #while
            | ID '++' ';'  #increment
            | ID '--' ';'  #decrement
            ;

print_stmt  : 'print' expr ';';

read_stmt   : 'read' ID ';';

assign_stmt : ID '=' expr ';';

decl_stmt   : types ID ('[' INT ']')? ('=' expr)? ';';  // Déclaration avec initialisation optionnelle

cond_stmt   : 'if' '(' expr ')' block ('else' block)?;

while_stmt  : 'while' '(' expr ')' block;

block       : '{' stmt* '}';

// 4. Programmes
programme    : prog;