// Bill class is responsible for generating a bill for a specific
// reservation. The bill includes the basic pet owner's and pet's 
// information, billing amount, deposit paid by the pet owner, and
// the balance due.  A bill can either be displayed in GUI or save 
// into a file. 
//
// Author: Ellie Tso

package pethotel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Bill {
    
	public static double BILLING_RATE_DOG = 100.0;
	public static double BILLING_RATE_CAT = 75.0;
	public static double BILLING_RATE_HOTEL_FOOD = 10.0;
	public static double BILLING_RATE_OWNER_FOOD = 0.0;
	
	private static int nextBillID = 0;
	
    // fields
	private int    billID;
    private double billingAmount; 
    private double depositAmount;
    private double balanceAmount;
    private double rate;
    
    private Reservation reservation;
    private Animal animal;
    private Owner  owner;   
    private int lengthOfStay;
    
    private String lineBillTitle =    "Pet Boarding Bill";
    private String lineBillingID =    "Billing ID: PBH000";
    private String lineOwnerName =    "Owner Name:   ";
    private String linePetName =      "Pet Name:     ";
    private String linePetType =      "Pet Type:     ";
    private String lineCheckInDate =  "Check-In Date:           ";
    private String lineCheckOutDate = "Check-Out Date:          ";
    private String lineLengthOfStay = "Length Of Stay:          ";
    private String lineCostStay =     "Cost of Stay per Night:  $";
    private String lineCostFood =     "Cost of Food per Day:    $";
    private String lineBillAmt =      "Total Billing Amount:    $";
    private String lineDepositAmt =   "Deposit Paid:            $";
    private String lineBalanceAmt =   "Balance Due:             $";

    	
    // constructors

    public Bill(Reservation reservation)
    {
    	// WARNING: DO NOT set owner, animal, lengthOfStay, etc. here until
        // the user requests to generate the bill because these
        // data fields could get modified by the user.
    	
    	this.reservation = reservation;
        this.depositAmount = reservation.getDepositPaid();
        this.billID = makeBillID();       
    }

    // methods

    public static int makeBillID() {
    	return ++nextBillID;
    }
    
    public double calculateBillingAmount()
    {
        if (animal instanceof Dog)
        {
            rate = BILLING_RATE_DOG;
        }
        else if (animal instanceof Cat)
        {
            rate = BILLING_RATE_CAT;
        }
               
        billingAmount = lengthOfStay * rate;
        
        // Add food cost to the bill if food is provided by hotel
        if (reservation.getFoodOption() == Reservation.FOOD_FROM_HOTEL) {
        	billingAmount += lengthOfStay * BILLING_RATE_HOTEL_FOOD;
        }
        
        return billingAmount;
    }

    public double calculateBalanceAmount()
    {
        balanceAmount = calculateBillingAmount() - depositAmount;
        return balanceAmount;
    }

    public void generateBillDetails() {
    	 // Always get the latest Owner and Animal object and re-calculate 
    	 // lengthOfStay and bill amounts in case the user modifies the reservation
    	 this.owner = reservation.getOwner();
         this.animal = reservation.getAnimal();         
    	 this.lengthOfStay = reservation.calculateLengthOfStay();
    	 this.billingAmount = calculateBillingAmount();
    	 this.balanceAmount = calculateBalanceAmount();
    	 
    	 lineBillingID += Integer.toString(this.billID);
         lineOwnerName += owner.getName();
         linePetName += animal.getName();
         linePetType += animal.getSpecies();
         lineCheckInDate += Reservation.dateFormatter.format(reservation.getBeginDate());
         lineCheckOutDate += Reservation.dateFormatter.format(reservation.getEndDate());
         lineLengthOfStay += lengthOfStay;
         lineCostStay += String.format("%.2f", rate);
         
         char food = reservation.getFoodOption();
         switch (food) {
         	case Reservation.FOOD_FROM_HOTEL:
         		lineCostFood += String.format("%.2f", BILLING_RATE_HOTEL_FOOD);
         		break;
         	case Reservation.FOOD_FROM_OWNER:
         		lineCostFood += String.format("%.2f", BILLING_RATE_OWNER_FOOD);
         		break;
         }      
      
         lineBillAmt += String.format("%.2f", billingAmount);
         lineDepositAmt += String.format("%.2f", depositAmount);
         lineBalanceAmt += String.format("%.2f", balanceAmount);
    }
    
    public JPanel generateBillGUIContent() {
    	generateBillDetails();
    	
    	JPanel mainPanel = new JPanel(new BorderLayout(0, 20));
    	JPanel northPanel = new JPanel();
    	JPanel centerPanel = new JPanel(new GridLayout(17, 1));
    	
    	Font fontTitle = new Font("Verdana", Font.BOLD, 18);
    	Font fontLabel = new Font("Courier New", Font.BOLD, 15);
    	
    	JLabel lblBillTitle = new JLabel(lineBillTitle);
    	lblBillTitle.setFont(fontTitle);
    	
    	JLabel lblBillingID = new JLabel(lineBillingID);
    	JLabel lblOwnerName = new JLabel(lineOwnerName);   
    	JLabel lblPetName =  new JLabel(linePetName);   
    	JLabel lblPetType = new JLabel(linePetType);
   
    	JLabel lblCheckInDate = new JLabel(lineCheckInDate); 
    	JLabel lblCheckOutDate = new JLabel(lineCheckOutDate);
    	JLabel lblLengthOfStay = new JLabel(lineLengthOfStay);
    	JLabel lblCostStay = new JLabel(lineCostStay);
    	JLabel lblCostFood = new JLabel(lineCostFood);
    	JLabel lblBillAmt = new JLabel(lineBillAmt);
    	JLabel lblDepositAmt = new JLabel(lineDepositAmt);
    	JLabel lblBalanceAmt = new JLabel(lineBalanceAmt);
    	
    	lblBillingID.setFont(fontLabel);
    	lblOwnerName.setFont(fontLabel);   
    	lblPetName.setFont(fontLabel);   
    	lblPetType.setFont(fontLabel);
   
    	lblCheckInDate.setFont(fontLabel); 
    	lblCheckOutDate.setFont(fontLabel);
    	lblLengthOfStay.setFont(fontLabel);
    	lblCostStay.setFont(fontLabel);
    	lblCostFood.setFont(fontLabel);
    	lblBillAmt.setFont(fontLabel);
    	lblDepositAmt.setFont(fontLabel);
    	lblBalanceAmt.setFont(fontLabel);
    	
    	
    	centerPanel.add(lblBillTitle);
    	centerPanel.add(new JLabel("  ")); // dummy separator
    	centerPanel.add(lblBillingID);
    	centerPanel.add(new JLabel("  ")); // dummy separator
    	centerPanel.add(lblOwnerName);
    	centerPanel.add(lblPetName);
    	centerPanel.add(lblPetType);
    	centerPanel.add(new JLabel("  ")); // dummy separator
    	centerPanel.add(lblCheckInDate);
    	centerPanel.add(lblCheckOutDate);
    	centerPanel.add(lblLengthOfStay);
    	centerPanel.add(lblCostStay);
    	centerPanel.add(lblCostFood);
    	centerPanel.add(lblBillAmt);
    	centerPanel.add(lblDepositAmt);
    	centerPanel.add(lblBalanceAmt);
    	
    	//mainPanel.add(BorderLayout.NORTH, northPanel);
    	mainPanel.add(BorderLayout.CENTER, centerPanel);
    	return mainPanel;
    }
    
    
    public void generateBill() 
    {
        boolean append = true; 
        String filename = "bill-activityreport.txt";
        
        try {
        	FileWriter file = new FileWriter(filename, append);
        	PrintWriter writer = new PrintWriter(file);

        	writer.println("Bill:");
        	writer.println("Owner Name: " + owner.getName());
        	writer.println("Pet name: " + animal.getName());
        	writer.println("Check-In Date: " + reservation.getBeginDate());
        	writer.println("Check-Out Date: " + reservation.getEndDate());
        	writer.println("Length of Stay: " + lengthOfStay);
        	writer.println("Cost of Stay per night: " + rate);
        
        	writer.println("Billing Amount: " + billingAmount);
        	writer.println("Deposit Amount: " + depositAmount);
        	writer.println("Balance Amount: " + balanceAmount);
        
        	file.close();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
    }
    
    public void generateBill(String filename, boolean append)
    {
        try {
        	FileWriter file = new FileWriter(filename, append);
        	PrintWriter writer = new PrintWriter(file);

        	writer.println(lineBillTitle);
        	writer.println(lineBillingID);
        	writer.println(lineOwnerName);
        	writer.println(linePetName);
        	writer.println(linePetType);
        	writer.println(lineCheckInDate);
        	writer.println(lineCheckOutDate);
        
        	writer.println(lineLengthOfStay);
        	writer.println(lineCostStay);
        	writer.println(lineCostFood);
        	writer.println(lineBillAmt);
        	writer.println(lineDepositAmt);
        	writer.println(lineBalanceAmt);
        
        	file.close();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
    } 

    // setters & getters

    public void setDepositAmount(double depositAmount)
    {
        this.depositAmount = depositAmount;
    }

    public void setBalanceAmount(double balanceAmount)
    {
        this.balanceAmount = balanceAmount;
    }

    public void setBillingAmount(double billingAmount)
    {
        this.billingAmount = billingAmount;
    }

    public double getDepositAmount()
    {
        return depositAmount;
    }

    public double getBalanceAmount()
    {
        return balanceAmount;
    }

    public double getBillingAmount()
    {
        return billingAmount;
    }

}
