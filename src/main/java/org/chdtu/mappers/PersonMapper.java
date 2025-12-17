package org.chdtu.mappers;

import org.chdtu.dtos.PersonRequestDto;
import org.chdtu.dtos.PersonResponseDto;
import org.chdtu.entities.Person;
import org.chdtu.entities.Pet;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    private final PetMapper petMapper;

    public PersonMapper(PetMapper petMapper) {
        this.petMapper = petMapper;
    }

    // НОВИЙ МЕТОД: DTO -> Entity (для використання в PersonServiceImpl)
    public Person toEntity(PersonRequestDto dto) {
        if (dto == null) return null;

        Person person = new Person();
        person.setName(dto.getName());
        person.setAge(dto.getAge());

        // Конвертуємо вкладений Pet DTO в Pet Entity за допомогою PetMapper
        if (dto.getPet() != null) {
            Pet pet = petMapper.toEntity(dto.getPet());
            person.setPet(pet);
        }

        // Логіка для ManyToMany (Courses) тут пропущена,
        // оскільки вона зазвичай складніша і залежить від ID курсів.

        return person;
    }

    // Існуючий метод: Entity -> DTO (для використання в Controller)
    public PersonResponseDto toDto(Person person) {
        if (person == null) return null;

        PersonResponseDto dto = new PersonResponseDto();
        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setAge(person.getAge());

        if (person.getPet() != null) {
            dto.setPet(petMapper.toDto(person.getPet()));
        }

        if (person.getEnrolledCourses() != null) {
            dto.setEnrolledCourseIds(person.getEnrolledCourses().stream()
                    .map(course -> course.getId())
                    .collect(Collectors.toSet()));
        }

        return dto;
    }
}