package pethotel;

import java.util.*;

public class Animal {
	String name;
	char breed;
	int size;
	char sex;
	int age;
	Owner owner;
	Reservation reservation;
	
	
	public Animal() {
		
	}
	
	public void setPetName(String name) {
		this.name = name;
	}
	
	public void setBreed(char breed) {
		this.breed = breed;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	

	public String getName() {
		return this.name;
	}
	
	public char getBreed() {
		return this.breed;
	}
	
	public String getBreedString() {
		return null;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getAge() {
		return age;
	}
	
	public char getSex() {
		return sex;
	}
	
	public Owner getOwner() {
		return owner;
	}
	
	public Reservation getReservation() {
		return reservation;
	}


}