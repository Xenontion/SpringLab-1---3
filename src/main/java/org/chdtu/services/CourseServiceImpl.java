package org.chdtu.services;

import org.chdtu.dtos.CourseRequestDto;
import org.chdtu.entities.Course;
import org.chdtu.entities.University;
import org.chdtu.mappers.CourseMapper;
import org.chdtu.repositories.CourseRepository;
import org.chdtu.repositories.UniversityRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final UniversityRepository universityRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, UniversityRepository universityRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.universityRepository = universityRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    @Transactional
    public Course saveNewCourse(CourseRequestDto courseDto) {
        // 1. DTO -> Entity (без University)
        Course course = courseMapper.toEntity(courseDto);

        // 2. Логіка зв'язку ManyToOne: Знайти та встановити University
        if (courseDto.getUniversityId() != null) {
            University university = universityRepository.findById(courseDto.getUniversityId())
                    .orElseThrow(() -> new RuntimeException("University not found with id: " + courseDto.getUniversityId()));
            course.setUniversity(university);
        } else {
            throw new IllegalArgumentException("University ID must be provided for the course.");
        }

        return courseRepository.save(course);
    }

    @Override
    // Оскільки зв'язок ManyToOne з University EAGER, додаткова @Transactional тут не потрібна для університету.
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}