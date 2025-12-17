package org.chdtu.mappers;

import org.chdtu.dtos.UniversityRequestDto;
import org.chdtu.dtos.UniversityResponseDto;
import org.chdtu.entities.University;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class UniversityMapper {

    private final CourseMapper courseMapper;

    public UniversityMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    // DTO -> Entity (для використання в UniversityServiceImpl)
    public University toEntity(UniversityRequestDto dto) {
        if (dto == null) return null;

        University university = new University();
        university.setName(dto.getName());
        university.setCity(dto.getCity());

        return university;
    }

    // Entity -> DTO (для використання в Controller)
    public UniversityResponseDto toDto(University university) {
        if (university == null) return null;

        UniversityResponseDto dto = new UniversityResponseDto();
        dto.setId(university.getId());
        dto.setName(university.getName());
        dto.setCity(university.getCity());

        if (university.getCourses() != null && !university.getCourses().isEmpty()) {
            dto.setCourses(university.getCourses().stream()
                    .map(courseMapper::toResponseDto)
                    .collect(Collectors.toList()));
        }

        return dto;
    }
}