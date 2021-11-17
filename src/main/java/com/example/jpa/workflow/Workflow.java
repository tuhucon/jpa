package com.example.jpa.workflow;

import lombok.Data;

import javax.persistence.*;

@Entity
@DiscriminatorColumn (
        name = "workflow_type",
        discriminatorType = DiscriminatorType.INTEGER
)
@Data
public class Workflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Embedded
    State state;

    public String execute() {
        return "Workflow " + id + " do action";
    }
}

