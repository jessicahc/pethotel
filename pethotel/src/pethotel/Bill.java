package pethotel;

import java.io.*;

public class Bill {
    
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
        this.lengthOfStay = reservation.calculateLengthOfStay(reservation.getBeginDate(), reservation.getEndDate());
    }

    // methods

    public double calculateBillingAmount()
    {
        if (animal.getSpecies() == "dog")
        {
            rate = 100;
        }
        else if (animal.getSpecies() == "cat")
        {
            rate = 70;
        }

        billingAmount = lengthOfStay * rate;
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
        writer.println("Owner Name: " + animal.getOwnerName());
        writer.println("Pet name: " + animal.getPetName());
        writer.println("Check in Date: " + reservation.getBeginDate());
        writer.println("Check out Date: " + reservation.getEndDate());
        writer.println("Length of Stay: " + lengthOfStay);
        writer.println("Cost per night: " + rate);
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
