package pethotel;

import java.util.*;
import java.io.*;

public class ActivityReport {
    
    // fields
    private double playTime;
    private String careWorkerComments;

    // constructor
    public ActivityReport()
    {

    }

    // methods

    // setters
    public void setPlayTime(double playTime)
    {
        this.playTime = playTime;
    }

    public void setCareworkersComments(String careWorkerComments)
    {
        this.careWorkerComments = careWorkerComments;
    }

    // getters
    public double getPlayTime()
    {
        return this.playTime;
    }

    public String getComments()
    {
        return careWorkerComments;
    }

    // method to increase play time
    public void addPlayTime(double time)
    {
        this.playTime += time;
    }

    // method to add comments
    public void addComments(String comments)
    {
        this.careWorkerComments += comments;
    }  

    // generate activity report
    public void generateReport()
    {
        boolean append = true; 
        String filename = "activityreport.txt";
        FileWriter file = new FileWriter(filename, append);
        PrintWriter writer = new PrintWriter(file);

        writer.println("Activity Report:");
        writer.println("Amount of playtime: " + this.playTime + " hours");
        writer.println("Careworker's comments:");
        writer.println(careWorkerComments);
        
        file.close();
    }

}
