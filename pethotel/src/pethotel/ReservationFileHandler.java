package pethotel;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReservationFileHandler {

	private static BufferedReader br = null;

	
	public ReservationFileHandler() {
	}
	
	public static boolean loadReservations(String inFileName) {
		// Insert a dummy reservation at index 0 to avoid error when adding new reservations into allReservationsList
		//allReservationsList.add(0, new Reservation(null, null));
		
		try {
				br = new BufferedReader(new FileReader(inFileName));
				String line = null;
				String[] tmp;
				Reservation r = null;
				
				while ((line = br.readLine()) != null) {
					// if a line starts with "#", it's a comment. Don't process the line.
					if (line.startsWith("#")) {
						continue;
					}
					line = line.trim();
					tmp = line.split(";");
					printLine(tmp);
					r = parseLine(tmp);
					if (r != null) {
						int id = r.getReservationId();
						System.out.println("Get ID " + id);
						Reservation.addNewReservationToList(r);
					}
				}
		}
		catch(FileNotFoundException fe) {
			System.out.println("FileNotFound: " + fe.toString());
			fe.printStackTrace();
			return false;
		}
		catch(IOException ioe) {
			System.out.println(ioe.toString());
			ioe.printStackTrace();
			return false;
		}
		finally {
			if (br != null) {
				try {
						br.close();
				}
				catch(IOException ioe) {
					System.out.println(ioe.toString());
					ioe.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}
	
	private static Reservation parseLine(String[] s) {
		for (int i = 0; i < s.length; i++) {
			s[i] = s[i].trim();
		}
		
		// Fields in Reservations<yyyy>.txt file:
		// 0-ResId, 1-DepositAmt, 2-CheckIn Date, 3-CheckOut Date, 4-Owner Name, 5-Address,
		// 6-City, 7-State, 8-ZipCode, 9-Phone, 10-Pet Type,
		// 11-Pet Name, 12-Sex, 13-Size, 14-Breed, 15-Age, 16-FoodOption, 17-IsCancelled(t or f)
		// 18-MaxWalkingTime, 19-LitterStation#, 20-Cage#, 21-OwnerInstructions, 22-WorkerComment
		
		Reservation r1 = new Reservation(null, null);
		int id = Integer.valueOf(s[0]);
		r1.setReservationId(id);
		
		String deposit = s[1];
		if (deposit != null) {
			try {
				double d = Double.parseDouble(deposit);
				if (d > 0) 
					r1.setDepositPaid(d);
			}
			catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		r1.setBeginDate(s[2]);
		r1.setEndDate(s[3]);
		
		Owner o1 = new Owner();
		o1.setName(s[4]);
		o1.setAddress(s[5]);
		o1.setCity(s[6]);
		o1.setState(s[7]);
		o1.setZipCode(s[8]);
		o1.setPhone(s[9]);
		
	    Animal a1 = null;
	    if (s[10].equalsIgnoreCase("Dog")) {
	    	 a1 = new Dog();
	    	 if (s.length > 18 && !s[18].equals("-1")) {
	    		 ((Dog)a1).setMaxWalkingTime(Integer.parseInt(s[18]));
	    	 }
	    }
	    else if (s[10].equalsIgnoreCase("Cat")) {
	    	a1 = new Cat();
	    	if (s.length > 19 && !s[19].equals("-1")) {
	    		((Cat)a1).setLitterStationNum(Integer.parseInt(s[19]));
	    	}
	    }
	    
	    a1.setName(s[11]);
	    a1.setSex(s[12].toUpperCase().charAt(0));
	    a1.setSize(Integer.parseInt(s[13]));
	    a1.setBreed(Integer.parseInt(s[14]));
	    a1.setAge(Integer.parseInt(s[15]));	 
	    
	    r1.setFoodOption(s[16].charAt(0));	   
	    
	    char cancelled = s[17].charAt(0);
	    if (cancelled == 't' || cancelled == 'T') { // reservation is cancelled
	    	r1.cancel();
	    }
	    
	    if (s.length > 20) 
	    	r1.setCageNumber(Integer.parseInt(s[20]));	 
	    
	    if (s.length > 21) {
	    	if (!s[21].equals("-1"))
	    		r1.setOwnerInstruction(s[21]);
	    }
	    if (s.length > 22) {
	    	if (!s[22].equals("-1"))
	    		r1.setCareTakerComment(s[22]);
	    }
	    r1.setOwner(o1);
	    r1.setAnimal(a1);
	    return r1;
	}
	
	
	private static void printLine(String[] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		ReservationFileHandler.loadReservations("Reservations2022.txt");
	}

}
