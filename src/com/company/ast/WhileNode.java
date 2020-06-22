package com.company.ast;

import java.util.List;

/**
 * Created by user on 12.11.2019.
 */
public class WhileNode extends StmtNode {
    public List<StmtNode> program;
    public BinOpNode condition;

    public WhileNode(List<StmtNode> program, BinOpNode condition){
        this.program = program;
        this.condition = condition;
    }
}
