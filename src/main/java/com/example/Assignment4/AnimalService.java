package com.example.Assignment4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    /**
     * Gets all animals in database.
     *
     * @return list of all animals in databse/
     */
    public List<Animal> getAllAnimals(){
        return animalRepository.findAll();
    }

    /**
     * Gets an individual animal by its id number
     *
     * @param animalId individual animal id number
     * @return the animal object associated with that id number.
     */
    public Animal getAnimalById(int animalId){
        return animalRepository.findById(animalId).orElse(null);
    }

    /**
     * Adds a new animal object to the database.
     *
     * @param animal the new animal object just created.
     */
    public void addNewAnimal(Animal animal){
        animalRepository.save(animal);
    }

    /**
     * Updates an animal object already in the database.
     *
     * @param animalId individual animal id number
     * @param animal the updated information of that animal object
     */
    public void updateAnimal(int animalId, Animal animal){
        Animal existing = getAnimalById(animalId);
        existing.setName(animal.getName());
        existing.setScientificName(animal.getScientificName());
        existing.setSpecies(animal.getSpecies());
        existing.setHabitat(animal.getHabitat());
        existing.setDescription(animal.getDescription());

        animalRepository.save(existing);
    }

    /**
     * Deletes an individual animal object.
     *
     * @param animalId the individual animal object's id.
     */
    public void deleteAnimalById(int animalId){
        animalRepository.deleteById(animalId);
    }

    /**
     * Gets all animal object that are of the same species.
     *
     * @param species the search key .
     * @return a list of animal objects of the same species.
     */
    public List<Animal> getAnimalBySpecies(String species){
        return animalRepository.getAnimalBySpecies(species);
    }

    /**
     * Gets all animal objects containing a string.
     *
     * @param name the string that we are searching for.
     * @return the list of animal objects with names containing that String.
     */
    public Animal findByNameContaining(String name){
        return animalRepository.findByNameContaining(name);
    }
}
