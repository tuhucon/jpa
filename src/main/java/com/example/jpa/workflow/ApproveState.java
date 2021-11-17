package com.example.jpa.workflow;

@StateType(type = 1)
public class ApproveState extends State {
    public ApproveState() {
        state = 1;
        type = 1; // type phai giong trong khai bao @StateType cua class
    }

    @Override
    public String execute() {
        return "Approve State " + " execute";
    }
}
