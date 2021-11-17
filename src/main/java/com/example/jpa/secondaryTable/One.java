package com.example.jpa.secondaryTable;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@SecondaryTable(name = One.TWO_TABLE)
public class One {
    static final String TWO_TABLE = "two";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(table = TWO_TABLE)
    private String address;

//    @Column
//    private Integer version;
}
