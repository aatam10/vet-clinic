package serenitylabs.tutorials.vetclinic.domain;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class whenCollectingAnimals {
	
	@Test
	public void a_list_of_animals_can_contain_cats_and_dogs(){
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
        Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("Brown");
        
        List<Animal> animals = new ArrayList<>();
        
        animals.add(fido);
        animals.add(felix);
        
        assertThat(animals,hasItems(fido,felix));
	}


	
}
