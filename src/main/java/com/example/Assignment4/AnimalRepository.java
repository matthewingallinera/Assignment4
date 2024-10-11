package com.example.Assignment4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>{

    //Used for getAnimalBySpecies to find animals that are of a given species.
    List<Animal> getAnimalBySpecies(String species);

    //Used for getAnimalBy String to find animals who's name contain a string.
    Animal findByNameContaining(String name);

}
