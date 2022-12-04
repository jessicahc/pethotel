package pethotel;

import java.util.Date;
public class Reservation{
	
	private Bill bill;
	private String reservationId;
	private Owner owner;
	private Animal animal;
	private int lengthOfStay;
	private Date beginDate = new Date();
	private Date endDate = new Date();
	private int cageNumber;
	private int foodOption;
	private boolean isActive;

	public Reservation(Owner owner, Animal animal){
		this.owner = owner;
		this.animal = animal;
		isActive = true;
	}

	public Reservation(Owner owner, Animal animal, Date beginDate, Date endDate){
		this.owner = owner;
		this.animal = animal;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.lengthOfStay = calculateLengthOfStay(beginDate, endDate);
		if (animal.getSpecies() == "cat"){
			bill = new Bill(75);
		}
		else if (animal.getSpecies() == "dog"){
			bill = new Bill(100);
		}
		isActive = true;
	}


	public int calculateLengthOfStay(Date beginDate, Date endDate){
		long diff = (endDate - beginDate);
		int daysdiff = (int) (timeDiff / (1000 * 60 * 60 * 24));
		return daysdiff;
	}

	public Date dateConvert(String dateString) {
		LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.BASIC_ISO_DATE);
		return date;
	}
	public Date dateConvert(int dateInt) {
		String string = String.valueOf(dateInt);
		LocalDate date = LocalDate.parse(string, DateTimeFormatter.BASIC_ISO_DATE);
		return date;
	}
	
	public void checkDate(){
		Date current = new Date();
		if current.after(endDate){
			isActive = false;
		}
		
	}

	//getters and setters

	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) { // should we "set" resId manually or assign automatically?
		this.reservationId = reservationId;
	}
	public Owner getOwner(){
		return owner;
	}
	public void setOwner(Owner owner){
		this.owner = owner;
	}
	public Animal getAnimal(){
		return animal;
	}
	public void setAnimal(Animal animal){
		this.animal = animal;
	}
	public Date getBeginDate(){
		return beginDate;
	}
	public void setBeginDate(Date beginDate){
		this.beginDate = beginDate;
	}
	public Date getEndDate(){
		return endDate;
	}
	public void setEndnDate(Date endDate){
		this.endDate = endDate;
	}
	public int getCageNumber(){
		return cageNumber;
	}
	public void setCageNumber(int cageNumber){
		this.cageNumber = cageNumber;
	}
	public int getFoodOption(){
		return foodOption;
	}
	public void setFoodOption(int foodOption){
		this.foodOption = foodOption;
	}
}
