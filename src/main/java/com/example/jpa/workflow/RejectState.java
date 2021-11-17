package com.example.jpa.workflow;

import com.example.jpa.workflow.State;
import com.example.jpa.workflow.StateType;

@StateType(type = 2)
public class RejectState extends State {
    public RejectState() {
        state = 2;
        type = 2;  // type phai giong trong khai bao @StateType cua class
    }

    @Override
    public String execute() {
        return "Reject state execute";
    }
}
