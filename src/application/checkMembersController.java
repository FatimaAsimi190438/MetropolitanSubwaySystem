package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class checkMembersController implements Initializable{

    @FXML
    private Label StnameLabel;

    @FXML
    private Button logout;

    @FXML
    private TableView<ModelMemberTable> MemberTable;

    @FXML
    private TableColumn<ModelMemberTable, String> col_ID;

    @FXML
    private TableColumn<ModelMemberTable, String> col_n;

    @FXML
    private TableColumn<ModelMemberTable, String> col_age;

    @FXML
    private TableColumn<ModelMemberTable, String> col_cno;

    @FXML
    private TableColumn<ModelMemberTable, String> col_gender;

    @FXML
    private TableColumn<ModelMemberTable, String> col_card;

    @FXML
    private TableColumn<ModelMemberTable, String> col_rides;

    @FXML
    private TableColumn<ModelMemberTable, String> col_pass;

    @FXML
    private Button Back_To_mainpage1;

    @FXML
    void Back_To_main(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("stationHeadMenu.fxml");
    }

    @FXML
    void logout(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.NextScene("MainPage.fxml");
    }
    
    ObservableList<ModelMemberTable> oblist = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Connection con;
		try {
			con = DataBase.getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from Member");
			
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				oblist.add(new ModelMemberTable(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		col_ID.setCellValueFactory(new PropertyValueFactory<>("member"));
		col_pass.setCellValueFactory(new PropertyValueFactory<>("password"));
		col_n.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
		col_cno.setCellValueFactory(new PropertyValueFactory<>("cno"));
		col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		col_card.setCellValueFactory(new PropertyValueFactory<>("card"));
		col_rides.setCellValueFactory(new PropertyValueFactory<>("totalrides"));
		
		MemberTable.setItems(oblist);
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
