package com.example.jpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class H2B extends H2 {
    @Override
    public String toString() {
        return "H2B Class: " + id;
    }
}
