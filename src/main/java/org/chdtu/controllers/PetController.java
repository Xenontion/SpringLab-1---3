package org.chdtu.controllers;

import org.chdtu.dtos.PetDto;
import org.chdtu.entities.Pet;
import org.chdtu.mappers.PetMapper;
import org.chdtu.services.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;
    private final PetMapper petMapper;

    public PetController(PetService petService, PetMapper petMapper) {
        this.petService = petService;
        this.petMapper = petMapper;
    }

    // CREATE: 201 Created
    @PostMapping
    public ResponseEntity<PetDto> createPet(@RequestBody PetDto requestDto) {
        Pet savedPet = petService.saveNewPet(requestDto);
        PetDto responseDto = petMapper.toDto(savedPet);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // READ By ID: 200 OK
    @GetMapping("/{id}")
    public ResponseEntity<PetDto> getPetById(@PathVariable Long id) {
        Pet pet = petService.getPetById(id);
        PetDto responseDto = petMapper.toDto(pet);
        return ResponseEntity.ok(responseDto);
    }

    // READ All: 200 OK
    @GetMapping
    public ResponseEntity<List<PetDto>> getAllPets() {
        List<PetDto> pets = petService.getAllPets().stream()
                .map(petMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pets);
    }

    // DELETE: 204 No Content
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }
}