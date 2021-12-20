package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class buyTicketPageMemberController implements Initializable{

    @FXML
    private Button buy;

    @FXML
    private Button backToMainMenu;

    @FXML
    private TextField noOfTickets;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private ComboBox<String> combo1;

    @FXML
    private TextField bill;

    @FXML
    private Label userID_mID;

    private String mID;
    private String origin = "";
    private String destination = "";
    private String tickets;
    private String calculatedbill = "";
    private String uname = "";
    private String uage = "";
    private String ugender = "";
    private String ucno = "";
    private Stage NewScene = new Stage();
    
    @FXML
    void BillDisplay(MouseEvent event) {

    	if (calculatedbill == "")
    	{
    		String title = "Incomplete Information";
			String content = "Kindly enter required information to display Bill.";
        	AlertMessage(title,content);
    	}
    	else
    	{
    		bill.setText(calculatedbill);
    	}
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
    void buyButton(ActionEvent event) throws IOException {

    	int tn = Integer.parseInt(noOfTickets.getText().toString());
    	try {
        	if(tn>5) 
        		throw new ticketNumberException("You cannot purchase more than 5 tickets.");	
        	}
    		catch(ticketNumberException e) {
    			System.err.println(e);	   
    		}
    	if(tn>5) {
    		String title = "Ticket Number";
			String content = "You cannot purchase more than 5 tickets.";
        	AlertMessage(title,content);
    	}
    	if (origin == "" && destination == "" && noOfTickets.getText().isEmpty())
    	{
    		String title = "Incomplete Information";
			String content = "Kindly enter required information to buy the ticket/tickets.";
        	AlertMessage(title,content);
    	}
    	else if (origin == "" )
    	{
    		String title = "Incomplete Information";
			String content = "Kindly select origin.";
        	AlertMessage(title,content);
    	}
    	else if (destination == "")
    	{
    		String title = "Incomplete Information";
			String content = "Kindly select destination.";
        	AlertMessage(title,content);
    	}
    	else if (noOfTickets.getText().isEmpty())
    	{
    		String title = "Incomplete Information";
			String content = "Kindly specify the no. of tickets.";
        	AlertMessage(title,content);
    	}
    	else if (origin != "" && destination != "" && !noOfTickets.getText().isEmpty())
    	{
    		if(tn<=5)
			{
    		tickets = noOfTickets.getText();
    		calculatedbill = Double.toString(MetropolitanManagementSytem.generateBill(Integer.parseInt(tickets)));
    		if (origin.equals(destination))
    		{
    			String title = "Incomplete Information";
    			String content = "Origin and Destination cannot be same. Kindly check your entered information";
            	AlertMessage(title,content);
    		}
    		else
    		{
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("memberProcessPayment.fxml"));
    			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("memberProcessPayment.fxml"));
    			root = loader.load();
    		
    			memberProcessPaymentController memberProcessPaymentController = loader.getController();
    		
    			memberProcessPaymentController.displayOrigin(origin);
    			memberProcessPaymentController.displayDestination(destination);
    			memberProcessPaymentController.displayTickets(tickets);
    			memberProcessPaymentController.displayBill(calculatedbill);
    		
    			memberProcessPaymentController.getMemberID(mID);
    			memberProcessPaymentController.setName(uname);
    			memberProcessPaymentController.setAge(uage);
    			memberProcessPaymentController.setGender(ugender);
    			memberProcessPaymentController.setCNo(ucno);
    			
    			Scene scene = new Scene(root,636,696);
    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    			NewScene.setTitle("Subway Management System");
    			NewScene.setScene(scene);
    			NewScene.show();
    		}
			}
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
	
    @FXML
    void select(ActionEvent event) {

    	String s = combo.getSelectionModel().getSelectedItem().toString();
    	origin = s;
    }

    @FXML
    void select1(ActionEvent event) {

    	String s = combo1.getSelectionModel().getSelectedItem().toString();
    	destination = s;
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> list = FXCollections.observableArrayList("Saddar"," Marrir Chowk"," Liaquat Bagh"," Committee Chowk","Waris Khan ","Chandi Chowk ", "Rehmanabad ","6th Road","Shamsabad","Faizabad","IJP","Pothohar","Khayaban e Johar","Faiz Ahmed Faiz","Kashmir Highway","Chaman","Ibn E Sina","Katchery","PIMS","Stock Exchange","7th Avenue","Shaheed E Milat","Parade Ground","Pak Sacritariat");combo1.setItems(list);
		combo.setItems(list);
		combo1.setItems(list);
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
