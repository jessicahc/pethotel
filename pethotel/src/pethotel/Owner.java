package pethotel;
import java.util.ArrayList;

public class Owner {
	String name;
	String address;
	String city;
	String state;
	String zipcode;
	String phone;
	
	ArrayList<Animal> pets;
	
	public Owner() {
		pets = new ArrayList<Animal>(1);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String addr) {
		this.address = addr;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setZipcode(String zip) {
		this.zipcode = zip;
	}
	
	public void setPhone(String sz) {
		this.phone = sz;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void addPet(Animal a) {
		pets.add(a);
	}
	
	public ArrayList<Animal> getPets() {
		return pets;
	}
}