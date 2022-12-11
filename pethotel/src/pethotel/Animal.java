package pethotel;

public abstract class Animal {
	// Constants definitions:
	
	// The default and generic animal breeds are defined here.
	// Subclasses should add more breed choices (e.g. Golden Retriever,
	// Husky, etc. for Dogs and Tabby, Persian, etc. for Cats). 
	// Subclasses must implement 2 abstract methods: getPetType(), setSpecies() and getSpecies()
	public static final char BREED_UNKNOWN = 'U';
	public static final char BREED_MIXED = 'M';
	
	public static final char SEX_MALE = 'M';
	public static final char SEX_FEMALE = 'F';
	
	public static final char WEIGHT_SMALL = 'S';
	public static final char WEIGHT_MEDIUM = 'M';
	public static final char WEIGHT_LARGE = 'L';
	public static final char WEIGHT_EXLARGE = 'X';
	
	
	//data fields
	
	protected String petName;
	protected char breed;
	protected char sex;
	protected int age;
	protected char weight;
	protected Owner owner;
	
	
	//constructors
	public Animal() {
		this.breed = BREED_UNKNOWN;
	}
	
	public Animal(Owner owner, String petName) {		
		this.owner = owner;
		this.petName = petName;
	}
	
	public Animal(Owner owner, String petName, char breed, char weight, char sex) {		
		this.owner = owner;
		this.petName = petName;
		this.breed = breed;
		this.weight = weight;
		this.sex = sex;
	}
	
	//setters and getters
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public Owner getOwner() {
		return owner;
	}
	
	public void setPetName(String petName) {
		this.petName = petName;
	}
	
	public String getPetName() {
		return petName;
	}
	
	public abstract String getPetType();
	
	public abstract void setBreed(char breed);
	
	public abstract char getBreed();
	
	public abstract String getBreedString();
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setWeight(char weight) {
		this.weight = weight;
	}
	
	public char getWeight() {
		return weight;
	}
	
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public char getSex() {
		return sex;
	}
	
	
}
