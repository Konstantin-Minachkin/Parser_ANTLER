package com.company.ast;

import org.antlr.v4.runtime.Token;

/**
 * Created by Kostya on 10.12.2019.
 */
public class UnarNode extends StmtNode {
    public Token operand;
    public Token operator;

    public UnarNode(Token operand, Token operator) {
            this.operand = operand;
            this.operator = operator;
        }
}
