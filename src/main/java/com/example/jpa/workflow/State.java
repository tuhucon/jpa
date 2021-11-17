package com.example.jpa.workflow;

import lombok.Data;

import javax.persistence.*;

@Embeddable
@Data
public class State {

    @Column(name = "state_value")
    Integer state;

    @Column(name = "state_type")
    Integer type;

    @Transient
    State origin;

    public String execute() {
        return getOriginState().execute();
    }

    public State getOriginState() {
        if (origin == null) {
            origin = StateFactory.getState(type);
        }
        return origin;
    }
}
