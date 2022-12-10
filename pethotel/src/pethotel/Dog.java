package pethotel;

public class Dog extends Animal {

	public static final char DOG_GOLDEN_RETRIEVER = 'G';
	public static final char DOG_SHIBA = 'S';
	public static final char DOG_MIXED = 'X';
	
	
	int maxWalkingTime;

	
	public Dog() {
		
	}
	
	public String getBreedString() {
		switch (this.breed) {
			case DOG_GOLDEN_RETRIEVER: return "Golden Retriever";  
			case DOG_SHIBA: return "Shiba";  
			case DOG_MIXED: return "Mixed";
			default: return "Unknown";
		}
	}
	
	public void setMaxWalkingTime(int time) {
		this.maxWalkingTime = time;
	}
	
	public int getMaxWalkingTime() {
		return this.maxWalkingTime;
	}
	/*
	public class Dog extends Animal {
	
	//Fields
	
	
	private boolean walkingNeeded;
	private double maxWalkingTime;
	private boolean humanReactive;
	private boolean animalReactive;
	private String breed;

	
	//Constructors
	
	public Dog() {
	
	}
	
	public Dog(String breed, boolean walking,double maxwalking, boolean humanr, boolean animalr) {
		this.breed = breed;
		this.walkingNeeded = walking;
		this.humanReactive = humanr;
		this.maxWalkingTime = maxwalking;
		this.animalReactive = animalr;
	
	}
	
	//Setters 
	public void setBreed(String b) {
		breed = b;
	}
	
	public void setWalking(boolean w) {
		walkingNeeded = w;
	}
	
	public void setMaxWalking(double t) {
		maxWalkingTime = t;
	}
	
	public void setHumanR(boolean hr) {
		humanReactive = hr;
	}
	
	public void setAnimalR(boolean ar) {
		animalReactive = ar;
	}
	
	
	//Getters
	public String getBreed() {
		return breed;
	}
	
	public boolean getWalkingNeeded() {
		return walkingNeeded;
	}
	
	public boolean getHumanReactive() {
		return humanReactive;
	}
	
	public boolean getAnimalReactive() {
		return animalReactive;
	}
	
	public double getMaxWalkingTime() {
		return maxWalkingTime;
	}


}

	
	*/
	
	
	
}
