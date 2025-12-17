package org.chdtu.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequestDto {
    private String title;
    private Long universityId;
}