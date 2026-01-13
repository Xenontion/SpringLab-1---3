package org.chdtu.services;

import org.chdtu.entities.University;
import org.chdtu.dtos.UniversityRequestDto;
import org.chdtu.mappers.UniversityMapper;
import org.chdtu.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;
    private final UniversityMapper universityMapper;

    @Autowired
    public UniversityServiceImpl(UniversityRepository universityRepository, UniversityMapper universityMapper) {
        this.universityRepository = universityRepository;
        this.universityMapper = universityMapper;
    }

    @Override
    public University saveUniversity(University university) {
        return universityRepository.save(university);
    }

    // Для READ методів ми зберігаємо сигнатуру повернення Entity,
    // щоб Контролер міг конвертувати її в DTO.
    @Override
    @Transactional
    public University getUniversityById(Long id) {
        University university = universityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found with id: " + id));

        // Ініціалізація LAZY-колекції (Courses) перед поверненням в Контролер.
        // Це дозволяє Мапперу пізніше працювати з DTO.
        university.getCourses().size();

        return university;
    }

    @Override
    @Transactional
    public List<University> getAllUniversities() {
        List<University> universities = universityRepository.findAll();
        // Ініціалізація LAZY колекцій для Контролера
        universities.forEach(u -> u.getCourses().size());
        return universities;
    }

    @Override
    public void deleteUniversity(Long id) {
        universityRepository.deleteById(id);
    }
}