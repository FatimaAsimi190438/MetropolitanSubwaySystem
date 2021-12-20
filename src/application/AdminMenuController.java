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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AdminMenuController implements Initializable{

	@FXML
    private Button ManageStHead;

    @FXML
    private Button allEarning;

    @FXML
    private Button ticketsSold;

    @FXML
    private ComboBox<String> combo2;

    @FXML
    private Label SetAdminName;

    @FXML
    private Label AllMembers;

    @FXML
    private Button Back_To_PrevPage1;
    
    private String selected = "" ;

    @FXML
    private Label Earnigs;

    @FXML
    private Label TicketsSold;

    @FXML
    private Label stationName;

    private String Aname;
    
    /* For transferring information */
    private Stage NewScene = new Stage();
    private String station;
    
    @FXML
    void ManageStHeadButton(ActionEvent event) throws IOException {

    	displayAdminName(Aname);
    	if (selected == "")
    	{
    		String title = "Information";
			String content = "Select the Station.";
        	AlertMessage(title,content);
    	}
    	else
    	{
    		if (Aname.equals("Adeeba Khan"))
    		{
    			station = (MetropolitanManagementSytem.getAdmin()).get(0).getSelectedStationName(selected);
    		}
    		else if (Aname.equals("Fatima Asim"))
    		{
    			station = (MetropolitanManagementSytem.getAdmin()).get(0).getSelectedStationName(selected);
    		}
		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminManageStationHead.fxml"));
    		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("adminManageStationHead.fxml"));
    		root = loader.load();
    		adminManageStationHeadController adminManageStationHeadController = loader.getController();
		    adminManageStationHeadController.displayAdminName(Aname);
    		adminManageStationHeadController.displayStationName(station);
    		Scene scene = new Scene(root,636,696);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		NewScene.setTitle("Subway Management System");
    		NewScene.setScene(scene);
    		NewScene.show();
    	}
    }
    
    @FXML
    void PrevPage1(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("adminLogin.fxml");
    }

    public void displayAdminName(String name)
    {
    	Aname = name;
    	SetAdminName.setText(name);
    }
    
	@FXML
    void allEarningButton(ActionEvent event) {

    	if (selected == "")
    	{
    		String title = "Information";
			String content = "Select the Station.";
        	AlertMessage(title,content);
    	}
    	else
    	{
    		if (Aname.equals("Adeeba Khan"))
    		{
    			Earnigs.setText((MetropolitanManagementSytem.getAdmin()).get(0).CheckEarnings(selected));
    			station = (MetropolitanManagementSytem.getAdmin()).get(0).getSelectedStationName(selected);
    		}
    		else if (Aname.equals("Fatima Asim"))
    		{
    			Earnigs.setText((MetropolitanManagementSytem.getAdmin()).get(1).CheckEarnings(selected));
    			station = (MetropolitanManagementSytem.getAdmin()).get(0).getSelectedStationName(selected);
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
    void select2(ActionEvent event) {

    	String s = combo2.getSelectionModel().getSelectedItem().toString();
    	selected = s;
    	stationName.setText(selected);
    }

    @FXML
    void ticketsSoldButton(ActionEvent event) {

    	if (selected == "")
    	{
    		String title = "Information";
			String content = "Select the Station.";
        	AlertMessage(title,content);
    	}
    	else
    	{
    		if (Aname.equals("Adeeba Khan"))
    		{
    			TicketsSold.setText((MetropolitanManagementSytem.getAdmin()).get(0).CheckTickets(selected));
    		}
    		else if (Aname.equals("Fatima Asim"))
    		{
    			TicketsSold.setText((MetropolitanManagementSytem.getAdmin()).get(1).CheckTickets(selected));
    		}
    	}
    }
        
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> list = FXCollections.observableArrayList("Saddar"," Marrir Chowk"," Liaquat Bagh"," Committee Chowk","Waris Khan ","Chandi Chowk ", "Rehmanabad ","6th Road","Shamsabad","Faizabad","IJP","Pothohar","Khayaban e Johar","Faiz Ahmed Faiz","Kashmir Highway","Chaman","Ibn E Sina","Katchery","PIMS","Stock Exchange","7th Avenue","Shaheed E Milat","Parade Ground","Pak Sacritariat");
		combo2.setItems(list);
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
