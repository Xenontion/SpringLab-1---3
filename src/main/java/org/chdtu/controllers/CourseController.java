package org.chdtu.controllers;

import org.chdtu.dtos.CourseRequestDto;
import org.chdtu.dtos.CourseResponseDto;
import org.chdtu.entities.Course;
import org.chdtu.mappers.CourseMapper;
import org.chdtu.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    // CREATE: 201 Created
    @PostMapping
    public ResponseEntity<CourseResponseDto> createCourse(@RequestBody CourseRequestDto requestDto) {
        Course savedCourse = courseService.saveNewCourse(requestDto);
        CourseResponseDto responseDto = courseMapper.toResponseDto(savedCourse);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // READ By ID: 200 OK
    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        CourseResponseDto responseDto = courseMapper.toResponseDto(course);
        return ResponseEntity.ok(responseDto);
    }

    // READ All: 200 OK
    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> getAllCourses() {
        List<CourseResponseDto> courses = courseService.getAllCourses().stream()
                .map(courseMapper::toResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(courses);
    }

    // DELETE: 204 No Content
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}