package org.chdtu.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponseDto {
    private Long id;
    private String title;
    private Long universityId;
    private String universityName;
}