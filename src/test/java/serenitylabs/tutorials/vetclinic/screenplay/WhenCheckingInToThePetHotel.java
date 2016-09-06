package serenitylabs.tutorials.vetclinic.screenplay;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckIn;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckOut;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

/**
 * Created by aatchoud on 9/6/2016.
 */

@RunWith(SerenityRunner.class)
public class WhenCheckingInToThePetHotel {

    @Test
    public void petra_books_her_pet_cat_into_a_hotel(){
        //Given
        Actor petra = Actor.named("Petra the Cat Owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = new PetHotel("Hotel_PetsInn");

        petra.attemptsTo(
                CheckIn.aPet(ginger).into(petHotel)
//                new CheckIn(ginger,petHotel)
        );

        assertThat(petHotel.getPets(), hasItem(ginger));
    }

    @Test
    public void petra_checks_her_cat_out_of_the_hotel(){
        //Given
        Actor petra = Actor.named("Petra a Cat Owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = new PetHotel("PetsInn");

        petra.wasAbleTo(CheckIn.aPet(ginger).into(petHotel));

        petra.attemptsTo(
                    CheckOut.aPet(ginger).from(petHotel)
                );

        assertThat(petHotel.getPets(),not(hasItem(ginger)));
    }
}
