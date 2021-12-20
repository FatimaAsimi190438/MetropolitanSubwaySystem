package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class authenticatePassengerController {

    @FXML
    private Button backToMainMenu;

    @FXML
    private Button cancel;

    @FXML
    private TextField TNo;

    @FXML
    void backToMainMenuButton(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("stationHeadMenu.fxml");
    }

    @FXML
    void cancelButton(ActionEvent event) {

    	if (TNo.getText().isEmpty())
    	{
    		String title = "Incomplete Information";
			String content = "Kindly enter required information to cancel ticket.";
        	AlertMessage(title,content);
    	}
    	else if (!TNo.getText().isEmpty())
    	{
    		if (StationHead.authenticatePassenger(TNo.getText()))
    		{
    			String title = "Success";
    			String content = "The ticket was authenticated successfully.";
            	AlertMessage(title,content);
    		}
    		else
    		{
    			String title = "Failure";
    			String content = "The ticket number you entered does not exist.";
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
}
