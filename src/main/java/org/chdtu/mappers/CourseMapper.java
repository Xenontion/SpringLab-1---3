package org.chdtu.mappers;

import org.chdtu.dtos.CourseRequestDto;
import org.chdtu.dtos.CourseResponseDto;
import org.chdtu.entities.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    // DTO -> Entity (для використання в CourseServiceImpl)
    public Course toEntity(CourseRequestDto dto) {
        if (dto == null) return null;

        Course course = new Course();
        course.setTitle(dto.getTitle());
        // University Entity буде знайдено та встановлено у Сервісі

        return course;
    }

    // Entity -> DTO (для використання в Controller)
    public CourseResponseDto toResponseDto(Course course) {
        if (course == null) return null;

        CourseResponseDto dto = new CourseResponseDto();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());

        if (course.getUniversity() != null) {
            dto.setUniversityId(course.getUniversity().getId());
            dto.setUniversityName(course.getUniversity().getName());
        }

        return dto;
    }
}