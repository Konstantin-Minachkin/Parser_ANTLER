package com.company.ast;

import org.antlr.v4.runtime.Token;

/**
 * Created by Kostya on 22.10.2019.
 */
public class BinOpNode extends ExprNode {
    public Token op;
    public ExprNode left, right;
    public BinOpNode(Token op, ExprNode left, ExprNode right){
        this.op = op;
        this.left = left;
        this.right = right;
    }
}
