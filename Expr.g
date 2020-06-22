grammar Expr;

all_program: program EOF;
program: (operator';')*;
operator: dowhile|incDec|print;
dowhile: 'do' prog=program 'while' cond=condition;
condition: left=value cmp=(SMALLERTHAN|BIGGERTHAN|EQUAL) right=value;
value: number|ID;
number: ARABIAN | ROME;
incDec: ID op=(INCREM|DECREM);
print: 'print'text=value;

ARABIAN: [0-9]+;
ROME: [IXCDMLV]+;
ID: [a-zA-Z_][a-zA-Z_0-9]*;
WS: [ \t\r\n]+ -> skip;

SMALLERTHAN: '<';
BIGGERTHAN: '>';
EQUAL: '=';
INCREM: '++';
DECREM: '--';
