package com.example.jpa.workflow;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class ContentWorkflow extends Workflow {
    @Override
    public String execute() {
        return "content workflow " + id + " do action";
    }
}
