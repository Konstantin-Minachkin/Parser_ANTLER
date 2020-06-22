package com.company.ast;

/**
 * Created by user on 12.11.2019.
 */
public class PrintNode extends StmtNode {
    public ExprNode val;
    public PrintNode(ExprNode val){
        this.val = val;
    }
}
