package org.chdtu.services;

import org.chdtu.dtos.PetDto;
import org.chdtu.entities.Pet;
import java.util.List;

public interface PetService {
    Pet saveNewPet(PetDto petDto);
    Pet getPetById(Long id);
    List<Pet> getAllPets();
    void deletePet(Long id);
}