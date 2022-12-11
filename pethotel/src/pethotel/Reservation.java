package pethotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Reservation{

	// All constants are defined here:
	public static final char FOOD_FROM_OWNER = 'O';
	public static final char FOOD_FROM_HOTEL = 'H';
	
	// A shared static ID counter for generating ID numbers for all
	// reservations within the program
	private static int idCounter = 0;
	
	private Bill bill;
	private int reservationId;
	private Owner owner;
	private Animal animal;
	private int lengthOfStay;
	private Date beginDate = new Date();
	private Date endDate = new Date();
	private int cageNumber;
	private char foodOption;
	private boolean isActive;
	private String ownerInstruction;
	private String careTakerComment;

	
	public Reservation(Owner owner, Animal animal){
		setReservationId(makeId());
		this.owner = owner;
		this.animal = animal;
		isActive = true;		
	}

	public Reservation(Owner owner, Animal animal, Date beginDate, Date endDate){
		setReservationId(makeId());
		this.owner = owner;
		this.animal = animal;
		this.beginDate = beginDate;
		this.endDate = endDate;
		//this.lengthOfStay = calculateLengthOfStay(beginDate, endDate);
		this.isActive = true;
		/*
		if (animal.getSpecies() == "cat"){
			bill = new Bill(75);
		}
		else if (animal.getSpecies() == "dog"){
			bill = new Bill(100);
		}
		*/		
	}

	// Generate the next ID number for a new reservation
	private static int makeId() {
		return ++idCounter;
	}
		
		
	public int calculateLengthOfStay(Date beginDate, Date endDate){
		//long timeDiff = (endDate.getDate() - beginDate.getDate());
		//int daysdiff = (int) (timeDiff / (1000 * 60 * 60 * 24));
		
		//return daysdiff;		
		return endDate.getDay() - beginDate.getDay();
	}
//
//	public Date dateConvert(String dateString) {
//		LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.BASIC_ISO_DATE);
//		return date;
//	}
//	public Date dateConvert(int dateInt) {
//		String string = String.valueOf(dateInt);
//		LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.BASIC_ISO_DATE);
//		return date;
//	}
	
	public void checkDate(){
//		Date current = new Date();
//		if current.after(endDate){
//			isActive = false;
//		}
		
	}

	//getters and setters

	public int getReservationId() {
		return reservationId;
	}
	
	// Reservation ID should be set when Reservation's constructor is called.
	// Don't let other classes to invoke setReservationId() directly
	protected void setReservationId(int reservationId) {
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
	
	public void setEndDate(Date endDate){
		this.endDate = endDate;
	}
	
	public boolean isActive(){
		return isActive;
	}
	
	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}
	
	public int getCageNumber(){
		return cageNumber;
	}
	
	public void setCageNumber(int cageNumber){
		this.cageNumber = cageNumber;
	}
	
	public char getFoodOption(){
		return foodOption;
	}
	
	public void setFoodOption(char foodOption){
		this.foodOption = foodOption;
	}
	
	public String getOwnerInstruction(){
		return ownerInstruction;
	}
	
	public void setOwnerInstruction(String instruction){
		this.ownerInstruction = instruction;
	}
	
	public String getCareTakerComment(){
		return careTakerComment;
	}
	
	public void setCareTakerComment(String comment){
		this.careTakerComment = comment;
	}
	
	public void generateBill() {
		//TODO: when the user clicks on "Generate Bill & Report",
		// a Bill object should be constructed here.
	}
	
	public Bill getBill() {
		return bill;
	}
}
