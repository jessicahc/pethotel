package pethotel;

public class Dog extends Animal {

	// All constants are defined here:	
	
	// Dog specific breeds
	public static final char DOG_CHIHUAHUA = 'C';
	public static final char DOG_GOLDEN_RETRIEVER = 'G';
	public static final char DOG_HUSKY = 'H';
	public static final char DOG_MALTESE = 'T';
	public static final char DOG_POODLE = 'P';
	public static final char DOG_SHIBA = 'S';
	public static final char DOG_SHITZU = 'Z';

	
	public static final String[] DOG_BREED_LIST = new String[] 
													{"Chihuahua", "Golden Retriever", "Husky", "Maltese",
													 "Poodle", "Shiba Inu", "Shitzu", "Mixed", "Unknown"}; 
	
	public static final int DEFAULT_MAX_WALKING_TIME = 60; //minutes
	
	// Dot specific data fields
	int maxWalkingTime;

	
	public Dog() {
		super();
		maxWalkingTime = DEFAULT_MAX_WALKING_TIME;
	}
	
	public String getPetType() {
		return "Dog";
	}
	
	public String getBreedString() {
		switch (this.breed) {
			case DOG_CHIHUAHUA: return "Chihuahua";
			case DOG_GOLDEN_RETRIEVER: return "Golden Retriever";  
			case DOG_HUSKY: return "Husky";
			case DOG_MALTESE: return "Maltese";
			case DOG_POODLE: return "Poodle";
			case DOG_SHIBA: return "Shiba Inu"; 
			case DOG_SHITZU: return "Shitzu";
			case BREED_MIXED: return "Mixed";
			default: return "Unknown";
		}
	}
	
	public void setBreed(char breed) {
		switch (breed) {
			case DOG_CHIHUAHUA:
			case DOG_GOLDEN_RETRIEVER:
			case DOG_HUSKY:
			case DOG_MALTESE:
			case DOG_POODLE:
			case DOG_SHIBA:
			case DOG_SHITZU:
			case BREED_MIXED:
			case BREED_UNKNOWN:
				this.breed = breed;
				break;
			default: // Unrecognized breed
				System.out.println("Dog: invalid breed provided " + breed);
				break;
		}	
	}
	
	public char getBreed() {
		return breed;
	}
		
	public void setMaxWalkingTime(int time) {
		this.maxWalkingTime = time;
	}
	
	public int getMaxWalkingTime() {
		return this.maxWalkingTime;
	}
}