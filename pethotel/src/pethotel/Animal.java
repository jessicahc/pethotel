package pethotel;

public abastract class Animal {
	
	//data fields
	private String petName, species, ownerName;
	private char sex;
	private int weight, reservation, static count = 1, id;
	private double bill;
	
	//constructors
	public Animal(String ownerName, String petName) {
		
		this.ownerName = ownerName;
		this.petName = petName;
	}
	public Animal(String ownerName, String petName, String species, int weight, char sex) {
		
		this.ownerName = ownerName;
		this.petName = petName;
		this.species = species;
		this.weight = weight;
		this.sex = sex;
	}
	
	//setters and getters
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setPetName(String petName) {
		this.petName = petName;
	}
	
	public String getPetName() {
		return petName;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public String getSpecies() {
		return species;
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
	
	//methods
	public void makeId() {
		id = count;
		count++;
	}
	
	public int getId() {
		return id;
	}
}

