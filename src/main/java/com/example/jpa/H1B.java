package com.example.jpa;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
@Data
public class H1B extends H1 {
    @Override
    public String toString() {
        return "H1B class: " + id;
    }
}
