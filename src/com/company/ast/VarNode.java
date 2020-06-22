package com.company.ast;
import org.antlr.v4.runtime.Token;

/**
 * Created by Kostya on 22.10.2019.
 */
public class VarNode extends ExprNode {
    public Token id;
    public VarNode (Token id){
        this.id = id;
    }
}
