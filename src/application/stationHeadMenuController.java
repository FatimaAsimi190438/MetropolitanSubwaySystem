package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

public class stationHeadMenuController {

    @FXML
    private Label StnameLabel;

    @FXML
    private Button Back_To_mainpage;

    @FXML
    private Button manageSchedule;

    @FXML
    private Button manageUsers;

    @FXML
    private Button manageticket;

    @FXML
    void Back_To_main(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("MainPage.fxml");
    }
    
    public void displaySTHeadName(String n)
    {
    	StnameLabel.setText(n);
    }

    @FXML
    void ManageTicketButton(ActionEvent event) throws IOException {
    	
    	Main m = new Main();
    	m.NextScene("checkMembers.fxml");
    }

    // authenticates Passenger
    @FXML
    void manageScheduleButton(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("authenticatePassenger.fxml");
    }

    @FXML
    void manageUserButton(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("checkUsers.fxml");
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
