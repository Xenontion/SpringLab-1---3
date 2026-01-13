package org.chdtu.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // ManyToOne: EAGER завантаження (за замовчуванням для ManyToOne).
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    // ManyToMany: LAZY завантаження (за замовчуванням для ManyToMany).
    @ManyToMany(mappedBy = "enrolledCourses", fetch = FetchType.LAZY)
    private Set<Person> students = new HashSet<>();
}