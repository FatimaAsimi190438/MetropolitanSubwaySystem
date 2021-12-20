package application;

import java.sql.SQLException;

public class Member extends User{
	
	private String memberID;
	private String password;
	private Card cID;
	private int noOfRides;
	
	public Member(String name, String age, long contactNo, String gender, String memberID, String password,
			double cardBalance, int noOfRides) {
		super(name, age, contactNo, gender);
		this.memberID = memberID;
		this.password = password;
		this.noOfRides = noOfRides;
	}

	public void displayInfo()
	{
		System.out.println("name = " + name + ", contactNo = " + contactNo + ", age = " + age + ", gender = " + gender + ", memberID = "
				+ memberID + ", pass = " + password + ", rides = " + noOfRides + ", cID = " + cID.getCardID() + ", balance = " + cID.getCardBalance());
		for (int i=0; i<tickets.size(); i++)
		{
			tickets.get(i).displayInfo();
		}
	}
	
	public void registerAsMember() throws SQLException
	{
		Card c = new Card();
		c.setCardID("c"+Integer.toString(MetropolitanManagementSytem.getCard().size()+101));
		c.setCardBalance(500);
		c.setM_ID(memberID);
		noOfRides = 0;
		cID = c;
		MetropolitanManagementSytem.getCard().add(c);
		DataBase DB = new DataBase();
		DB.createConnection();
		DB.insertCard(c);
	}
	
	public boolean checkMember(String lID,String pass)
	{
		if (lID.equals(memberID) && pass.equals(password))
		{
			return true;
		}
		else
			return false;
	}
	
	public void incrementRides(int r)
	{
		noOfRides += r;
	}
	
	public void decrementRides(int r)
	{
		noOfRides -= r;
	}
	
	@Override
	public boolean makePayment() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Member(String name, String age, long contactNo, String gender, long cNIC) {
		super(name, age, contactNo, gender);
		// TODO Auto-generated constructor stub
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNoOfRides() {
		return noOfRides;
	}

	public void setNoOfRides(int noOfRides) {
		this.noOfRides = noOfRides;
	}

	public Card getcID() {
		return cID;
	}

	public void setcID(Card cID) {
		this.cID = cID;
	}
}
