package pethotel;


public class Cat extends Animal {
	
	public static final char CAT_RUSSIAN_BLUE = 'R';
	public static final char CAT_PERSIAN = 'P';
	public static final char CAT_BRITISH_SHORTHAIR = 'B';
	public static final char CAT_AMERICAN_SHORTHAIR = 'A';
	public static final char CAT_EXOTIC_SHORTHAIR = 'E';
	public static final char CAT_MAINECOON = 'M';
	public static final char CAT_SPHYNX = 'Y';
	public static final char CAT_SIAMESE = 'S';
	public static final char CAT_RAGDOLL = 'D';
	public static final char CAT_MIXED = 'X';
	public static final char CAT_UNKNOWN = 'U';
	
	int litterStationNum;
	
	public Cat() {
		super();
		this.breed = CAT_UNKNOWN;
		this.litterStationNum = -1;
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
