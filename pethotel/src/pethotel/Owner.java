package pethotel;

public class Owner {

	public static final String STATE_LIST[] = new String[] {"AL", "AK", "AS",
			   "AZ", "AR", "CA", "CO", "CT", "DE", "DC",
			   "FM", "FL", "GA", "GU", "HI", "ID", "IL", "IN", "IA", "KS",
			   "KY", "LA", "ME", "MH", "MD", "MA", "MI", "MN", "MS", "MO",
			   "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "MP",
			   "OH", "OK", "OR", "PW", "PA", "PR", "RI", "SC", "SD", "TN",
			   "TX", "UT", "VT", "VI", "VA", "WA", "WV", "WI", "WY"};

	private String name;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String phone;
	

	public Owner() { }
	public Owner(String name, String address, String phone) {
		
		this.name = name;
		this.address = address;
		this.phone = phone;		
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

	public String getCity() {
		return city;
	}
	public void setCity(String c) {
		this.city = c;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String s) {
		this.state = s;
	}
	
	public String getZipCode() {
		return zipcode;
	}
	public void setZipCode(String z) {
		this.zipcode = z;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	
}
