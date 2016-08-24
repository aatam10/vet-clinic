package serenitylabs.tutorials.vetclinic.domain;

public class Dog {

	private final String name;
	private final String breed;
	private final String colour;
	private final int age;

	public Dog(String name, String breed, int age, String colour) {
		this.name = name;
		this.breed = breed;
		this.colour=colour;
		this.age=age;
	}

	public String getName() {
		return name;
	}

	public String getBreed() {
		// TODO Auto-generated method stub
		return breed;
	}

	public String getColour(){
		return colour;
	}
	
	
	public int getAge(){
		return age;
	}
	
	
	public static DogBuilder called(String name) {
		// TODO Auto-generated method stub
		return new DogBuilder(name);
	}
	
	
	
	
		public static class DogBuilder{

			private final String name;
			private String breed;
			private int age;

			public DogBuilder(String name) {
				this.name=name;
			}

			public DogBuilder ofBreed(String breed) {
				// TODO Auto-generated method stub
				this.breed=breed;
				return this;
			}
			
			public DogBuilder withAge(int age){
				this.age= age;
				return this;
			}

			public Dog andOfColour(String colour) {
				return new Dog(name,breed,age,colour);
			}
			
		}

}
