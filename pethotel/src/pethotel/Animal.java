// Animal is an abstract class which includes all common info about
// a pet animal, e.g. pet name, sex, age, size, breed, etc. 
// Since the breed info is specific to a particular animal species 
// (Dog or Cat), each subclass must implement getBreed() and setBreed()
// methods to access species-specific breed info. Each subclass must also
// implement getSpecies() to return a string representation of an animal
// species, e.g. "Dog", "Cat". This is needed by GUI classes.
//
// Author: Ethan Alford

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
	
	public static final int SIZE_SMALL = 1;
	public static final int SIZE_MEDIUM = 2;
	public static final int SIZE_LARGE = 3;
	public static final int SIZE_EXLARGE = 4;
	
	
	//data fields
	protected String name;
	protected int breed; //the specific breed within an animal species
	protected char sex;
	protected int age;
	protected int size;
	
	// Not Used
	//protected Owner owner;
	//rotected Reservation reservation;
	
	protected boolean humanReactive;
	protected boolean animalReactive;
	
	//constructors
	public Animal() {
		this.breed = BREED_UNKNOWN;
		this.humanReactive = false;
		this.animalReactive = false;
	}
/*	
	public Animal(Owner owner, String name) {
		this.owner = owner;
		this.name = name;
		this.breed = BREED_UNKNOWN;
	}
	
	public Animal(Owner owner, String petName, int breed, int size, char sex) {		
		this.owner = owner;
		this.name = name;
		this.size = size;
		this.sex = sex;
		setBreed(breed);
	}
*/	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	
	//subclasses must implement setBreed based on species specific breeds
	public abstract void setBreed(int breed);
	
	public abstract void setBreed(String breed);
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	/*
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	*/
	
	public void setHumanReactive(boolean a) {
		this.humanReactive = a;
	}
	
	public void setAnimalReactive(boolean a) {
		this.animalReactive = a;
	}
	
	//getters
	public String getName() {
		return name;
	}
	
	// Subclass must return a string name of its animal species,
	// e.g. "Dog", "Cat", "Hamster"
	public abstract String getSpecies();
	
	public abstract int getBreed();
	
	//Subclass must return a string name of its animal's specific breed,
	// e.g. "Golden Retriever" for dog, "Persian" for cat
	public abstract String getBreedString();
	
	public int getSize() {
		return size;
	}
	
	public int getAge() {
		return age;
	}
		
	public char getSex() {
		return sex;
	}
	
	/*
	public Owner getOwner() {
		return owner;
	}
	
	public Reservation getReservation() {
		return reservation;
	}
	*/
	
	public boolean getHumanReactive() {
		return humanReactive;
	}
	
	public boolean getAnimalReactive() {
		return animalReactive;
	}
	
}