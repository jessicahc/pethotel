// Reservation contains instances of Owner and Animal as its main data fields
// to link a pet owner with his/her pet animal, and other reservation related
// information, such as begin & end date, cage#, deposit paid, etc. It also
// contains the following static variables which are shared among all Reservation
// objects:
//
// idCounter - for generating a unque ID for each new reservation
//
// allReservationsList - an ArrayList to store all active and inactive
//         reservations. Each reservation's ID corresponds to the index number
//         of this array list.
//
// cageList - a boolean array for keeping track of the status of 25 cages that can
//         be assigned to reservations. If a cage is assigned to a pet, it will
//         be marked as "Occupied(false)", otherwise it will be marked as "Available(true)".
//
// todayDate - a Date object for comparing a reservation's beginDate and endDate
//         against today's date in order to determine if a reservation's status
//         is in-progress, upcoming, or expired. 
//
// Author: Simon Sherbet, Jessica Chen

package pethotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;


public class Reservation{

	// All constants are defined here:
	
	public static final char FOOD_FROM_OWNER = 'O';
	public static final char FOOD_FROM_HOTEL = 'H';
	
	public static final boolean CAGENUM_AVAILABLE = true;
	public static final boolean CAGENUM_OCCUPIED = false;
	
	public static final char STATUS_ACTIVE = 'A';
	public static final char STATUS_UPCOMING = 'U';
	public static final char STATUS_EXPIRED = 'E';
	public static final char STATUS_CANCELLED = 'C';
	
	// A date formatter to format and convert reservation dates
	public static SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
	
	// A shared static ID counter for generating ID numbers for all reservations within the program
	private static int idCounter = -1;
	
	// A list of all reservations including active, upcoming, expired and cancelled
	private static ArrayList<Reservation> allReservationsList = new ArrayList<Reservation>(10);
	
	// A list of cages for keeping track of available cages to be assigned to new reservations.
	// Cage numbers correspond to cageList's index number from 0-24
	private static boolean[] cageList = new boolean[25];
	static {
		for (int i = 0; i < cageList.length; i++)
			cageList[i] = CAGENUM_AVAILABLE;
	}
	
	// Today's date for comparing to reservation's beginDate and endDate to determine
    // reservation's active or inactive status
	public static Date todayDate = new Date();
	
	//private Bill bill;
	private int reservationId;
	private Owner owner;
	private Animal animal;
	private Date beginDate;
	private Date endDate;
	private int cageNumber;
	private char foodOption;
	private boolean isActive;
	private char status;
	private String ownerInstruction;
	private String careTakerComment;

	private double depositPaid;
	
	
	public Reservation(Owner owner, Animal animal){
		setReservationId(makeId());
		this.owner = owner;
		this.animal = animal;
		this.foodOption = FOOD_FROM_OWNER;
		this.cageNumber = -1; // default cage# to -1 (Not Assigned)
		isActive = true;
		status = STATUS_ACTIVE;
		depositPaid = 0;
	}

	public Reservation(Owner owner, Animal animal, Date beginDate, Date endDate){
		this(owner, animal);
		this.beginDate = beginDate;
		this.endDate = endDate;
		setStatus();
	}

	// Generate the next ID number for a new reservation
	private static int makeId() {
		// Reservation ID starts from 0 to match allReservationsList's index number
		return ++idCounter;
	}
		
		
	public static void addNewReservationToList(Reservation r) {
		allReservationsList.add(r);
	}
	
	public static Reservation getReservationFromList(int id) {
		return allReservationsList.get(id);
	}
	
	public static int getReservationsListSize() {
		return allReservationsList.size();
	}
	
	public int calculateLengthOfStay(){
		if (beginDate == null || endDate == null)
			return -1;
		
		long timeDiff = (endDate.getTime() - beginDate.getTime());
		int daysdiff = (int) (timeDiff / (1000 * 60 * 60 * 24));
		
		return daysdiff;
	}
	
	
	/*
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
	*/
	
	public static boolean isValidDuration(String fromDate, String toDate) {
		try {
			Date from = dateFormatter.parse(fromDate);  
			Date to = dateFormatter.parse(toDate);
			
			if (from.after(to))
				return false;
		}
		catch (ParseException pe) {
			pe.printStackTrace();
			return false;
		}
		
		return true;
	}

	// Allow user to cancel this reservation. Update reservation's status
	public void cancel() {
		this.status = STATUS_CANCELLED;
		this.isActive = false;
	}
	
	
	//getters and setters

	public int getReservationId() {
		return reservationId;
	}
	
	// Reservation ID should really be generated when Reservation's constructor is called if possible
	// Only class from the same package can invoke setReservationId() directly
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
	
	public String getBeginDateString() {
		return dateFormatter.format(beginDate);
	}
	
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
		
		// Update reservation's status based on the new beginDate
		setStatus();
	}
	
	public void setBeginDate(String fromDate) {
		try {
			Date date = dateFormatter.parse(fromDate);  
			setBeginDate(date);
		}
		catch (ParseException pe) {
			pe.printStackTrace();
		}
	}
	
	public Date getEndDate(){
		return endDate;
	}
	
	public String getEndDateString() {
		return dateFormatter.format(endDate);
	}
	
	public void setEndDate(Date endDate){
		this.endDate = endDate;
		// Update reservation's status based on the new endDate
		setStatus();
	}
	
	public void setEndDate(String toDate) {
		try {
			Date date = dateFormatter.parse(toDate);  
			setEndDate(date);
		}
		catch (ParseException pe) {
			pe.printStackTrace();
		}
	}
		
	public boolean isActive(){
		return isActive;
	}
	
	public char getStatus() {
		return status;
	}
	
	public String getStatusString() {
		switch (status) {
			case STATUS_ACTIVE: return "In Progress";
			case STATUS_UPCOMING: return "Upcoming";
			case STATUS_EXPIRED: return "Expired";
			case STATUS_CANCELLED: return "Cancelled";
			default: return "TBD";
		}
	}
	 
	
	// Calculate reservation's status based on beginDate and endDate.
	// Do NOT change status if this reservation is already cancelled or expired.
	// The user must create a new reservation to change the dates
	public void setStatus() {
		if (status == STATUS_CANCELLED || status == STATUS_EXPIRED) {
			isActive = false;
			return;
		}
		
		// Need both beginDate and endDate info to determine status
		if (beginDate == null || endDate == null)
			return;
			
		if (beginDate.before(todayDate) && endDate.before(todayDate)) {
			status = STATUS_EXPIRED;
			isActive = false;
		}
		else if (beginDate.before(todayDate) && endDate.after(todayDate)) {
			status = STATUS_ACTIVE;
			isActive = true;
		}
		else if (beginDate.after(todayDate) && endDate.after(todayDate)) {
			status = STATUS_UPCOMING;
			isActive = true;
		}
		else
			System.err.println("Reservation.setStatus(): Invalid beginDate & endDate " 
					+ dateFormatter.format(beginDate) + " " + dateFormatter.format(endDate));
	}
	
	
	public int getCageNumber(){
		return cageNumber;
	}
	
	// Assign the specified cage number to this reservation if the cage number
	// is still available, otherwise don't assign and return false
	public boolean setCageNumber(int cageNumber){
		if (cageNumber < 0)
			return false;
		
		if (cageList[cageNumber] == CAGENUM_AVAILABLE) {
			this.cageNumber = cageNumber;
			cageList[cageNumber] = CAGENUM_OCCUPIED;
			return true;
		}
		return false;
	}
	
	public static ArrayList getAvailableCages() {
		ArrayList<Integer> availableCageList = new ArrayList<Integer>();
		for (int i = 0; i < cageList.length; i++) {
			if (cageList[i] == CAGENUM_AVAILABLE)
				availableCageList.add(i);
		}
		return availableCageList;
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
		// Add new line character after every '.' and '!' to get displayed 
		// properly in GUI
		if (instruction != null)
			instruction = instruction.replace(". ", ".\n").replace("! ", "!\n");
		this.ownerInstruction = instruction;
	}
	
	public String getCareTakerComment(){
		return careTakerComment;
	}
	
	public void setCareTakerComment(String comment){
		// Add new line character after every '.' and '!' to get displayed
		// properly in GUI	
		if (comment != null)
			comment = comment.replace(". ", ".\n").replace("! ", "!\n");
		this.careTakerComment = comment;
	}
	

	public double getDepositPaid() {
		return this.depositPaid;
	}
	
	public void setDepositPaid(double d) {
		this.depositPaid = d;
	}
}
