package org.chdtu.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRequestDto {
    private String name;
    private int age;
    private PetDto pet; // OneToOne
    private Long universityId; // Для прикладу
    // Для ManyToMany потрібен Set<Long> courseIds;
}