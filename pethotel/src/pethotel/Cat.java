// Cat is a subclass of Animal class, containing Cat specific
// attributes, such as various cat breeds, and litter station number
// that can be assigned to a cat during its boarding period.
// Cat class implements getSpecies(), getBreed(), and setBreed()
// methods required by Animal class.
//
//  Author: Vighnesh Dheenadhayalan

package pethotel;


public class Cat extends Animal {
	
	// All constants are defined here:
	
	public static final String[] CAT_BREED_LIST = new String[] 
			{"Unknown", "Mixed", "American Shorthair", "British Shorthair", "Exotic Shorthair", "Mainecoon", //index 0-5
			 "Persian", "Ragdoll", "Russian Blue",  "Sphynx", "Siamese", //index 6-10
			 "Other"};
	
	// Cat breeds: each assigned int MUST MATCH CAT_BREED_LIST's index number
	// for setBreed() and getBreed() to work
	public static final int CAT_UNKNOWN = 0;
	public static final int CAT_MIXED = 1;
	public static final int CAT_AMERICAN_SHORTHAIR = 2;
	public static final int CAT_BRITISH_SHORTHAIR = 3;
	public static final int CAT_EXOTIC_SHORTHAIR = 4;
	public static final int CAT_MAINECOON = 5;
	public static final int CAT_PERSIAN = 6;
	public static final int CAT_RAGDOLL = 7;
	public static final int CAT_RUSSIAN_BLUE = 8;
	public static final int CAT_SPHYNX = 9;
	public static final int CAT_SIAMESE = 10;
	public static final int CAT_OTHER = 11;
	
	
	int litterStationNum;
	

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

	//getters and setters
	
	public String getSpecies() {
		return "Cat";
	}
	
	
	public void setBreed(int breed) {
		if (breed >= 0 && breed <= CAT_BREED_LIST.length)
			this.breed = breed;
		else
			System.err.println("Cat: invalid breed provided " + breed);
	}
	
	public void setBreed(String breed) {
		for (int i=0; i < CAT_BREED_LIST.length; i++) {
			if (CAT_BREED_LIST[i].equalsIgnoreCase(breed)) {
				this.breed = i;
			}
		}
	}
	
	public int getBreed() {
		return breed;
	}

	public String getBreedString() {
		if (breed >= 0 && breed <= CAT_BREED_LIST.length)
			return CAT_BREED_LIST[breed];
		else {
			System.err.println("Cat.getBreedString(): cannot convert invalid breed to string" + breed);
			return null;
		}
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
	
}