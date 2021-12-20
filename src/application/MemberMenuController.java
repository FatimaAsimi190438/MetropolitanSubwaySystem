package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MemberMenuController {

	@FXML
    private Button buyTicket;

    @FXML
    private Button cancelTicket;

    @FXML
    private Button viewRoutes;

    @FXML
    private Button viewSchedule;

    @FXML
    private Button cardDetails;

    @FXML
    private Button backToMainMenu9;

    @FXML
    private Label mName;
    
    private String mID;
    private String name;
    private Stage NewScene = new Stage();

    @FXML
    void CardDetailsButtonButton(ActionEvent event) throws IOException {

    	FXMLLoader loader = new FXMLLoader(getClass().getResource("cardDetails.fxml"));
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("cardDetails.fxml"));
		root = loader.load();
		
		cardDetailsController cardDetailsController = loader.getController();
		
		cardDetailsController.setName(name);
		cardDetailsController.getMemberID(mID);
		Scene scene = new Scene(root,636,696);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		NewScene.setTitle("Subway Management System");
		NewScene.setScene(scene);
		NewScene.show();
    }

    @FXML
    void backToMainMenuButton9(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("MainPage.fxml");
    }

    @FXML
    void buyTicketButton(ActionEvent event) throws IOException {

    	FXMLLoader loader = new FXMLLoader(getClass().getResource("buyTicketPageMember.fxml"));
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("buyTicketPageMember.fxml"));
		root = loader.load();
		
		buyTicketPageMemberController buyTicketPageMemberController = loader.getController();
		
		buyTicketPageMemberController.setName(name);
		buyTicketPageMemberController.getMemberID(mID);
		Scene scene = new Scene(root,636,696);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		NewScene.setTitle("Subway Management System");
		NewScene.setScene(scene);
		NewScene.show();
    }

    @FXML
    void cancelTicketButton(ActionEvent event) throws IOException {

    	FXMLLoader loader = new FXMLLoader(getClass().getResource("cancelTicketPageMember.fxml"));
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("cancelTicketPageMember.fxml"));
		root = loader.load();
		
		cancelTicketPageMemberController cancelTicketPageMemberController = loader.getController();
		
		cancelTicketPageMemberController.setName(name);
		Scene scene = new Scene(root,636,696);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		NewScene.setTitle("Subway Management System");
		NewScene.setScene(scene);
		NewScene.show();
    }

    @FXML
    void viewRoutesButton(ActionEvent event) throws IOException {

    	Main m = new Main();
		m.NextScene("viewRouteMember.fxml");
    }

    @FXML
    void viewScheduleButton(ActionEvent event) throws IOException {

    	Main m = new Main();
		m.NextScene("viewSchedule.fxml");
    }
    
	public void displayMemberName(String n)
    {
		name = n;
    	mName.setText(n);
    }
	
	public void getMemberID(String ID)
	{
		mID = ID;
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

