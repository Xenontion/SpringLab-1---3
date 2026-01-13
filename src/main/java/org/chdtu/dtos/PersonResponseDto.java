package org.chdtu.dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class PersonResponseDto {
    private Long id;
    private String name;
    private int age;
    private PetDto pet;
    private Set<Long> enrolledCourseIds;
}