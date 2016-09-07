package serenitylabs.tutorials.vetclinic.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.screenplay.abilities.ManageTheHotel;

import java.util.List;

/**
 * Created by aatchoud on 9/7/2016.
 */
public class TheGuests {
    public static Question<List<Pet>> registeredInHotel() {
        return actor -> actor.usingAbilityTo(ManageTheHotel.class).getRegisteredPets();

    }

    public static Question<List<Pet>> onTheWaitingList() {
        return actor -> actor.usingAbilityTo(ManageTheHotel.class).getWaitingList();
    }
}

//
// return new Question<List<Pet>>() {
//@Override
//public List<Pet> answeredBy(Actor actor) {
//        return actor.usingAbilityTo(ManageTheHotel.class).getRegisteredPets();
//        }