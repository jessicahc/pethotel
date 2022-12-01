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
	
	
	
	
}
