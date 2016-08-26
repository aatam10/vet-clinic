package serenitylabs.tutorials.vetclinic.domain;

import static org.hamcrest.Matchers.hasItems;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


import org.junit.Test;

public class WhenVisitingTheClinic {

	@Test
	public void cats_and_dogs_complain_to_the_assistant(){
		Dog fido=Dog.called("fido").ofBreed("Labrador").andOfColour("Black");
		Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("Brown");
		
		ComplainRegister complainRegister  = new ComplainRegister();
		VetAssistant assistant = new VetAssistant(complainRegister);
		
		assistant.recordComplainFrom(fido);
		assistant.recordComplainFrom(felix);
		
		//assertThat(complainRegister.getComplaints(),hasItems("Grrrr","Meow"));
		
	}
	
	@Test
	public void a_vet_should_know_when_a_pet_vaccination_is_due(){
		NeedsVaccination felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("Brown");
		
		LocalDate today = LocalDate.now();
		LocalDate nextYear = today.plusYears(1);
		
		felix.wasVaccinated(today);
		
		assertThat(felix.nextVaccinationDate(),equalTo(nextYear));
	}
	
	
	@Test
	public void dog_need_vaccination_every_six_months(){
		NeedsVaccination fido=Dog.called("fido").ofBreed("Labrador").andOfColour("Black");
		
	
		LocalDate today = LocalDate.now();
		LocalDate insixMonthsTime = today.plusMonths(6);
		
		fido.wasVaccinated(today);
		
		assertThat(fido.nextVaccinationDate(),equalTo(insixMonthsTime));
	}
	
}
