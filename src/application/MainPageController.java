package application;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;

public class MainPageController {

    @FXML
    private TextField name;

    @FXML
    private TextField age;

    @FXML
    private TextField contactno;

    @FXML
    private TextField genderr;

    @FXML
    private Button register;

    @FXML
    private Button login;

    @FXML
    private Button guest;

    @FXML
    private Button admin;

    @FXML
    private Button Store;

    @FXML
    void StoreBTn(ActionEvent event) throws IOException {

    	FileWriter FileWrite = new FileWriter("Admin.txt");
		for (int i=0; i<MetropolitanManagementSytem.getAdmin().size(); i++)
		{
			FileWriter fw = null; 
			BufferedWriter bw = null; 
			PrintWriter pw = null;
			try { 
				fw = new FileWriter("Admin.txt", true); 
				bw = new BufferedWriter(fw); 
				pw = new PrintWriter(bw); 
				pw.write("\nAdmin Details" );
				pw.write("\nName             : " + MetropolitanManagementSytem.getAdmin().get(i).getName());
				pw.write("\nGender           : " + MetropolitanManagementSytem.getAdmin().get(i).getGender());
				pw.write("\nAge              : " + MetropolitanManagementSytem.getAdmin().get(i).getAge());
				pw.write("\nLoginID          : " + MetropolitanManagementSytem.getAdmin().get(i).getLoginID());
				pw.write("\nPassword  : " + MetropolitanManagementSytem.getAdmin().get(i).getPassword());
				
				pw.flush();
				}finally { 
					try { 
						pw.close(); 
						bw.close(); 
						fw.close(); 
						} catch (IOException io) { }
				}
		}
		
		FileWriter FileWrite1 = new FileWriter("Card.txt");
		for (int i=0; i<MetropolitanManagementSytem.getCard().size(); i++)
		{
			FileWriter fw = null; 
			BufferedWriter bw = null; 
			PrintWriter pw = null;
			try { 
				fw = new FileWriter("Card.txt", true); 
				bw = new BufferedWriter(fw); 
				pw = new PrintWriter(bw); 
				pw.write("\nCard Details " );
				pw.write("\nMember ID             : " + MetropolitanManagementSytem.getCard().get(i).getM_ID());
				pw.write("\nCard ID           : " + MetropolitanManagementSytem.getCard().get(i).getCardID());
				pw.write("\nBalance              : " + MetropolitanManagementSytem.getCard().get(i).getCardBalance());
				
				pw.flush();
				}finally { 
					try { 
						pw.close(); 
						bw.close(); 
						fw.close(); 
						} catch (IOException io) { }
				}
		}
		
		FileWriter FileWrite2 = new FileWriter("Tickets.txt");
		for (int i=0; i<MetropolitanManagementSytem.getTickets().size(); i++)
		{
			FileWriter fw = null; 
			BufferedWriter bw = null; 
			PrintWriter pw = null;
			try { 
				fw = new FileWriter("Tickets.txt", true); 
				bw = new BufferedWriter(fw); 
				pw = new PrintWriter(bw); 
				pw.write("\nTickets Details " );
				pw.write("\nUser ID             : " + MetropolitanManagementSytem.getTickets().get(i).getU_ID());
				pw.write("\nTicketNo             : " + MetropolitanManagementSytem.getTickets().get(i).getTicketNumber());
				pw.write("\nFare             : " + MetropolitanManagementSytem.getTickets().get(i).getFare());
				pw.write("\nOrigin           : " + MetropolitanManagementSytem.getTickets().get(i).getOrigin());
				pw.write("\nDestination              : " + MetropolitanManagementSytem.getTickets().get(i).getDestination());
				
				pw.flush();
				}finally { 
					try { 
						pw.close(); 
						bw.close(); 
						fw.close(); 
						} catch (IOException io) { }
				}
		}
		
		FileWriter FileWrite3 = new FileWriter("Members.txt");
		FileWriter fw = null; 
		BufferedWriter bw = null; 
		PrintWriter pw = null;
		for (int i=0; i<MetropolitanManagementSytem.getMembers().size(); i++)
		{
		try { 
			fw = new FileWriter("Members.txt", true); 
			bw = new BufferedWriter(fw); 
			pw = new PrintWriter(bw); 
			pw.write("\n");
			pw.write("\nMember: " );
			pw.write("\nName             : " + MetropolitanManagementSytem.getMembers().get(i).getName());
			pw.write("\nGender           : " + MetropolitanManagementSytem.getMembers().get(i).getGender());
			pw.write("\nAge              : " + MetropolitanManagementSytem.getMembers().get(i).getAge());
			pw.write("\nLoginID          : " + MetropolitanManagementSytem.getMembers().get(i).getMemberID());
			pw.write("\nPassword  : " + MetropolitanManagementSytem.getMembers().get(i).getPassword());
			pw.write("\nCID  : " + MetropolitanManagementSytem.getMembers().get(i).getcID().getCardID());
			pw.write("\nNo of Rides  : " + MetropolitanManagementSytem.getMembers().get(i).getNoOfRides());
			pw.flush();
			}finally { 
				try { 
					pw.close(); 
					bw.close(); 
					fw.close(); 
					} catch (IOException io) { }
			}
		}
    }
    
    @FXML
    void AdminLogin(ActionEvent event) throws IOException {

    	Main next = new Main();
    	next.NextScene("adminLogin.fxml");
    }

    @FXML
    void guestButton(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("UserMenu.fxml");
    }

    @FXML
    void loginButton(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("login.fxml");
    }

    @FXML
    void registerButton(ActionEvent event) throws SQLException {

    	int AGE = Integer.parseInt(age.getText().toString());
    	String g = genderr.getText();
    	try {
    	if(AGE<18) 
    		throw new ageException("Age must be greater than 18");	
    	}
		catch(ageException e) {
			System.err.println(e);	   
		}
    	//contactno size exception
    	try {
    		if (contactno.getText().length()!= 8) 
    			throw new inputException("Contact No Must be of size 8");
    	}
    	catch(inputException e) {
    		System.err.println(e);
    	}
    	try {
        	if(!g.equals("male") || !g.equals("female") || !g.equals("Female") || !g.equals("Male")) 
        		throw new genderException("Gender can be only Male or Female");	
        	}
    		catch(genderException e) {
    			System.err.println(e);	   
    		}
    	if(!g.equals("male") || !g.equals("female") || !g.equals("Female") || !g.equals("Male")) {
    		String title = "Gender";
			String content = "Gender can be only Male or Female";
        	AlertMessage(title,content);
    	}
    	if(AGE<18) {
    		String title = "Under Age";
			String content = "Age should be greater than 18.";
        	AlertMessage(title,content);
    	}
    	if (contactno.getText().length()!= 8) {
    		String title = "Incorrect Contact Number";
			String content = "Contact Number Must Have 8 Digits.";
        	AlertMessage(title,content);
    	}
    	if (name.getText().isEmpty() && age.getText().isEmpty() && contactno.getText().isEmpty() && genderr.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter the required information.";
        	AlertMessage(title,content);	
		}
		else if (name.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter name.";
        	AlertMessage(title,content);
        }
		else if (age.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter age.";
        	AlertMessage(title,content);
        }
		else if (genderr.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter gender.";
        	AlertMessage(title,content);
        }
		else if (contactno.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter contact No.";
        	AlertMessage(title,content);
        }
		else if (!name.getText().isEmpty() && !age.getText().isEmpty() && !genderr.getText().isEmpty() && !contactno.getText().isEmpty())
		{
			if(AGE>18 && (contactno.getText().length()== 8) && (g.equals("male") || g.equals("female") || g.equals("Female") || g.equals("Male")))
			{
			MetropolitanManagementSytem.createMember(name.getText(),age.getText(),genderr.getText(),contactno.getText());
			String title = "Success";
			String content = "You have been registered Successfully. You have been assigned a 'Card' with initial Balance: Rs.500.";
        	AlertMessage1(title,content);
			}
		}
    }

    private void AlertMessage (String title, String content)
    {
    	Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
        alert.showAndWait();
    }
    
    private void AlertMessage1 (String title, String content)
    {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
        alert.showAndWait();
    }
    
    @FXML
    private Hyperlink help;
    @FXML
    private Hyperlink contactus;
    @FXML
    private Hyperlink faqs;
    @FXML
    private Hyperlink AboutUS;

    @FXML
    void contactUS(ActionEvent event) throws IOException, URISyntaxException {
    	System.out.println("link opened");
    	Desktop.getDesktop().browse(new URI("https://www.metro.net/about/contacts/"));
    }
    
    @FXML
    void aboutUS(ActionEvent event) throws IOException, URISyntaxException {
    	System.out.println("link opened");
    	Desktop.getDesktop().browse(new URI("https://www.zameen.com/blog/metro-bus-islamabad.html"));
    }

    @FXML
    void FAQs(ActionEvent event) throws IOException, URISyntaxException {
    	System.out.println("link opened");
    	Desktop.getDesktop().browse(new URI("https://pma.punjab.gov.pk/faqs"));
    }

    @FXML
    void Help(ActionEvent event) throws IOException, URISyntaxException {
    	System.out.println("link opened");
    	Desktop.getDesktop().browse(new URI("https://pma.punjab.gov.pk/helpline"));

    }
}
