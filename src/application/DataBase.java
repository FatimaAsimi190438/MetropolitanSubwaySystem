package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

	private Connection con;
	private static Connection connect;
	
	public void createConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("\nDriver Loaded Successfully!");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","tiger1234"); 
			System.out.println("Connection Established!");			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("\nDriver Loaded Successfully!");
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","tiger1234"); 
		System.out.println("Connection Established!");	
		return connect;
	}
	
	public void retreiveAdminCredentials() throws SQLException
	{
		createConnection();
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from Admin");
		
		while(rs.next())
		{
			Admin a = new Admin();
			
			a.setLoginID(rs.getString(1));
			a.setPassword(rs.getString(2));
			a.setName(rs.getString(3));
			a.setAge(rs.getInt(5));
			a.setContactNo(rs.getInt(4));
			a.setGender(rs.getString(6));
			
			MetropolitanManagementSytem.getAdmin().add(a); // Applying Static Data Type here
			
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			
		}
	}
	
	public void retreiveTno() throws SQLException
	{
		createConnection();
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from TNm");
		
		while(rs.next())
		{
			MetropolitanManagementSytem.settNo(rs.getInt(1)); // Applying Static Data Type here
			
			System.out.println(rs.getInt(1) + ": Tickets" );
		}
	}
	
	public void updateTno(int t) throws SQLException
	{
		createConnection();
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from TNm");
		
		int t1 = 0;
		while(rs.next())
		{
			t1 = rs.getInt(1);
			MetropolitanManagementSytem.settNo(rs.getInt(1)); // Applying Static Data Type here
			
			System.out.println(rs.getInt(1));
		}
		
		String sql = "UPDATE TNm SET tNo = ? WHERE tNo = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1,t);
		statement.setInt(2,t1);
		
		System.out.println(t1 + " ");
		int rowsUpdated = statement.executeUpdate();
		
		if (rowsUpdated > 0)
		{
			System.out.println("\nTno updated successfully!");
		}
	}
	
	public void retreiveStationHeadInformation() throws SQLException
	{
		createConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from StationHead");
		
		while(rs.next())
		{
			StationHead st = new StationHead();
			
			st.setLoginID(rs.getString(1));
			st.setName(rs.getString(2));
			st.setAge(rs.getInt(3));
			st.setContactNo(rs.getInt(4));
			st.setGender(rs.getString(5));
			st.setPassword(rs.getString(6));
			
			MetropolitanManagementSytem.getStationhead().add(st); // Applying Static Data Type here
			
			System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3) + "  " + rs.getInt(4) + "  " + rs.getString(5)+ "  " + rs.getString(6));
			
		}
	}
	
	public void retreiveSubwayStationInformation() throws SQLException
	{
		createConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from SubwayStation");
		
		int i = 0;
		while(rs.next())
		{
			SubwaySystem s = new SubwaySystem();
			
			s.setSubwayStationID(rs.getString(1));
			s.setSubwayStationName(rs.getString(2));
			s.setSubwayStationLocation(rs.getString(3));
			s.setTicketsSold(rs.getInt(4));
			s.setTotalEarnings(rs.getDouble(5));
			s.setStHeadID((MetropolitanManagementSytem.getStationhead()).get(i));
			i++;
			
			MetropolitanManagementSytem.getSubwaysystem().add(s); // Applying Static Data Type here
			
			System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getInt(4) + "  " + rs.getDouble(5)+ "  " + rs.getString(6));
			
		}
	}
	
	public void updateStationHead(String prevID,String newID,String Pass,String name,int age,long Cno,String gender) throws SQLException
	{
		createConnection();
		String sql = "UPDATE StationHead SET loginID = ?, Name = ?, Age = ?, ContactNo = ?, Gender = ?, Password = ? WHERE loginID = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1,newID);
		statement.setString(2,name);
		statement.setInt(3,age);
		statement.setLong(4,Cno);
		statement.setString(5,gender);
		statement.setString(6,Pass);
		statement.setString(7,prevID);
		
		System.out.println(newID + " " + name + " " + age + " " + Cno + " " + gender + " " + Pass + " " + prevID);
		
		int rowsUpdated = statement.executeUpdate();
		
		if (rowsUpdated > 0)
		{
			System.out.println("\nAn existing row was updated successfully!");
		}
	}
	
	public void updateSubwayStation(String prevID,String newID) throws SQLException
	{
		createConnection();
		String sql = "UPDATE SubwayStation SET stationHeadID = ? WHERE stationHeadID = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1,newID);
		statement.setString(2,prevID);
		
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0)
		{
			System.out.println("\nAn existing row was updated successfully!");
		}
	}
	
	public void retreiveUserInformation() throws SQLException
	{
		createConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select U_ID,Name,Age,Contact,Gender from user");
		
		//int i = 0,j = 0;
		while(rs.next())
		{
			Customer c = new Customer();
			
			c.setUserID(rs.getString(1));
			c.setName(rs.getString(2));
			c.setAge(rs.getString(3));
			c.setContactNo(rs.getLong(4));
			c.setGender(rs.getString(5));
			
			MetropolitanManagementSytem.getCustomers().add(c); // Applying Static Data Type here
			
			System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getLong(4) + "  " + rs.getString(5));
			
		}
		
		for (int k = 0; k<MetropolitanManagementSytem.getCustomers().size(); k++)
		{
			for (int m = 0; m<MetropolitanManagementSytem.getTickets().size(); m++)
			{
				if (MetropolitanManagementSytem.getTickets().get(m).getU_ID().equals(MetropolitanManagementSytem.getCustomers().get(k).getUserID()))
				{
					MetropolitanManagementSytem.getCustomers().get(k).getTickets().add(MetropolitanManagementSytem.getTickets().get(m));
				}
			}
		}
	}
	
	public void retreiveMemberInformation() throws SQLException
	{
		createConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from Member");
		
		int i = 0;
		while(rs.next())
		{
			Member m = new Member();
			
			m.setMemberID(rs.getString(1));
			m.setPassword(rs.getString(2));
			m.setName(rs.getString(3));
			m.setAge(rs.getString(4));
			m.setContactNo(rs.getLong(5));
			m.setGender(rs.getString(6));
			m.setNoOfRides(rs.getInt(8));
			m.setcID((MetropolitanManagementSytem.getCard()).get(i));
			i++;
			
			MetropolitanManagementSytem.getMembers().add(m); // Applying Static Data Type here
			
			System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getLong(4) + "  " + rs.getString(5));
			
		}
		
		for (int k = 0; k<MetropolitanManagementSytem.getMembers().size(); k++)
		{
			for (int m = 0; m<MetropolitanManagementSytem.getTickets().size(); m++)
			{
				if (MetropolitanManagementSytem.getTickets().get(m).getU_ID().equals(MetropolitanManagementSytem.getMembers().get(k).getMemberID()))
				{
					MetropolitanManagementSytem.getMembers().get(k).getTickets().add(MetropolitanManagementSytem.getTickets().get(m));
				}
			}
		}
	}
	
	public void retreiveCardInformation() throws SQLException
	{
		createConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from Card");
		
		while(rs.next())
		{
			Card c = new Card();
			
			c.setM_ID(rs.getString(1));
			c.setCardID(rs.getString(2));
			c.setCardBalance(rs.getDouble(3));
			
			MetropolitanManagementSytem.getCard().add(c); // Applying Static Data Type here
			
			System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			
		}
	}
	
	public void retreiveTicketInformation() throws SQLException
	{
		createConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from Ticket");
		
		while(rs.next())
		{
			Ticket t = new Ticket();
			
			t.setTicketNumber(rs.getString(1));
			t.setOrigin(rs.getString(2));
			t.setDestination(rs.getString(3));
			t.setFare(rs.getDouble(4));
			t.setU_ID(rs.getString(5));
			
			MetropolitanManagementSytem.getTickets().add(t); // Applying Static Data Type here
			
			System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getDouble(4)+ "  " + rs.getString(5));
			
		}
	}
	
	public void insertCard (Card c) throws SQLException
	{
		createConnection();
		String sql = "INSERT into Card (mID,cID,cardBalance) VALUES (?, ?, ?)";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setString(1,c.getM_ID());
		statement.setString(2,c.getCardID());
		statement.setDouble(3,c.getCardBalance());
		
		int rowsInserted = statement.executeUpdate();
		
		if (rowsInserted > 0)
		{
			System.out.println("\nCard Inserted Successfully !!!");
		}
	}
	
	public void insertMember(Member m) throws SQLException
	{
		createConnection();
		String sql = "INSERT into Member (mID,password,Name,Age,ContactNumber,Gender,cID,TotalRides) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setString(1,m.getMemberID());
		statement.setString(2,m.getPassword());
		statement.setString(3,m.getName());
		statement.setString(4,m.getAge());
		statement.setLong(5,m.getContactNo());
		statement.setString(6,m.getGender());
		statement.setString(7,m.getcID().getCardID());
		statement.setLong(8,m.getNoOfRides());
		
		int rowsInserted = statement.executeUpdate();
		
		if (rowsInserted > 0)
		{
			System.out.println("\nMember Inserted Successfully !!!");
		}
	}
	
	public void insertTicket(String tno,String o,String d,double f,String uID) throws SQLException
	{
		createConnection();
		String sql = "INSERT into Ticket (TicketNumber,Origin,Destination,Fare,U_ID) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setString(1,tno);
		statement.setString(2,o);
		statement.setString(3,d);
		statement.setDouble(4,f);
		statement.setString(5,uID);
		
		int rowsInserted = statement.executeUpdate();
		
		if (rowsInserted > 0)
		{
			System.out.println("\nTicket Inserted Successfully !!!");
		}
	}
	
	public void insertUser(String uID,String n,String a,long cno,String g,int t,double f) throws SQLException
	{
		createConnection();
		String sql = "INSERT into User (U_ID,Name,Age,Contact,Gender,TicketBought,Amount) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setString(1,uID);
		statement.setString(2,n);
		statement.setString(3,a);
		statement.setDouble(4,cno);
		statement.setString(5,g);
		statement.setInt(6,t);
		statement.setDouble(7,f);
		
		int rowsInserted = statement.executeUpdate();
		
		if (rowsInserted > 0)
		{
			System.out.println("\nUser Inserted Successfully !!!");
		}
	}
	
	public void removeTickets(String t,String ID) throws SQLException
	{
		createConnection();
		String sql = "DELETE from Ticket WHERE TicketNumber = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setString(1,t);
		
		int rowsInserted = statement.executeUpdate();
		
		if (rowsInserted > 0)
		{
			System.out.println("\nTicket Removed Successfully !!!");
		}
		
		String sql2 = "UPDATE User SET TicketBought = TicketBought-1, Amount = Amount-100 WHERE U_ID = ?";
		PreparedStatement statement2 = con.prepareStatement(sql2);
		
		statement2.setString(1,ID);
		
		int rowsInserted2 = statement2.executeUpdate();
		
		if (rowsInserted2 > 0)
		{
			System.out.println("\nTicket Updated Successfully !!!");
		}
		
		String sql3 = "UPDATE Member SET TotalRides = TotalRides-1 WHERE mID = ?";
		PreparedStatement statement3 = con.prepareStatement(sql3);
		
		statement3.setString(1,ID);
		
		int rowsInserted3 = statement3.executeUpdate();
		
		if (rowsInserted3 > 0)
		{
			System.out.println("\nMember Rides Updated Successfully !!!");
		}
		
		String sql4 = "UPDATE Card SET cardBalance = cardBalance+100 WHERE mID = ?";
		PreparedStatement statement4 = con.prepareStatement(sql4);
		
		statement4.setString(1,ID);
		
		int rowsInserted4 = statement4.executeUpdate();
		
		if (rowsInserted4 > 0)
		{
			System.out.println("\nCard Balance Updated Successfully !!!");
		}
	}
	
	public void updateCardRides(String cID,String mID, int t) throws SQLException
	{
		for (int i=0; i<t; i++)
		{
		String sql2 = "UPDATE Member SET TotalRides = TotalRides+1 WHERE mID = ?";
		PreparedStatement statement2 = con.prepareStatement(sql2);
		
		statement2.setString(1,mID);
		
		int rowsInserted2 = statement2.executeUpdate();
		
		if (rowsInserted2 > 0)
		{
			System.out.println("\nRides Updated Successfully !!!");
		}
		
		String sql3 = "UPDATE Card SET cardBalance = cardBalance-100 WHERE cID = ?";
		PreparedStatement statement3 = con.prepareStatement(sql3);
		
		statement3.setString(1,cID);
		
		int rowsInserted3 = statement3.executeUpdate();
		
		if (rowsInserted3 > 0)
		{
			System.out.println("\nCard Updated Successfully !!!");
		}
		}
	}
	
	public void updateCard(String mID,Double amount) throws SQLException
	{
		String sql3 = "UPDATE Card SET cardBalance = ? WHERE mID = ?";
		PreparedStatement statement3 = con.prepareStatement(sql3);
		
		statement3.setDouble(1,amount);
		statement3.setString(2,mID);
		
		int rowsInserted3 = statement3.executeUpdate();
		
		if (rowsInserted3 > 0)
		{
			System.out.println("\nCard Updated Successfully !!!");
		}
	}
}
