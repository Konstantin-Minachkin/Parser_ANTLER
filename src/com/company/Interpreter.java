package com.company;

import com.company.antlr.ExprLexer;
import com.company.ast.*;
import org.antlr.v4.runtime.Token;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Kostya on 19.11.2019.
 */
public class Interpreter {

    Interpreter() {    }

    void evalProgram(List<StmtNode> program, Map<String, Integer> vars) {
        for (StmtNode s : program) evalStatement(s, vars);
    }

    private int getVar(Token id, Map<String, Integer> vars) {
        Integer value = vars.get(id.getText());
        if (value != null) return value; //тут поиск по мэпу и return нужного эелемента
        else {
            System.out.println("Need input for "+id.getText());
            Scanner in = new Scanner(System.in);
            //добавим возможность ввода римских чисел
            String val = in.nextLine();
            int id_val;
            if (val.matches("[0-9]+")) id_val = Integer.valueOf(val);
            else id_val=RomanToInt(val);
            vars.put(id.getText(), id_val); //для запоминания вбиваемых данных через консоль
            //----
            //int id_val = in.nextInt()
            return id_val;
        }
    }

    void evalStatement(StmtNode stmt, Map<String, Integer> vars) {
        if (stmt instanceof PrintNode) {
            PrintNode n = (PrintNode) stmt;
            System.out.println(evalExpression(n.val, vars)); //!
//            if (n.val instanceof NumberNode) {
//                NumberNode nn = (NumberNode) n.val;
//                System.out.println(nn.number.getText());
//            } else if (n.val instanceof VarNode) {
//                VarNode nn = (VarNode) n.val;
//                System.out.println(vars.get(nn.id.getText()));
//            }
        } else if (stmt instanceof WhileNode) {
            WhileNode wn = (WhileNode) stmt;
            do
                for (StmtNode s : wn.program) evalStatement(s, vars);
            while (evalExpression(wn.condition, vars) == 1);
        } else if (stmt instanceof UnarNode) { //!
            UnarNode n = (UnarNode) stmt;
            int num = getVar(n.operand, vars);
            if (n.operator.getType() == ExprLexer.INCREM) num++;
            else if (n.operator.getType() == ExprLexer.DECREM) num--;
            vars.put(n.operand.getText(), num);
        }
//        else if (stmt instanceof DecNode) {
//            DecNode n = (DecNode) stmt;
//            int num = getVar(n.operand, vars);
//            num--;
//            vars.put(n.operand.getText(), num);
//        }
    }

    int evalExpression(ExprNode n, Map<String, Integer> vars) {
        if (n instanceof NumberNode) {
            NumberNode nn = (NumberNode) n;
            if (nn.number.getType()==ExprLexer.ARABIAN) return Integer.parseInt(nn.number.getText());
            else if (nn.number.getType()==ExprLexer.ROME)
            {
                int num = RomanToInt(nn.number.getText());
                return num;
            }
//            if (nn.number.getText().matches("[0-9]+")) return Integer.parseInt(nn.number.getText());
//            else //перевод из римских в обычные числа
//            {
//                int num = RomanToInt(nn.number.getText());
//                return num;
//            }
        } else if (n instanceof VarNode) {
            VarNode nn = (VarNode) n;
            return getVar(nn.id, vars);
        } else if (n instanceof BinOpNode) {
            BinOpNode bn = (BinOpNode) n;
            int l = evalExpression(bn.left, vars);
            int r = evalExpression(bn.right, vars);
            if (bn.op.getType() == ExprLexer.SMALLERTHAN) {
                return l < r ? 1 : 0;
            } else if (bn.op.getType() == ExprLexer.BIGGERTHAN) {
                return l > r ? 1 : 0;
            } else if (bn.op.getType() == ExprLexer.EQUAL) {
                return l == r ? 1 : 0;
            }
        }
        return 0;
    }

    public static int RomanToInt(String roman) throws NumberFormatException
    {
        int last = letterToNumber(roman.charAt(0));
        int integerValue = 0;
        if (roman.length() == 1) integerValue+=last;
        for (int i = 1; i < roman.length(); i++)
        {
            int number = letterToNumber(roman.charAt(i));
            if ( number == -1)
            {
                throw new NumberFormatException("Invalid format");
            }
            if (last<number) {
                number-=last;
                integerValue += number;
                last = 2000;
            } else if (last == 2000) {
                last=number;
            }
            else {
                integerValue += last;
                last = number;
                if (i==roman.length()-1) integerValue += number;
            }
        }
        return integerValue;
    }

    private static int letterToNumber(char letter)
    {
        switch (letter) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            case 'C':  return 100;
            case 'D':  return 500;
            case 'M':  return 1000;
            default:   return -1;
        }
    }

}
