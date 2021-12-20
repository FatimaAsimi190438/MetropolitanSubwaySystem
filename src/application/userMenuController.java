package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class userMenuController {

    @FXML
    private Button buyTicket;

    @FXML
    private Button cancelTicket;

    @FXML
    private Button viewRoutes;

    @FXML
    private Button viewSchedule;

    @FXML
    private Label UserIDLabel;

    @FXML
    private TextField UName;

    @FXML
    private TextField UAge;

    @FXML
    private TextField UGender;

    @FXML
    private TextField UCNo;

    private boolean flag;
    

    private String uname = "";
    private String uage = "";
    private String ugender = "";
    private String ucno = "";
    private Stage NewScene = new Stage();
    
    @FXML
    private Button Back_To_mainpage;

    @FXML
    void Back_To_main(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("MainPage.fxml");
    }
    
    @FXML
    void buyTicketButton(ActionEvent event) throws IOException, SQLException {

    	if (InformationFilled() && flag)
    	{
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("buyTicketPage.fxml"));
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("buyTicketPage.fxml"));
			root = loader.load();
		
			buyTicketPageController buyTicketPageController = loader.getController();
		
			buyTicketPageController.setName(uname);
			buyTicketPageController.setAge(uage);
			buyTicketPageController.setGender(ugender);
			buyTicketPageController.setCNo(ucno);
		
			Scene scene = new Scene(root,636,696);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			NewScene.setTitle("Subway Management System");
			NewScene.setScene(scene);
			NewScene.show();
    	}
    }

    @FXML
    void cancelTicketButton(ActionEvent event) throws SQLException, IOException {

    	if (InformationFilled() && flag)
    	{
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("cancelTicketPage.fxml"));
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("cancelTicketPage.fxml"));
			root = loader.load();
		
			cancelTicketPageController cancelTicketPageController = loader.getController();
		
			cancelTicketPageController.setName(uname);
			cancelTicketPageController.setAge(uage);
			cancelTicketPageController.setGender(ugender);
			cancelTicketPageController.setCNo(ucno);
		
			Scene scene = new Scene(root,636,696);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			NewScene.setTitle("Subway Management System");
			NewScene.setScene(scene);
			NewScene.show();
    	}
    }

    @FXML
    void viewRoutesButton(ActionEvent event) throws SQLException, IOException {
		Main m = new Main();
		m.NextScene("viewRoute.fxml");
    }

    @FXML
    void viewScheduleButton(ActionEvent event) throws SQLException, IOException {
    	
		Main m = new Main();
		m.NextScene("viewScheduleUser.fxml");
    }
    
    public boolean InformationFilled() throws SQLException
    {
        flag = false;
        int AGE = Integer.parseInt(UAge.getText().toString());
        String g = UGender.getText();
        try {
    	if(AGE<18) 
    		throw new ageException("Age must be greater than 18");	
    	}
		catch(ageException e) {
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
    	//contactno size exception
    	try {
    		if (UCNo.getText().length()!= 8) 
    			throw new inputException("Contact No Must be of size 8");
    	}
    	catch(inputException e) {
    		System.err.println(e);
    	}
    	if(AGE<18) {
    		String title = "Under Age";
			String content = "Age should be greater than 18.";
        	AlertMessage(title,content);
    	}
    	if (UCNo.getText().length()!= 8) {
    		String title = "Incorrect Contact Number";
			String content = "Contact Number Must Have 8 Digits.";
        	AlertMessage(title,content);
    	}
    	if (UName.getText().isEmpty() && UAge.getText().isEmpty() && UGender.getText().isEmpty() && UCNo.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter the required information.";
        	AlertMessage(title,content);	
        	return false;
		}
		else if (UName.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter name.";
        	AlertMessage(title,content);
        	return false;
        }
		else if (UAge.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter age.";
        	AlertMessage(title,content);
        	return false;
        }
		else if (UGender.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter gender.";
        	AlertMessage(title,content);
        	return false;
        }
		else if (UCNo.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter contact No.";
        	AlertMessage(title,content);
        	return false;
        }
		else if (!UName.getText().isEmpty() && !UAge.getText().isEmpty() && !UGender.getText().isEmpty() && !UCNo.getText().isEmpty())
		{
			if(AGE>18 && (UCNo.getText().length()== 8)&& (g.equals("male") || g.equals("female") || g.equals("Female") || g.equals("Male")))
			{
			uname = UName.getText();
			uage = UAge.getText();
			ugender = UGender.getText();
			ucno = UCNo.getText();
			flag = true;
			}
		}
		return true; 
    } 
    
    private void AlertMessage (String title, String content)
    {
    	Alert alert = new Alert(AlertType.WARNING);
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
