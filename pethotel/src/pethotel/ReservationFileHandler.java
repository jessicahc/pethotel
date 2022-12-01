package pethotel;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReservationFileHandler {

	private static BufferedReader br = null;
	public static ArrayList<Reservation> activeResList = new ArrayList<Reservation>();
	
	public ReservationFileHandler() {
	}
	
	public static boolean loadReservations(String inFileName) {
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
						activeResList.add(r);
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
			
		Reservation r1 = new Reservation();
		r1.setReservationId(s[0]);
		
		Owner o1 = new Owner();  // TO DO: Create new Owner or get the Owner??
		o1.setName(s[1]);
		o1.setAddress(s[2]+","+s[3]+","+s[4]+","+s[5]);
		o1.setPhone(s[6]);
		
		try {
			Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(s[7]);  
			r1.setBeginDate(date1);
			Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(s[8]); 
			r1.setEndDate(date2);
		}
		catch (ParseException pe) {
			pe.printStackTrace();
		}
		
	    
	    
	    Animal a1 = new Animal();
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
	    
	    a1.setPetName(s[10]);
	    a1.setSex(s[11].charAt(0));
	    a1.setSize(Integer.parseInt(s[12]));
	    a1.setBreed(s[13].toUpperCase().charAt(0));
	    a1.setAge(Integer.parseInt(s[14]));
	   
	    r1.setFoodOption(Integer.parseInt(s[15]));	   
	    if (s.length > 18) 
	    	r1.setCageNum(Integer.parseInt(s[18]));	 
	    if (s.length > 19)
	    	r1.setOwnerInstructions(s[19]);
	    if (s.length > 20)
	    	r1.setAttendantComments(s[20]);
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
		// TODO Auto-generated method stub
	//	ReservationFileHandler h = new ReservationFileHandler();
		ReservationFileHandler.loadReservations("Reservations2022.txt");
	}

}
