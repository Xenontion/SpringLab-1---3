package org.chdtu.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pets")
@Getter
@Setter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    // OneToOne: Зв'язок на стороні, що НЕ володіє.
    @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Person owner;
}