package org.chdtu.services;

import org.chdtu.dtos.PersonRequestDto; // ВАЖЛИВО: імпорт DTO
import org.chdtu.entities.Person;
import java.util.List;

public interface PersonService {

    // Змінено: Тепер приймає DTO
    Person saveNewPerson(PersonRequestDto personDto);

    Person getPersonById(Long id);
    List<Person> getAllPersons();

    // Змінено: Тепер приймає DTO
    Person updatePerson(Long id, PersonRequestDto updatedPersonDto);

    void deletePerson(Long id);
}