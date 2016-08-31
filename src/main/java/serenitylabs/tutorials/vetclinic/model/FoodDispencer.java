package serenitylabs.tutorials.vetclinic.model;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Meal;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.PetFood;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aatchoud on 8/31/2016.
 */
public class FoodDispencer {

    private static final Map<Breed,Integer> GRAMS_PER_KILO_BY_PET = new HashMap<>();
    private static final Map<Breed,PetFood> BRAND_FOR_BREED = new HashMap<>();

    public Meal preparedMealFor(Pet pet) {
        return new Meal(rightAmountOfFoodFor(pet),rightFoodFor(pet));
    }


    static {
        BRAND_FOR_BREED.put(Breed.Dog,PetFood.FidosFood);
        BRAND_FOR_BREED.put(Breed.Cat,PetFood.KittyKat);

        GRAMS_PER_KILO_BY_PET.put(Breed.Cat,10);
        GRAMS_PER_KILO_BY_PET.put(Breed.Dog,20);
    }

    private PetFood rightFoodFor(Pet pet) {
        return BRAND_FOR_BREED.get(pet.getBreed());
    }


    private double rightAmountOfFoodFor(Pet pet) {
        return pet.getWeightInKilos() * GRAMS_PER_KILO_BY_PET.get(pet.getBreed());
    }
}
