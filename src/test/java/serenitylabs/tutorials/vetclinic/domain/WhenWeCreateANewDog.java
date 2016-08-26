package serenitylabs.tutorials.vetclinic.domain;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

public class WhenWeCreateANewDog {

    @Test
    public void a_new_dog_should_have_a_name_and_a_breed_and_a_colour() throws Exception {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
        Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("Brown");

        felix.complaint();
        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals("Black", fido.getColour());
    }
    
     @Test
     public void a_dog_should_be_printed_in_readable_form(){
    	 NeedsVaccination fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
    	 
    	 assertThat(fido.toString(),equalTo("Fido the black labrador"));
     }
     
     @Test
     public void a_dog_can_have_multiple_colours(){
    	 Dog fido = Dog.called("Fido").ofBreed("Labrador")
    			 .andOfColour("Black","White");
    	 
    	 assertThat(fido.getColour(), contains("Black","White"));
    	 assertThat(fido.getColour(), hasItem("Black"));
    	 assertThat(fido.getColour(), not(hasItem("red")));
     }
     
 	@Test
 	public void a_dog_complains_by_growling(){
   	 Dog fido = Dog.called("Fido").ofBreed("Labrador")
			 .andOfColour("Black","White");
   	 
   	 assertThat(fido.complaint(), equalTo("Grrrr"));
 	}
 	
 	@Test
 	public void a_cat_complains_meowing(){
 		Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("Brown");
 		
 		assertThat(felix.complaint(), equalTo("Meow"));
 	}
     
}
