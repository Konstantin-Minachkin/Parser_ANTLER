package com.company.ast;

import org.antlr.v4.runtime.Token;

/**
 * Created by Kostya on 22.10.2019.
 */
public class NumberNode extends ExprNode {
    public Token number;
    public NumberNode (Token numb){
        number = numb;
    }
}
