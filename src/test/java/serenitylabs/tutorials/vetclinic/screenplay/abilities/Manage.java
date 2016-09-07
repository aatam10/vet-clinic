package serenitylabs.tutorials.vetclinic.screenplay.abilities;

import net.serenitybdd.screenplay.Ability;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

/**
 * Created by aatchoud on 9/7/2016.
 */
public class Manage {
    public static Ability the(PetHotel petHotel) {
        return new ManageTheHotel(petHotel);
    }
}
