package pethotel;

public class Dog extends Animal {

	// All constants are defined here:

	public static final String[] DOG_BREED_LIST = new String[] 
			{"Unknown", "Mixed", "Bulldog", "Chihuahua", "Chow Chow", "Corgi", //index 0-5
			"Dachshund", "Dalmatian", "German Sheperd", "Golden Retriever", "Great Dane", //index 6-10
			"Havanese", "Husky", "Labrador", "Maltese", "Pitbull", //index 11-15
			"Pomeranian", "Poodle", "Rottweiler", "Samoyed", "Shiba Inu", //index 16-20
			"Shih Tzu", "Spaniel", "Terrier", "Other"}; //index 21-24
	
	// Dog breeds: each assigned int MUST MATCH DOG_BREED_LIST's index number
	// for setBreed() and getBreed() to work
	public static final int DOG_UNKNOWN = 0;
	public static final int DOG_MIXED = 1;
	public static final int DOG_BULLDOG = 2;
	public static final int DOG_CHIHUAHUA = 3;
	public static final int DOG_CHOWCHOW = 4;
	public static final int DOG_CORGI = 5;
	public static final int DOG_DACHSHUND = 6;
	public static final int DOG_DALMATIAN = 7;
	public static final int DOG_GERMAN_SHEPERD = 8;
	public static final int DOG_GOLDEN_RETRIEVER = 9;
	public static final int DOG_GREAT_DANE = 10;
	public static final int DOG_HAVANESE =11;
	public static final int DOG_HUSKY = 12;
	public static final int DOG_LABORADOR = 13;
	public static final int DOG_MALTESE = 14;
	public static final int DOG_PITBULL = 15;
	public static final int DOG_POMERANIAN = 16;
	public static final int DOG_POODLE = 17;
	public static final int DOG_ROTTWEILER = 18;
	public static final int DOG_SAMOYED = 19;
	public static final int DOG_SHIBA = 20;
	public static final int DOG_SHITZU = 21;
	public static final int DOG_SPANIEL = 22;
	public static final int DOG_TERRIER = 23;
	public static final int DOG_OTHER = 24;

	
	public static final int DEFAULT_MAX_WALKING_TIME = 60; //minutes
	
	// Dot specific data fields
	int maxWalkingTime;

	
	public Dog() {
		super();
		maxWalkingTime = DEFAULT_MAX_WALKING_TIME;
	}
	
	public String getSpecies() {
		return "Dog";
	}
	
	public void setBreed(int breed) {
		if (breed >= 0 && breed <= DOG_BREED_LIST.length)
			this.breed = breed;
		else
			System.err.println("Dog.setBreed(): invalid breed provided " + breed);
	}
	
	public void setBreed(String breed) {
		for (int i=0; i < DOG_BREED_LIST.length; i++) {
			if (DOG_BREED_LIST[i].equalsIgnoreCase(breed)) {
				this.breed = i;
			}
		}
	}
	
	public int getBreed() {
		return breed;
	}
	
	public String getBreedString() {
		if (breed >= 0 && breed <= DOG_BREED_LIST.length)
			return DOG_BREED_LIST[breed];
		else {
			System.err.println("Dog.getBreedString(): cannot convert invalid breed to string" + breed);
			return null;
		}
	}
		
	public void setMaxWalkingTime(int time) {
		this.maxWalkingTime = time;
	}
	
	public int getMaxWalkingTime() {
		return this.maxWalkingTime;
	}
	
	
}