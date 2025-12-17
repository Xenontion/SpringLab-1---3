package org.chdtu.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetDto {
    private Long id;
    private String name;
    private int age;
    private Long ownerId; // Для зв'язку
}