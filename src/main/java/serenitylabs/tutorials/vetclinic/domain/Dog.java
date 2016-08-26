package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

public class Dog extends Animal implements NeedsVaccination {
    private final String name;
    private final String breed;
    private final List<String> colour;
	private LocalDate lastVaccinationDate;

    public Dog(String name, String breed, List<String> colour) {

        this.name = name;
        this.breed = breed;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public List<String> getColour() {
        return new ArrayList<>(colour);
    }
    
    
	@Override
	public String complaint() {
		// TODO Auto-generated method stub
		return "Grrrr";
	}
	

    public static DogBuilder called(String name) {
        return new DogBuilder(name);
    }

    @Override
	public String toString() {
		
		return name +" the "+(colour+" "+breed).toLowerCase();
	}

	public static class DogBuilder {
        private final String name;
        private String breed;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog andOfColour(String... colour) {
            return new Dog(name, breed,ImmutableList.copyOf(colour));
        }
    }

	/* (non-Javadoc)
	 * @see serenitylabs.tutorials.vetclinic.domain.NeedsVaccination#wasVaccinated(java.time.LocalDate)
	 */
	@Override
	public void wasVaccinated(LocalDate lastVaccinationdate) {
		this.lastVaccinationDate = lastVaccinationdate;
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see serenitylabs.tutorials.vetclinic.domain.NeedsVaccination#nextVaccinationDate()
	 */
	@Override
	public LocalDate nextVaccinationDate() {
		// TODO Auto-generated method stub
		return lastVaccinationDate.plusMonths(6);
	}
}
