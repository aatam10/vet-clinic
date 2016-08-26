package serenitylabs.tutorials.vetclinic.domain;

public class VetAssistant {

	private ComplainRegister complainRegister;

	public VetAssistant(ComplainRegister complainRegister) {
		this.complainRegister=complainRegister;
	}

	public void recordComplainFrom(Animal someAnimal) {
	
		ComplainRegister.recordComplaint(someAnimal.complaint());
		
	}

	public ComplainRegister getComplainRegister() {
		return complainRegister;
	}


}
