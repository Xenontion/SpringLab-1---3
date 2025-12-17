package org.chdtu.controllers;

import org.chdtu.dtos.PersonRequestDto;
import org.chdtu.dtos.PersonResponseDto;
import org.chdtu.entities.Person;
import org.chdtu.mappers.PersonMapper;
import org.chdtu.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;
    private final PersonMapper personMapper;

    public PersonController(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    // CREATE: 201 Created (Контролер передає DTO в Сервіс)
    @PostMapping
    public ResponseEntity<PersonResponseDto> createPerson(@RequestBody PersonRequestDto requestDto) {
        Person savedPerson = personService.saveNewPerson(requestDto);
        PersonResponseDto responseDto = personMapper.toDto(savedPerson);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // READ All: 200 OK
    @GetMapping
    public ResponseEntity<List<PersonResponseDto>> getAllPersons() {
        List<PersonResponseDto> persons = personService.getAllPersons().stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(persons);
    }

    // READ By ID: 200 OK
    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDto> getPersonById(@PathVariable Long id) {
        Person person = personService.getPersonById(id);
        PersonResponseDto responseDto = personMapper.toDto(person);
        return ResponseEntity.ok(responseDto);
    }

    // UPDATE: 200 OK
    @PutMapping("/{id}")
    public ResponseEntity<PersonResponseDto> updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        Person updatedPerson = personService.updatePerson(id, requestDto);
        PersonResponseDto responseDto = personMapper.toDto(updatedPerson);
        return ResponseEntity.ok(responseDto);
    }

    // DELETE: 204 No Content
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}