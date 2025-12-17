package org.chdtu.services;

import org.chdtu.entities.University;
import java.util.List;

public interface UniversityService {
    University saveUniversity(University university);
    University getUniversityById(Long id);
    List<University> getAllUniversities();
    void deleteUniversity(Long id);
}