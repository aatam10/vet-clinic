package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

public class WhenWeCreateANewDog {

	
	@Test
	public void a_New_Dog_Shoud_Have_A_Name(){
		Dog fido = Dog.called("Fido").withAge(3).ofBreed("Labrador").andOfColour("Black");
		

		
		Assert.assertEquals("Fido", fido.getName());
		Assert.assertEquals("Labrador", fido.getBreed());
		Assert.assertEquals("Black", fido.getColour());
	
	}
}
