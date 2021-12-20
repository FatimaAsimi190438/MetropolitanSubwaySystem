package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class cancelTicketPageController {

    @FXML
    private Button backToMainMenu;

    @FXML
    private Button cancel;

    @FXML
    private TextField TNo;

    private String uname = "";
    private String uage = "";
    private String ugender = "";
    private String ucno = "";
    
    public void setName(String n)
	{
		uname = n;
	}
	
	public void setAge(String a)
	{
		uage = a;
	}
	
	public void setGender(String g)
	{
		ugender = g;
	}
	
	public void setCNo(String c)
	{
		ucno = c;
	}
	
    @FXML
    void backToMainMenuButton(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("userMenu.fxml");	
    }

    @FXML
    void cancelButton(ActionEvent event) throws SQLException {

    	if (TNo.getText().isEmpty())
    	{
    		String title = "Incomplete Information";
			String content = "Kindly enter required information to cancel ticket.";
        	AlertMessage(title,content);
    	}
    	else if (!TNo.getText().isEmpty())
    	{
    		if (MetropolitanManagementSytem.ticketCancelling(TNo.getText()))
    		{
    			String title = "Success";
    			String content = "The ticket was cancelled successfully.";
            	AlertMessage(title,content);
    		}
    		else
    		{
    			String title = "Failure";
    			String content = "The ticket number you entered does not exist.";
            	AlertMessage(title,content);
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
