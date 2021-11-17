package com.example.jpa;

import lombok.Data;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(
        name = "type",
        discriminatorType = DiscriminatorType.INTEGER
)
@Data
public class H2 {
    @Id
    Long id;

//    @Column(name = "h1_id")
//    Long H1Id;

    @OneToOne
    @JoinColumn(name = "h1_id")
    H1 h1;
}
