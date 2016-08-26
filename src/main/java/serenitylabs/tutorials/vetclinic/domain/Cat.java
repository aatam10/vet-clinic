package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public class Cat extends Animal implements NeedsVaccination{

	private final String name;
	private final String breed;
	private final String colour;
	private LocalDate lastVaccinationDate;
	//private LocalDate nextVaccinationDate;

	private Cat(String name, String breed, String colour) {
		this.name=name;
		this.breed=breed;
		this.colour=colour;
	}
    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getColour() {
        return colour;
    }
    
	@Override
	public String complaint() {
		// TODO Auto-generated method stub
		return "Meow";
	}
	
    
	public static CatBuilder called(String name) {
		return new CatBuilder(name);
	}

	public static class CatBuilder{

		private final String name;
		private String breed;

		public CatBuilder(String name) {
			// TODO Auto-generated constructor stub
			this.name=name;
		}

		public CatBuilder ofBreed(String breed) {
			this.breed=breed;
			return this;
		}

		public Cat andOfColour(String colour) {
			// TODO Auto-generated method stub
			return new Cat(name,breed,colour);
		}
		
	}

	public void wasVaccinated(LocalDate vaccinationDate) {
		this.lastVaccinationDate = vaccinationDate;
		
	}
	public LocalDate nextVaccinationDate() {
		// TODO Auto-generated method stub
		return lastVaccinationDate.plusYears(1);
	}
}
