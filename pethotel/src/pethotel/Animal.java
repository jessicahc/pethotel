package pethotel;

public abstract class Animal {
	// Constants definitions:
	
	// The default and generic animal breeds are defined here.
	// Subclasses should add more breed choices (e.g. Golden Retriever,
	// Husky, etc. for Dogs and Tabby, Persian, etc. for Cats). 
	// Subclasses must implement abstract methods: getPetType(), setBreed() and getBreed()
	public static final int BREED_UNKNOWN = 0;
	public static final int BREED_MIXED = 1;
	
	public static final char SEX_MALE = 'M';
	public static final char SEX_FEMALE = 'F';
	
	public static final int WEIGHT_SMALL = 1;
	public static final int WEIGHT_MEDIUM = 2;
	public static final int WEIGHT_LARGE = 3;
	public static final int WEIGHT_EXLARGE = 4;
	
	
	//data fields
	protected String petName, species;
	protected int breed; //the specific breed within an animal species
	protected char sex;
	protected int age;
	protected int weight;
	protected Owner owner;
	
	
	//constructors
	public Animal() {
		this.breed = BREED_UNKNOWN;
	}
	
	public Animal(Owner owner, String petName) {
		this.owner = owner;
		this.petName = petName;
		this.breed = BREED_UNKNOWN;
	}
	
	public Animal(Owner owner, String petName, int breed, int weight, char sex) {		
		this.owner = owner;
		this.petName = petName;
		this.weight = weight;
		this.sex = sex;
		setBreed(breed);
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
	
	// Subclass must return a string name of its animal species,
	// e.g. "Dog", "Cat", "Hamster"
	public abstract String getSpecies();
	
	public abstract void setBreed(int breed);
	
	public abstract void setBreed(String breed);
	
	public abstract int getBreed();
	
	//Subclass must return a string name of its animal's specific breed,
	// e.g. "Golden Retriever" for dog, "Persian" for cat
	public abstract String getBreedString();
	
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public char getSex() {
		return sex;
	}
	
	
}
