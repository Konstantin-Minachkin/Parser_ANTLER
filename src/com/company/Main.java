package com.company;

import com.company.antlr.ExprLexer;
import com.company.antlr.ExprParser;
import com.company.ast.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static List<StmtNode> convertProgram(List<ExprParser.OperatorContext> ocs) {
        List<StmtNode> list = new ArrayList<>();
        for (ExprParser.OperatorContext oc : ocs) {
            StmtNode stmtNode = convertStatement(oc);
            list.add(stmtNode);
        }
        return list;
    }

    private static List<StmtNode> convertProgram(ExprParser.ProgramContext c) {
        return convertProgram(c.operator());
    }

    private static ExprNode convertValue(ExprParser.ValueContext c) {
        if (c.number() != null) { //!
            if (c.number().ARABIAN() != null)
                return new NumberNode(c.number().ARABIAN().getSymbol());
            else if (c.number().ROME() != null)
                return new NumberNode(c.number().ROME().getSymbol());
        } else if (c.ID() != null) {
            return new VarNode(c.ID().getSymbol());
        }
        return null;
    }

    private static StmtNode convertStatement(ExprParser.OperatorContext c) {
        if (c.dowhile() != null) {
            List<StmtNode> body = convertProgram(c.dowhile().prog);
            ExprNode left = convertValue(c.dowhile().cond.left),
                    right = convertValue(c.dowhile().cond.right);
            Token cmp = c.dowhile().cond.cmp;
            BinOpNode condition = new BinOpNode(cmp, left, right);
            return new WhileNode(body, condition);
        }
//        else if (c.dec() != null) {
//            if (c.dec().value().ID() != null) //убр?
//                return new DecNode(c.dec().value().ID().getSymbol());
//        }
        else if (c.incDec() != null) {
           // if (c.inc().value().ID() != null) //убр?
                return new UnarNode(c.incDec().ID().getSymbol(), c.incDec().op);
        } else if (c.print() != null) {
            return new PrintNode(convertValue(c.print().value())); //!
//            if (c.print().value().ID() != null) return new PrintNode(new VarNode(c.print().value().ID().getSymbol()));
//            else if (c.print().value().NUMBER() != null) return new PrintNode(new NumberNode(c.print().value().NUMBER().getSymbol()));
        }
        return null;
    }

    public static void main(String[] args) {
        String text="do x++; print XCCXCVIV; print I123X; do print x; while III = II; while x < X;";
        ExprLexer lex = new ExprLexer(CharStreams.fromString(text));
        ExprParser parser = new ExprParser(new CommonTokenStream(lex));
        parser.addErrorListener(new ConsoleErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                    int line, int charPositionInLine, String msg, RecognitionException e) {
                super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
                throw new ParseCancellationException();
            }
        });
        try {
            ExprParser.ProgramContext c = parser.program();
            List<StmtNode> program = convertProgram(c);
            Interpreter inter = new Interpreter();
            Map<String, Integer> vars = new HashMap<>();
            vars.put("x", 7);
            inter.evalProgram(program, vars);
        } catch (ParseCancellationException ex) {
            // ignore
        }
    }
}

//set PATH=C:\Program Files\Java\jdk1.8.0_25\bin;%PATH%
//java -jar antlr-4.7.2-complete.jar -package com.company.antlr -o src/com/company/antlr -no-listener Expr.g

//Чем это плохо? 1.Лучше не использовать несколько объявлений в одной строке (Main.convertStatement, BinOpNode)
// Исправил 2. Можно объединить классы IncNode и DecNode и правила inc и dec, т.к. они очень похожи - можно добавить
//               унарную операцию (++ или --) в AST.
//   Исправил 3. По вашей грамматике можно написать оператор "123++;".Я предлагаю все же запретить такую конструкцию,
//               для вашего простого языка это легко сделать на уровне грамматики. Соответственно проверка
//               ID() != null в convertStatement будет уже не нужна.
//   Исправил  4. Для аргумента print в convertStatement можно воспользоваться convertValue.
//    Исправил    5. В Interpretor.evalStatement для PrintNode можно использовать evalExpression для вычисления значения аргумента
//     Исправил         print - пусть всегда выводит значение арабскими цифрами {в interpreter.EvalExpression (в самом первом ифе это есть)}
//     Исправил         (да, и правильное название класса должно быть InterpretEr ).
//    Исправил    6. Если уж в вашем языке вы поддерживаете и арабские, и римские числа, лучше их различать на уровне лексера.
//                  Сейчас если у вас каждое число при при выполнении проверяется на соответствие шаблону [0-9]+, и
//                  если это делается в цикле, который выполняется миллион раз, затраты будут существенные.
//                  Лучше, чтобы лексер генерировал разные типы лексем для арабских и римских чисел
//                  (в AST можно оставить один тип узла NumberNode, и различать их по Token.getType).
//   Почему странно?? Это будет ID            Кроме того, у вас сейчас разрешается написать "print I123X;", что странно.
//   Исправил     7. Перевод из римских чисел работает не всегда корректно: XL должно быть равно 40, а у вас 49.