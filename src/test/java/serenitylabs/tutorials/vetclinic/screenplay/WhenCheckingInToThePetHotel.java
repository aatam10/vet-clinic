package serenitylabs.tutorials.vetclinic.screenplay;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.questions.TheGuestInWaitingList;
import serenitylabs.tutorials.vetclinic.screenplay.questions.TheRegisteredGuest;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckIn;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckOut;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
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
        PetHotel petHotel = PetHotel.called("Hotel_PetsInn");
        petra.attemptsTo(
                CheckIn.aPet(ginger).into(petHotel)
        );
        //assertThat(petHotel.getPets(), hasItem(ginger));
        petra.should(seeThat(TheRegisteredGuest.in(petHotel),hasItem(ginger)));
    }

    @Test
    public void petra_checks_her_cat_out_of_the_hotel(){
        //Given
        Actor petra = Actor.named("Petra a Cat Owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = PetHotel.called("PetsInn");

        petra.wasAbleTo(CheckIn.aPet(ginger).into(petHotel));

        petra.attemptsTo(
                    CheckOut.aPet(ginger).from(petHotel)
                );

      //  assertThat(petHotel.getPets(),not(hasItem(ginger)));
        petra.should(seeThat(TheRegisteredGuest.in(petHotel),not(hasItem(ginger))));
    }

    @Test
    public void petra_checks_her_cat_in_when_hotel_is_full() {
        Actor petra = Actor.named("Petra the Cat Owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = APetHotel.with(20).petsCheckedIn();

        petra.attemptsTo(CheckIn.aPet(ginger).into(petHotel));

        petra.should(seeThat(TheRegisteredGuest.in(petHotel),not(hasItem(ginger))));

        petra.should(seeThat(TheGuestInWaitingList.in(petHotel),hasItem(ginger)));
    }

}






