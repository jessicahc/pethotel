package pethotel;


public class Cat extends Animal {
	
	// All constants are defined here:
	
	// Cat-specific breeds
	public static final char CAT_RUSSIAN_BLUE = 'R';
	public static final char CAT_PERSIAN = 'P';
	public static final char CAT_BRITISH_SHORTHAIR = 'B';
	public static final char CAT_AMERICAN_SHORTHAIR = 'A';
	public static final char CAT_EXOTIC_SHORTHAIR = 'E';
	public static final char CAT_MAINECOON = 'O';
	public static final char CAT_SPHYNX = 'Y';
	public static final char CAT_SIAMESE = 'S';
	public static final char CAT_RAGDOLL = 'D';
	public static final char CAT_MIXED = 'X';
	public static final char CAT_UNKNOWN = 'U';
	
	public static final String[] CAT_BREED_LIST = new String[] 
			{"American Shorthair", "British Shorthair", "Exotic Shorthair", "Mainecoon", 
			 "Persian", "Ragdoll", "Russian Blue",  "Sphynx", "Siamese", "Mixed", "Unknown"};
	
	private char breed;
	
	private boolean humanReactive;
	private boolean animalReactive;
	
	private int litterStationNum;
	
	public Cat() {
		super();
		this.breed = CAT_UNKNOWN;
		this.litterStationNum = -1;
	}
	
	public Cat(char breed, boolean human, boolean animal) {
		this.breed = breed;
		this.humanReactive = human;
		animalReactive = animal;
	}
	
	public String getPetType() {
		return "Cat";
	}
	
	public String getBreedString() {
		switch (this.breed) {
			case CAT_RUSSIAN_BLUE: return "Russian Blue";  
			case CAT_PERSIAN: return "Persian";  
			case CAT_BRITISH_SHORTHAIR: return "British Shorthair";  
			case CAT_AMERICAN_SHORTHAIR: return "American Shorthair";  
			case CAT_EXOTIC_SHORTHAIR: return "Exotic Shorthair";  
			case CAT_MAINECOON: return "Mainecoon";  
			case CAT_SPHYNX: return "Sphynx"; 
			case CAT_SIAMESE: return "Siamese";  
			case CAT_RAGDOLL: return "Ragdoll";
			case CAT_MIXED: return "Mixed";
			default: return "Unknown";
		}
	}
	
	//getters and setters
	public void setBreed(char breed) {
		switch (breed) {
			case CAT_RUSSIAN_BLUE:  
			case CAT_PERSIAN: 
			case CAT_BRITISH_SHORTHAIR:   
			case CAT_AMERICAN_SHORTHAIR:   
			case CAT_EXOTIC_SHORTHAIR:   
			case CAT_MAINECOON:  
			case CAT_SPHYNX: 
			case CAT_SIAMESE:
			case CAT_RAGDOLL: 
			case CAT_MIXED:			
			case BREED_MIXED:
			case BREED_UNKNOWN:
				this.breed = breed;
				break;
			default: // Unrecognized breed
				System.out.println("Cat: invalid breed provided " + breed);
				break;
		}
		
	}
	
	public char getBreed() {
		return breed;
	}
	
	public void setLitterStationNum(int i) {
		if (i > 0)
			this.litterStationNum = i;
		else 
			System.err.println("CAT.setLitterStationNum: Invalid Litter Station Num " + i);
	}
	
	public int getLitterStationNum() {
		return this.litterStationNum;
	}
	public void setHumanReactive(boolean a) {
		this.humanReactive = a;
	}
	public void setAnimalReactive(boolean a) {
		this.animalReactive = a;
	}
	public boolean getHumanReactive() {
		return humanReactive;
	}
	public boolean getAnimalReactive() {
		return animalReactive;
	}
	
}