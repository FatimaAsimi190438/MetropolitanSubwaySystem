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

public class cancelTicketPageMemberController {

	@FXML
    private Label membername;

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
    
    private Stage NewScene = new Stage();
    
    public void setName(String n)
	{
		uname = n;
		membername.setText(n);
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

    	FXMLLoader loader = new FXMLLoader(getClass().getResource("MemberMenu.fxml"));
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MemberMenu.fxml"));
		root = loader.load();
		
		MemberMenuController MemberMenuController = loader.getController();
		
		MemberMenuController.displayMemberName(uname);;
		Scene scene = new Scene(root,636,696);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		NewScene.setTitle("Subway Management System");
		NewScene.setScene(scene);
		NewScene.show();
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
    			String content = "The ticket was cancelled successfully. Your card was updated too.";
            	AlertMessage1(title,content);
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
