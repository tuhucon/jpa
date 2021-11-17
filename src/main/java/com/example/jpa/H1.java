package com.example.jpa;

import lombok.Data;

import javax.persistence.*;

@Entity
@Inheritance
@DiscriminatorColumn(
        name = "type",
        discriminatorType = DiscriminatorType.INTEGER
)
@Data
public class H1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(mappedBy = "h1")
    H2 h2;
}
