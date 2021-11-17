package com.example.jpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class H2A extends H2{
    @Override
    public String toString() {
        return "H2A class: " + id;
    }
}
