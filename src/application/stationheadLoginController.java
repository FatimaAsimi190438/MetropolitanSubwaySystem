package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class stationheadLoginController {

    @FXML
    private TextField StID;

    @FXML
    private PasswordField Stpass;

    @FXML
    private Button Stlogin;

    @FXML
    private Button Back_To_PrevPage1;

    /* For transferring information */
    private String name;
    private Stage NewScene = new Stage();
    
    @FXML
    void PrevPage1(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("MainPage.fxml");
    }
    
    @FXML
    void StloginButton(ActionEvent event) throws IOException {

    	if (StID.getText().isEmpty() && Stpass.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter the required information.";
        	AlertMessage(title,content);	
		}
		else if (StID.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter login ID.";
        	AlertMessage(title,content);
        }
		else if (Stpass.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter password.";
        	AlertMessage(title,content);
        }
		else if (!StID.getText().isEmpty() && !Stpass.getText().isEmpty())
		{
			MetropolitanManagementSytem sms = new MetropolitanManagementSytem();
			
			name = sms.authenticateStationHead(StID.getText(),Stpass.getText());
			if (!sms.authenticateStationHead(StID.getText(),Stpass.getText()).equals("Failed"))
			{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("stationHeadMenu.fxml"));
				BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("stationHeadMenu.fxml"));
				root = loader.load();
				
				stationHeadMenuController stationHeadMenuController = loader.getController();
				
				stationHeadMenuController.displaySTHeadName(name);
				Scene scene = new Scene(root,636,696);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				NewScene.setTitle("Subway Management System");
				NewScene.setScene(scene);
				NewScene.show();
			}
			else
			{
				String title = "Failure";
				String content = "Login Failed.";
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
