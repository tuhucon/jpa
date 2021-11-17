package com.example.jpa;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
@Data
public class H1A extends H1 {
    @Override
    public String toString() {
        return "H1A class: " + id;
    }
}
