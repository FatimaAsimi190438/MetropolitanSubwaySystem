package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class cardDetailsController {

	 	@FXML
	    private Label SetAdminName;

	    @FXML
	    private Button Back_To_PrevPage1;

	    @FXML
	    private TextField StCNo;

	    @FXML
	    private Button StSubmit;

	    @FXML
	    private Label CardID;

	    @FXML
	    private Label CardBal;
	    private Stage NewScene = new Stage();
	    
	    @FXML
	    private Button click;

	    @FXML
	    void click(ActionEvent event) {

	    	for (int i=0; i<MetropolitanManagementSytem.getCard().size(); i++)
    		{
    			if (MetropolitanManagementSytem.getCard().get(i).getM_ID().equals(mID))
    			{
    				CardID.setText(MetropolitanManagementSytem.getCard().get(i).getCardID());
    				CardBal.setText(Double.toString(MetropolitanManagementSytem.getCard().get(i).getCardBalance()));
    			}
    		}
	    }
	    
	    @FXML
	    void PrevPage1(ActionEvent event) throws IOException {

	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("MemberMenu.fxml"));
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MemberMenu.fxml"));
			root = loader.load();
			
			MemberMenuController MemberMenuController = loader.getController();
			
			MemberMenuController.displayMemberName(uname);
			Scene scene = new Scene(root,636,696);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			NewScene.setTitle("Subway Management System");
			NewScene.setScene(scene);
			NewScene.show();
	    }

	    @FXML
	    void StSubmitBtn(ActionEvent event) throws NumberFormatException, SQLException {

	    	double amount = Integer.parseInt(StCNo.getText().toString());
	    	try {
	        	if(amount>500) 
	        		throw new cardBalanceException("You cannot deposit more than Rs.500");	
	        	}
	    		catch(cardBalanceException e) {
	    			System.err.println(e);	   
	    		}
	    	if(amount>500) {
	    		String title = "Balance";
				String content = "You cannot deposit more than Rs.500";
	        	AlertMessage(title,content);
	    	}
	    	if (StCNo.getText().isEmpty())
	    	{
	    		String title = "Incomplete Information";
				String content = "Kindly specify amount.";
	        	AlertMessage(title,content);
	    	}
	    	else if (!StCNo.getText().isEmpty())
	    	{
	    		if(amount<=500)
				{
	    		MetropolitanManagementSytem.addingBalance(mID,Double.parseDouble(StCNo.getText()));
	    		String title = "Information";
				String content = "Successful";
	        	AlertMessage1(title,content);
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
	    
	    private String mID;
	    private String uname;
	
	    public void setName(String n)
	    {
	    	SetAdminName.setText(n);
	    	uname = n;
	    }
	
	    public void getMemberID(String ID)
	    {
	    	mID = ID;
	    }
}
