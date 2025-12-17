package org.chdtu.controllers;

import org.chdtu.dtos.UniversityResponseDto;
import org.chdtu.entities.University;
import org.chdtu.mappers.UniversityMapper;
import org.chdtu.services.UniversityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    private final UniversityService universityService;
    private final UniversityMapper universityMapper;

    public UniversityController(UniversityService universityService, UniversityMapper universityMapper) {
        this.universityService = universityService;
        this.universityMapper = universityMapper;
    }

    // CREATE: 201 Created (Приймає Entity, оскільки у нас немає UniversityRequestDto, що вимагає складних зв'язків)
    @PostMapping
    public ResponseEntity<UniversityResponseDto> createUniversity(@RequestBody University university) {
        University savedUniversity = universityService.saveUniversity(university);
        UniversityResponseDto responseDto = universityMapper.toDto(savedUniversity);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // READ By ID: 200 OK
    @GetMapping("/{id}")
    public ResponseEntity<UniversityResponseDto> getUniversityById(@PathVariable Long id) {
        University university = universityService.getUniversityById(id);
        UniversityResponseDto responseDto = universityMapper.toDto(university);
        return ResponseEntity.ok(responseDto);
    }

    // READ All: 200 OK
    @GetMapping
    public ResponseEntity<List<UniversityResponseDto>> getAllUniversities() {
        List<UniversityResponseDto> universities = universityService.getAllUniversities().stream()
                .map(universityMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(universities);
    }

    // DELETE: 204 No Content
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable Long id) {
        universityService.deleteUniversity(id);
        return ResponseEntity.noContent().build();
    }
}