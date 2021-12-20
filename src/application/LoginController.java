package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

public class LoginController {

    @FXML
    private Button login_member;

    @FXML
    private Button loginSt_head;

    @FXML
    private Button Back_To_mainpage;

    @FXML
    void Back_To_main(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("MainPage.fxml");
    }

    @FXML
    void Login_STH_Button(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("stationheadLogin.fxml");
    }

    @FXML
    void login_mem_button(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("memberLogin.fxml");
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
