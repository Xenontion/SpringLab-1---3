package org.chdtu.services;

import org.chdtu.dtos.CourseRequestDto;
import org.chdtu.entities.Course;
import java.util.List;

public interface CourseService {
    Course saveNewCourse(CourseRequestDto courseDto);
    Course getCourseById(Long id);
    List<Course> getAllCourses();
    void deleteCourse(Long id);
}