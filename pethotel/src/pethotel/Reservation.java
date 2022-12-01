package pethotel;

import java.util.Date;

public class Reservation {
	
	public static final char STATUS_CANCELLED = 'C';
	public static final char STATUS_EXPIRED = 'E';
	public static final char STATUS_ACTIVE = 'A';
	public static final char STATUS_UPCOMING = 'U';
	
	public static final char PET_TYPE_UNKNOWN = 'N';
	public static final char PET_TYPE_DOG = 'D';
	public static final char PET_TYPE_CAT = 'C';
	
	public static final int OWNER_BRINGS_FOOD = 1;
	public static final int HOTEL_PROVIDES_FOOD = 0;
	
	String reservationId;
	char status;
	
	Date beginDate;
	Date endDate;
	Owner owner;
	Animal animal;
	int foodOption;
	int cageNum;
	String ownerInstructions;
	String attendantComments;
	
	
	public Reservation() {
		foodOption = OWNER_BRINGS_FOOD;
		cageNum = -1;
	}
	
	public void setReservationId(String id) {
		this.reservationId = id;
	}
	
	public void setBeginDate(Date date) {
		this.beginDate = date;
		
		if (status != STATUS_CANCELLED) {
			// set status here based on beginDate and endDate
		}
	}
	
	public void setEndDate(Date date) {
		this.endDate = date;
		
		if (status != STATUS_CANCELLED) {
			// set status here based on beginDate and endDate
		}
	}
	
	public void setOwner(Owner o) {
		this.owner = o;
	}
	
	public void setAnimal(Animal a) {
		this.animal = a;
	}
	
	public void setFoodOption(int f) {
		switch(f) {
		case OWNER_BRINGS_FOOD: 
		case HOTEL_PROVIDES_FOOD: 
				this.foodOption = f;
				break;
		default:
			System.err.println("Reservation.setFoodOption(int): Input FoodOption Not Recognized: " + f);
			break;
		}
	}
	
	public void setCageNum(int c) {
		if (c > 0)
			this.cageNum = c;
		else
			System.err.println("Reservation.setCageNum(int): Invalid Cage Number " + c);
	}
	
	public void setOwnerInstructions(String s) {
		this.ownerInstructions = s;
	}
	
	public void setAttendantComments(String s) {
		this.attendantComments = s;
	}
	
	public String getReservationId() {
		return this.reservationId;
	}
	
	public char getStatus() {
		return this.status;
	}
	
	public Owner getOwner() {
		return this.owner;
	}
	
	public Animal getAnimal() {
		return this.animal;
	}
	
	public char getPetType() {
		if (animal != null) {
			if (animal.getClass() == Dog.class) {
				return PET_TYPE_DOG;
			}
			else if (animal.getClass() == Cat.class) {
				return PET_TYPE_CAT;
			}
		}
		return PET_TYPE_UNKNOWN;
	}
	
	public String getPetTypeString() {
		switch(getPetType()) {
			case PET_TYPE_DOG:
				return "Dog";
			case PET_TYPE_CAT:
				return "Cat";
			case PET_TYPE_UNKNOWN:
				return "Unkown";
			default:
				return null;
		}
	}
	
	public int getFoodOption() {
		return this.foodOption;
	}
	
	public int getCageNumber() {
		return this.cageNum;
	}
	
	public Date getBeginDate() {
		return this.beginDate;
	}
	
	public Date getEndDate() {
		return this.endDate;
	}
	
	public String getOwnerInstruction() {
		return this.ownerInstructions;
	}
	
	public String getAttendantComments() {
		return this.attendantComments;
	}
	
	public boolean isCancelled() {
		return status == STATUS_CANCELLED;
	}
}
