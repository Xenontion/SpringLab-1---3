package org.chdtu.mappers;

import org.chdtu.dtos.PetDto;
import org.chdtu.entities.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    // DTO -> Entity (для використання в PersonMapper)
    public Pet toEntity(PetDto dto) {
        if (dto == null) return null;

        Pet pet = new Pet();
        pet.setName(dto.getName());
        pet.setAge(dto.getAge());

        return pet;
    }

    // Entity -> DTO (для використання в Controller)
    public PetDto toDto(Pet pet) {
        if (pet == null) return null;

        PetDto dto = new PetDto();
        dto.setId(pet.getId());
        dto.setName(pet.getName());
        dto.setAge(pet.getAge());

        if (pet.getOwner() != null) {
            dto.setOwnerId(pet.getOwner().getId());
        }

        return dto;
    }
}