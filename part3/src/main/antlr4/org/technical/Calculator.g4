grammar Calculator;

// Parser

start : expression;

expression
   : NUMBER                                                 # Number
   | LEFT_PARENTHESIS inner=expression RIGHT_PARENTHESIS    # Parentheses
   | left=expression operator=CARET right=expression        # Power
   | MINUS right=expression                                 # Negation
   | left=expression operator=(STAR|SLASH) right=expression # MultiplicationOrDivision
   | left=expression operator=(PLUS|MINUS) right=expression # AdditionOrSubtraction
   ;

// Lexer

PLUS: '+';
MINUS: '-';
STAR: '*';
SLASH: '/';
LEFT_PARENTHESIS: '(';
RIGHT_PARENTHESIS: ')';
CARET: '^';
NUMBER: [0-9]+;
WORD: [a-zA-Z]+;
WHITESPACE: [ \r\n\t]+ -> skip;