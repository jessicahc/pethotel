package pethotel;

import java.io.*;

public class Bill {
    
	public static int BILLING_RATE_DOG = 100;
	public static int BILLING_RATE_CAT = 75;
	public static int BILLING_RATE_HOTEL_FOOD = 10;
	
    // fields

    private double billingAmount; 
    private double depositAmount;
    private double balanceAmount;
    private double rate;
    Animal animal;
    Reservation reservation;
    private int lengthOfStay;
    
    // constructors

    public Bill(double depositAmount)
    {
        this.depositAmount = depositAmount;
    }

    public Bill(double depositAmount, Animal animal, Reservation reservation)
    {
        this.depositAmount = depositAmount;
        this.animal = animal;
        this.reservation = reservation;
        this.lengthOfStay = reservation.calculateLengthOfStay();
    }

    // methods

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

    public void generateBill() throws IOException
    {
        boolean append = true; 
        String filename = "bill-activityreport.txt";
        FileWriter file = new FileWriter(filename, append);
        PrintWriter writer = new PrintWriter(file);

        writer.println("Bill:");
        writer.println("Owner Name: " + animal.getOwner().getName());
        writer.println("Pet name: " + animal.getPetName());
        writer.println("Check in Date: " + reservation.getBeginDate());
        writer.println("Check out Date: " + reservation.getEndDate());
        writer.println("Length of Stay: " + lengthOfStay);
        writer.println("Cost of Stay per night: " + rate);
        char food = reservation.getFoodOption();
        switch (food) {
        	case Reservation.FOOD_FROM_HOTEL:
        			writer.println("Cost of Pet Food per day: " + BILLING_RATE_HOTEL_FOOD);
        			break;
        	case Reservation.FOOD_FROM_OWNER:
        			writer.println("Cost of Pet Food per day: $0");
        			break;
        }      
        writer.println("Deposit Amount: " + depositAmount);
        writer.println("Billing Amount: " + billingAmount);
        writer.println("Deposit Amount: " + depositAmount);
        writer.println("Balance Amount: " + balanceAmount);
        
        file.close();
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