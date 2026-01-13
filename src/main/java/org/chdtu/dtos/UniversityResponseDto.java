package org.chdtu.dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UniversityResponseDto {
    private Long id;
    private String name;
    private String city;
    private List<CourseResponseDto> courses;
}