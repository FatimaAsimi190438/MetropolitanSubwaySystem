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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class adminLoginController {

    @FXML
    private TextField AID;

    @FXML
    private Button Alogin;

    @FXML
    private Button Back_To_PrevPage1;

    @FXML
    private PasswordField Apass;

    /* For transferring information */
    private String name;
    private Stage NewScene = new Stage();
    
    @FXML
    void AloginButton(ActionEvent event) throws IOException, SQLException {

    	if (AID.getText().isEmpty() && Apass.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter the required information.";
        	AlertMessage(title,content);	
		}
		else if (AID.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter login ID.";
        	AlertMessage(title,content);
        }
		else if (Apass.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter password.";
        	AlertMessage(title,content);
        }
		else if (!AID.getText().isEmpty() && !Apass.getText().isEmpty())
		{
			MetropolitanManagementSytem sms = new MetropolitanManagementSytem();
			
			if (sms.AuthenticateAdmin(AID.getText(),Apass.getText()) == 1 || sms.AuthenticateAdmin(AID.getText(),Apass.getText()) == 2)
			{
				if (sms.AuthenticateAdmin(AID.getText(),Apass.getText()) == 1)
					name = "Adeeba Khan";
				if (sms.AuthenticateAdmin(AID.getText(),Apass.getText()) == 2)
					name = "Fatima Asim";
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
				BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
				root = loader.load();
				
				AdminMenuController AdminMenuController = loader.getController();
				
				AdminMenuController.displayAdminName(name);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
    void PrevPage1(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("MainPage.fxml");
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
