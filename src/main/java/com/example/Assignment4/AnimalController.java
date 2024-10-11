package com.example.Assignment4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Gets a list of all Animals in the database.
     * http://localhost:8080/animals/all
     *
     * @return a list of animal objects
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return service.getAllAnimals();
    }

    /**
     * Gets a specific animal by its Id number.
     * http://localhost:8080/animals/8888
     *
     * @return One animal object
     */
    @GetMapping("/{animalId}")
    public Animal getOneAnimal(@PathVariable int animalId) {
        return service.getAnimalById(animalId);
    }

    /**
     * Gets a list of all Animals by their species in the database.
     * http://localhost:8080/animals?species=parakeet
     *
     * @param species is the search key
     * @return a list of animal objects that matches the search key of species. Defaults to response for german shepherd.
     */
    @GetMapping("")
    public List<Animal> getAnimalBySpecies(@RequestParam(name = "species", defaultValue = "German Shepherd") String species){
        return service.getAnimalBySpecies(species);
    }

    /**
     * Gets a list of all Animals that contain the same string in their name.
     * http://localhost:8080/animals/strings?name=ger
     *
     * @param name
     * @return a list of animal objects that matches the search key of name. defaults to responding with cat.
     */
    @GetMapping("/strings")
    public Animal getAnimalByString(@RequestParam(name = "name", defaultValue = "Cat") String name){
        return service.findByNameContaining(name);
    }

    /**
     * adds a new animal entry
     * http://localhost:8080/animals/add
     *
     * @param animal the new animal object
     * @return the updated list of animal onjects.
     */
    @PostMapping("/add")
    public List<Animal> addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return service.getAllAnimals();
    }

    /**
     * Updates a animal object.
     * http://localhost:8080/animals/update/3
     *
     * @param animalId the unique animal id number you want to update
     * @param animal the new details for that animal object.
     * @return the updated animal object
     */
    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return service.getAnimalById(animalId);
    }

    /**
     * Deletes an animal object from the database.
     * http://localhost:8080/animals/delete/2
     *
     * @param animalId The animal id number for the animal you want to delete.
     * @return a list of animal objects
     */
    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return service.getAllAnimals();
    }
}
