package org.chdtu.services;

import org.chdtu.dtos.PetDto;
import org.chdtu.entities.Pet;
import org.chdtu.mappers.PetMapper;
import org.chdtu.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final PetMapper petMapper;

    @Autowired
    public PetServiceImpl(PetRepository petRepository, PetMapper petMapper) {
        this.petRepository = petRepository;
        this.petMapper = petMapper;
    }

    @Override
    @Transactional
    public Pet saveNewPet(PetDto petDto) {
        // Конвертація DTO -> Entity
        Pet pet = petMapper.toEntity(petDto);
        return petRepository.save(pet);
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}