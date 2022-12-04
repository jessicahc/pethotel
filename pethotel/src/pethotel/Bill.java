package pethotel;

import java.util.*;
import java.io.*;

public class Bill {
    
    // fields
    private double billingAmount; 
    private double depositAmount;
    private double balanceAmount;
    private double rate;
    
    // constructors
    public Bill()
    {
    
    }

    public Bill(double depositAmount)
    {
        this.depositAmount = depositAmount;
    }

    // methods
    public double calculateBillingAmount(int lengthOfStay, Animal animal)
    {
        if (animal.getSpecies().equals("dog"))
        {
            this.rate = 100;
        }
        else 
        {
            this.rate = 70;
        }

        this.billingAmount = lengthOfStay * rate;

        return billingAmount;
    }

    public double calculateBalanceAmount()
    {
        this.balanceAmount = calculateBillingAmount(lengthOfStay, animal) - depositAmount;

        return balanceAmount;
    }

    public void generateBill(Animal animal, Reservation r) throws IOException
    {
        boolean append = true; 
        String filename = "bill.txt";
        FileWriter file = new FileWriter(filename, append);
        PrintWriter writer = new PrintWriter(file);

        writer.println("Bill:");
        writer.println("Owner Name: " + animal.getOwnerName());
        writer.println("Pet name: " + animal.getPetName());
        writer.println("Check in Date: " + r.getBeginDate());
        writer.println("Check out Date: " + r.getEndDate());
        writer.println("Length of Stay: " + lengthOfStay);
        writer.println("Cost per night: " + this.rate);
        writer.println("Deposit Amount: " + this.depositAmount);
        writer.println("Billing Amount: " + calculateBillingAmount(lengthOfStay, animal));
        writer.println("Deposit Amount: " + this.depositAmount);
        writer.println("Balance Amount: " + this.balanceAmount);
        
        file.close();
    }

    // setters 
    
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

    // getters
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
