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

public class adminManageStationHeadController {

	@FXML
    private Label SetAdminName;

    @FXML
    private Button Back_To_PrevPage1;

    @FXML
    private Label stationName;

    @FXML
    private TextField Stname;

    @FXML
    private TextField StCNo;

    @FXML
    private TextField Stgender;

    @FXML
    private TextField StAge;

    @FXML
    private Button StSubmit;

    private String Aname;
    
    /* For transferring information */
	private String stationname;
    private Stage NewScene = new Stage();
    
    @FXML
    void PrevPage1(ActionEvent event) throws IOException {

    	FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
		root = loader.load();
		
		AdminMenuController AdminMenuController = loader.getController();
		
		AdminMenuController.displayAdminName(Aname);
		Scene scene = new Scene(root,636,696);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		NewScene.setTitle("Subway Management System");
		NewScene.setScene(scene);
		NewScene.show();
    	//Main m = new Main();
    	//m.NextScene("AdminMenu.fxml");
    }

    @FXML
    void StSubmitBtn(ActionEvent event) throws SQLException {

    	if (Stname.getText().isEmpty() && StAge.getText().isEmpty() && Stgender.getText().isEmpty() && StCNo.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter the required information.";
        	AlertMessage(title,content);	
		}
		else if (Stname.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter name.";
        	AlertMessage(title,content);
        }
		else if (StAge.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter age.";
        	AlertMessage(title,content);
        }
		else if (Stgender.getText().isEmpty())
		{
			String title = "Incomplete Credentials";
			String content = "Kindly enter gender.";
        	AlertMessage(title,content);
        }
		else if (StCNo.getText().isEmpty()) 
        {
			String title = "Incomplete Credentials";
			String content = "Kindly enter StCNo.";
        	AlertMessage(title,content);
        }
		else if (!Stname.getText().isEmpty() && !StAge.getText().isEmpty() && !Stgender.getText().isEmpty() && !StCNo.getText().isEmpty())
		{
			if (Aname.equals("Adeeba Khan"))
    		{
    			(MetropolitanManagementSytem.getAdmin()).get(0).manageStationHead(Stname.getText(),StAge.getText(),StCNo.getText(),Stgender.getText(),stationname);
    			String title = "Success";
				String content = "Updation Successful.";
	        	AlertMessage1(title,content);
    			
    		}
    		else if (Aname.equals("Fatima Asim"))
    		{
    			(MetropolitanManagementSytem.getAdmin()).get(1).manageStationHead(Stname.getText(),StAge.getText(),StCNo.getText(),Stgender.getText(),stationname);
    			String title = "Success";
				String content = "Updation Successful.";
	        	AlertMessage1(title,content);
    		}
			else
			{
				String title = "Failure";
				String content = "Updation Failed.";
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
    
	public void displayAdminName(String name)
    {
		Aname = name;
    	SetAdminName.setText(name);
    }
	
	public void displayStationName(String stname)
    {
		stationname = stname;
    	stationName.setText(stname);
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
