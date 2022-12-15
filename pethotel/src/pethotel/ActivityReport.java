// ActivityReport is responsible for generating a report for 
// a specific reservation. The report can either be displayed 
// in GUI or save into a file. So far in the GUI version the report
// only includes Care Taker's Comments about an animal's behavior 
// during its boarding period. This class also allows programmers
// to add and display animal's play time info, which can be added to
// the GUI version in the future.
//
// Author: Ellie Tso

package pethotel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class ActivityReport {
    
    // fields
    private Reservation reservation;
    private double playTime;
    private String careWorkerComments;

    private String lineReportTitle = "Care Attendant's Comment:";
    private String lineWorkerComments;
    
    
    // constructor
    public ActivityReport(Reservation reservation)
    {
		this.reservation = reservation;
    	if (this.reservation != null)
    		this.careWorkerComments = reservation.getCareTakerComment();
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

    
    public void generateReportDetails() {
    	if (this.careWorkerComments != null && !careWorkerComments.isEmpty())
    		lineWorkerComments = this.careWorkerComments;
    	else 
    		lineWorkerComments = "N/A\n\n\n\n";
    }
   
    public JPanel generateReportGUIContent() {
    	generateReportDetails();
   	
    	JPanel mainPanel = new JPanel(new BorderLayout(0, 20));
    	
    	Font fontTitle = new Font("Verdana", Font.BOLD, 18);
    	Font fontLabel = new Font("Verdana", Font.PLAIN, 15);
   	
    	JLabel lblReportTitle = new JLabel(lineReportTitle);
    	lblReportTitle.setFont(fontTitle);
   	
    	JTextArea txtPane = new JTextArea();
    	txtPane.setSize(5, 200);
    	String formattedComment = lineWorkerComments.replace(". ", ".\n").replace("! ", "!\n");
    	txtPane.setText(formattedComment);
    	txtPane.setEditable(false);
    	txtPane.setFont(fontLabel);
   	
    	JPanel panel = new JPanel(new BorderLayout(0, 10));
    	panel.add(BorderLayout.NORTH, lblReportTitle);
    	panel.add(BorderLayout.CENTER, txtPane);
   
    	return panel;
    }
  
    // generate activity report and write to a default file
    public void generateReport()
    {
        boolean append = true; 
        String filename = "activityreport.txt";
        FileWriter file;
		try {
			file = new FileWriter(filename, append);
			PrintWriter writer = new PrintWriter(file);
	        
	        writer.println("Activity Report:");
	        writer.println("Amount of playtime: " + this.playTime + " hours");
	        
			writer.println("Careworker's comments:");
	        writer.println(careWorkerComments);
	        file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
    }
    
    // @overload - generate activity report and write to a dedicated file
    // for a reservation
    public void generateReport(String filename, boolean append)
    {
        try {
        	FileWriter file = new FileWriter(filename, append);
        	PrintWriter writer = new PrintWriter(file);

        	writer.println(lineReportTitle);
        	writer.println(lineWorkerComments);
        
        	file.close();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
    } 

}