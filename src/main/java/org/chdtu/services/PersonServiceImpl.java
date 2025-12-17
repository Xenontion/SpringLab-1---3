package org.chdtu.services;

import org.chdtu.dtos.PersonRequestDto;
import org.chdtu.entities.Person;
import org.chdtu.mappers.PersonMapper;
import org.chdtu.repositories.PersonRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    @Transactional
    public Person saveNewPerson(PersonRequestDto personDto) {
        // Сервіс використовує маппер для конвертації DTO в Entity
        Person person = personMapper.toEntity(personDto);

        // Логіка зв'язку OneToOne: зворотний зв'язок Pet -> Person
        if (person.getPet() != null) {
            person.getPet().setOwner(person);
        }

        return personRepository.save(person);
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    @Transactional
    public Person updatePerson(Long id, PersonRequestDto updatedPersonDto) {
        return personRepository.findById(id).map(person -> {
            // Оновлюємо поля
            person.setName(updatedPersonDto.getName());
            person.setAge(updatedPersonDto.getAge());

            // Логіка оновлення зв'язків тут пропущена для спрощення

            return personRepository.save(person);
        }).orElseThrow(() -> new RuntimeException("Person not found for update with id: " + id));
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}