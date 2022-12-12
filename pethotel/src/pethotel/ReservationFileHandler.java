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
					tmp = line.split(",");
					printLine(tmp);
					r = parseLine(tmp);
					if (r != null) {
						int id = r.getReservationId();
						System.out.println("Get ID " + id);
						Reservation.allReservationsList.add(r);
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
			
		Reservation r1 = new Reservation(null, null);
		System.out.println("SID " + s[0]);
		int id = Integer.valueOf(s[0]);
		System.out.println("ID " + id);
		r1.setReservationId(id);
		
		Owner o1 = new Owner();  // TO DO: Create new Owner or get the Owner??
		o1.setName(s[1]);
		o1.setAddress(s[2]);
		o1.setCity(s[3]);
		o1.setState(s[4]);
		o1.setZipCode(s[5]);
		o1.setPhone(s[6]);
		
		r1.setBeginDate(s[7]);
		r1.setEndDate(s[8]);
				
	    Animal a1 = null;
	    if (s[9].equalsIgnoreCase("dog")) {
	    	 a1 = new Dog();
	    	 if (s.length > 16) {
	    		 ((Dog)a1).setMaxWalkingTime(Integer.parseInt(s[16]));
	    	 }
	    }
	    else if (s[9].equalsIgnoreCase("cat")) {
	    	a1 = new Cat();
	    	if (s.length > 17) {
	    		((Cat)a1).setLitterStationNum(Integer.parseInt(s[17]));
	    	}
	    }
	    
	    a1.setName(s[10]);
	    a1.setSex(s[11].toUpperCase().charAt(0));
	    a1.setSize(Integer.parseInt(s[12]));
	    a1.setBreed(Integer.parseInt(s[13]));
	    a1.setAge(Integer.parseInt(s[14]));	 
	    
	    r1.setFoodOption(s[15].charAt(0));	   
	    if (s.length > 18) 
	    	r1.setCageNumber(Integer.parseInt(s[18]));	 
	    if (s.length > 19) {
	    	if (!s[19].equals("-1"))
	    		r1.setOwnerInstruction(s[19]);
	    }
	    if (s.length > 20) {
	    	if (!s[20].equals("-1"))
	    		r1.setCareTakerComment(s[20]);
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
