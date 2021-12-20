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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class memberProcessPaymentController {

	@FXML
    private Button backToBuy;
	
    @FXML
    private Button depositSlot;

    @FXML
    private Button backToMainMenu;

    @FXML
    private Label userID_mID;

    @FXML
    private Label origin;

    @FXML
    private Label tickets;

    @FXML
    private Label destination;

    private String mID = "";
    
    @FXML
    private Label bill;

    private String uname = "";
    private String uage = "";
    private String ugender = "";
    private String ucno = "";
    

    private Stage NewScene = new Stage();
    
    @FXML
    void backToBuy(ActionEvent event) throws IOException {

    	FXMLLoader loader = new FXMLLoader(getClass().getResource("buyTicketPageMember.fxml"));
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("buyTicketPageMember.fxml"));
		root = loader.load();
		
		buyTicketPageMemberController buyTicketPageMemberController = loader.getController();
		
		buyTicketPageMemberController.setName(uname);
		Scene scene = new Scene(root,636,696);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		NewScene.setTitle("Subway Management System");
		NewScene.setScene(scene);
		NewScene.show();
    }
    
    public void displayOrigin(String o)
    {
    	origin.setText(o);
    }
    
    public void displayDestination(String d)
    {
    	destination.setText(d);
    }
    
    public void displayTickets(String t)
    {
    	tickets.setText(t);
    }
    
    public void displayBill(String b)
    {
    	bill.setText(b);
    }
    
    public void getMemberID(String ID)
	{
		mID = ID;
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
    void depositSlotButton(ActionEvent event) throws NumberFormatException, SQLException {

    	// process Ticket
    	
    	if (MetropolitanManagementSytem.ticketPurchased(mID,uname,uage,ugender,ucno,Integer.parseInt(tickets.getText()),origin.getText(),destination.getText()))
    	{
    		String title = "Success";
    		String content = "Your payment has been confirmed/processed.";
        	AlertMessage(title,content);
    	}
    	else
    	{
    		String title = "Failure";
    		String content = "You do not have enough balance in your Card.";
        	AlertMessage1(title,content);
    	}
    }
    
    public void setName(String n)
	{
    	userID_mID.setText(n);
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
	
    private void AlertMessage (String title, String content)
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		alert.showAndWait();
	}
    
    private void AlertMessage1 (String title, String content)
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
