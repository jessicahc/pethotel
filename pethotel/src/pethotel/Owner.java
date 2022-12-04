package pethotel;
import java.util.ArrayList;

public class Owner {

	private String name;
	private String address;
	private int phone;
	private int id;

	public Owner() { }
	public Owner(String name, String address, int phone, int id) {
		
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.id = id;
	}


	// getters and setters

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
