package application;

import java.sql.SQLException;
import java.util.Random;

public class Admin {

	private String name;
	private long contactNo;
	private int age;
	private String gender;
	private String loginID;
	private String password;
	
	public boolean checkAdmin(String lID,String pass)
	{
		if (lID.equals(loginID) && pass.equals(password))
		{
			return true;
		}
		else
			return false;
	}
	
	public void manageStationHead(String name, String age, String Cno, String gender, String st) throws SQLException
	{
		// ID : ST(StationNo)-Name
		// Password : Name-(4-Digits)
		String ID, Pass;
		Random rand = new Random();
		String prev;
		
		for (int i=0; i<MetropolitanManagementSytem.getSubwaysystem().size(); i++)
		{
			if (MetropolitanManagementSytem.getSubwaysystem().get(i).getSubwayStationLocation().equals(st))
			{
				StationHead s = new StationHead();
				MetropolitanManagementSytem sms = new MetropolitanManagementSytem();
				
				// Assign values
				s.setName(name);
				s.setAge(Integer.parseInt(age));
				s.setGender(gender);
				s.setContactNo(Long.parseLong(Cno));
				prev = MetropolitanManagementSytem.getSubwaysystem().get(i).getStHeadID().getLoginID();
				
				if (i+1 < 10)
					ID = "ST0"+Integer.toString(i+1)+"-"+name.toUpperCase();
				else
					ID = "ST"+Integer.toString(i+1)+"-"+name.toUpperCase();
				Pass = name.toUpperCase() + Integer.toString(rand.nextInt(10000));
				
				s.setLoginID(ID);
				s.setPassword(Pass);
				
				// Insert into arraylist
				MetropolitanManagementSytem.getStationhead().set(i,s);
				MetropolitanManagementSytem.getSubwaysystem().get(i).setStHeadID(s);
				
				System.out.println(ID + "  " + Pass + "Assigned ID and Password");
				sms.displayStationHead();
				sms.displaySubwaySystem();
				
				// Insert into Database
				DataBase DB = new DataBase();
				DB.updateStationHead(prev,ID,Pass,name,Integer.parseInt(age),Long.parseLong(Cno),gender);
				DB.updateSubwayStation(prev,ID);
			}
		}	
	}
	
	public String CheckEarnings(String s)
	{
		double amountDouble = 0;
		@SuppressWarnings("unused")
		String amountStr; 
		
		for (int i=0; i<MetropolitanManagementSytem.getSubwaysystem().size(); i++)
		{
			if (MetropolitanManagementSytem.getSubwaysystem().get(i).getSubwayStationLocation().equals(s))
			{
				amountDouble = MetropolitanManagementSytem.getSubwaysystem().get(i).getTotalEarnings();
			}
		}

		return amountStr = Double.toString(amountDouble);
	}
	
	public String CheckTickets(String s)
	{
		int tickets = 0;
		@SuppressWarnings("unused")
		String ticketsStr; 
		
		for (int i=0; i<MetropolitanManagementSytem.getSubwaysystem().size(); i++)
		{
			if (MetropolitanManagementSytem.getSubwaysystem().get(i).getSubwayStationLocation().equals(s))
			{
				tickets = MetropolitanManagementSytem.getSubwaysystem().get(i).getTicketsSold();
			}
		}

		return ticketsStr = Integer.toString(tickets);
	}
	
	public String getSelectedStationName(String s)
	{
		String name = null;
		for (int i=0; i<MetropolitanManagementSytem.getSubwaysystem().size(); i++)
		{
			if (MetropolitanManagementSytem.getSubwaysystem().get(i).getSubwayStationLocation().equals(s))
			{
				name = MetropolitanManagementSytem.getSubwaysystem().get(i).getSubwayStationLocation();
			}
		}

		return name;
	}
	
	@Override
	public String toString() {
		return "Admin [name=" + name + ", contactNo=" + contactNo + ", age=" + age + ", gender=" + gender + ", loginID="
				+ loginID + ", password=" + password + "]";
	}

	public void displayInfo()
	{
		System.out.println("name = " + name + ", contactNo = " + contactNo + ", age = " + age + ", gender = " + gender + ", loginID = "
				+ loginID + ", password = " + password);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
