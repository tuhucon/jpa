package com.example.jpa.workflow;

import com.example.jpa.workflow.Workflow;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class LegalWorkflow extends Workflow {
    @Override
    public String execute() {
        return "Legal Workflow " + id + " do action";
    }
}
