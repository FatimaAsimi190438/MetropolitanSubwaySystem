package application;

import java.sql.SQLException;
import java.util.ArrayList;

/* Controller class of Business Logic */
public class MetropolitanManagementSytem {

	private static final ArrayList<Customer> customers = new ArrayList<Customer>();
	private static final ArrayList<Member> members = new ArrayList<Member>();
	private static final ArrayList<Admin> admin = new ArrayList<Admin>();
	private static final ArrayList<StationHead> stationhead = new ArrayList<StationHead>();
	private static final ArrayList<SubwaySystem> subwaysystem = new ArrayList<SubwaySystem>();
	private static final ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	private static final ArrayList<Card> card = new ArrayList<Card>();
	
	private static int tNo; 
	/* Static : It can be used without the instantiation of the class
	 * Final : can only be assigned once */ 
	
	public static ArrayList<Card> getCard() {
		return card;
	}

	public static int gettNo() {
		return tNo;
	}

	public static void settNo(int tNo) {
		MetropolitanManagementSytem.tNo += tNo;
	}
	
	public int AuthenticateAdmin(String ID, String Pass)
	{
		int i;
		for (i=0; i<admin.size(); i++)
		{
			if (admin.get(i).checkAdmin(ID, Pass))
			{
				return i+1;
			}
		}
		return i+1;
	}
	
	public String authenticateStationHead(String ID,String Pass)
	{
		int i;
		for (i=0; i<stationhead.size(); i++)
		{
			if (stationhead.get(i).checkStationHead(ID, Pass))
			{
				return stationhead.get(i).getName();
			}
		}
		return "Failed";
	}
	
	public static void createMember(String n,String a,String g,String cno) throws SQLException
	{
		Member m = new Member();
		m.setName(n);
		m.setGender(g);
		m.setAge(a);
		m.setContactNo(Long.parseLong(cno));
		String mID = "m"+Integer.toString(members.size()+1)+n;
		String mp = n+"123";
		
		m.setMemberID(mID); // m-number
		m.setPassword(mp);
		
		m.registerAsMember();
		members.add(m);
		DataBase DB = new DataBase();
		DB.createConnection();
		
		DB.insertMember(m);
	}
	
	public String authenticateMember(String ID,String Pass)
	{
		int i;
		for (i=0; i<members.size(); i++)
		{
			if (members.get(i).checkMember(ID, Pass))
			{
				return members.get(i).getName();
			}
		}
		return "Failed";
	}
	public static boolean ticketPurchased(String m,String n, String a, String g, String cno, int t, String o, String d) throws SQLException
	{
		boolean flag = true;
		DataBase DB = new DataBase();
		DB.createConnection();
		System.out.println(n +a + g + cno + t + o + d);
		if (a != "")
		{
			
			System.out.println("Customer Bought");
			Customer c = new Customer();
			c.setName(n);
			c.setAge(a);
			c.setGender(g);
			c.setContactNo(Long.parseLong(cno));
		
			String uID = "US"+Integer.toString(customers.size()+1);
			c.setUserID(uID); // US-number
			
			customers.add(c);
			customers.get(customers.size()-1).buyTicket(uID,t,d,o); // To set the Tickets
			
			DB.insertUser(uID,n,a,Long.parseLong(cno),g,t,Double.valueOf(t*100));
		}
		else
		{
			System.out.println("Member Bought");
			
			for (int i=0; i<members.size(); i++)
			{
				if (members.get(i).getMemberID().equals(m))
				{
					if (members.get(i).getcID().getCardBalance() < t*100)
					{
						flag = false;
						System.out.println("Not Enough Balance.");
					}
					else if (members.get(i).getcID().getCardBalance() >= t*100)
					{
						System.out.println("Enough Balance");
						members.get(i).incrementRides(1);
						members.get(i).getcID().removeBalance(100,t);
						members.get(i).buyTicket(m, t, d, o);
						DB.updateCardRides(members.get(i).getcID().getCardID(),m,t);
					}
				}
			}
		}
		DB.updateTno(tNo);
		displayTickets();
		displayUsers();
		displayMembers();
		displayCard();
		return flag;
	}
	
	public static void addingBalance(String mID, Double amount) throws SQLException
	{
		for (int i=0; i<MetropolitanManagementSytem.getCard().size(); i++)
		{
			if (MetropolitanManagementSytem.getCard().get(i).getM_ID().equals(mID))
			{
				MetropolitanManagementSytem.getCard().get(i).addBalance(amount);
			}
		}
		
		DataBase DB = new DataBase();
		DB.createConnection();
		DB.updateCard(mID,amount);
	}
	
	public static boolean ticketCancelling(String tno) throws SQLException
	{
		boolean flag = false;
		for (int i=0; i<tickets.size(); i++)
		{
			if (tickets.get(i).searchTicket(tno))
			{
				flag = true;
				tickets.remove(i);
			}
		}
		for (int i=0; i<customers.size(); i++)
		{
			customers.get(i).cancelTicket(tno);
		}
		for (int i=0; i<members.size(); i++)
		{
			members.get(i).cancelTicket(tno);
			members.get(i).getcID().addBalance(100);
			members.get(i).decrementRides(i);
		}
		displayTickets();
		displayUsers();
		displayMembers();
		return flag;
	}
	
	public static double generateBill(int tNo)
	{
		return tNo*100;
	}
	
	public void displayAdmin()
	{
		System.out.println("\nDisplaying Admin Details");
		for (int i=0; i<admin.size(); i++)
		{
			admin.get(i).displayInfo();
		}
	}
	
	public void displayStationHead()
	{
		System.out.println("\nDisplaying Station Head Details");
		for (int i=0; i<stationhead.size(); i++)
		{
			stationhead.get(i).displayInfo();
		}
	}
	
	public static void displayMembers()
	{
		System.out.println("\nDisplaying Members Details");
		for (int i=0; i<members.size(); i++)
		{
			members.get(i).displayInfo();
		}
	}
	
	public static void displayCard()
	{
		System.out.println("\nDisplaying Card Details");
		for (int i=0; i<card.size(); i++)
		{
			card.get(i).displayInfo();
		}
	}
	
	public void displaySubwaySystem()
	{
		System.out.println("\nDisplaying Subway Station Details");
		for (int i=0; i<subwaysystem.size(); i++)
		{
			subwaysystem.get(i).displayInfo();
		}
	}
	
	public static void displayUsers()
	{
		System.out.println("\nDisplaying User Details");
		for (int i=0; i<customers.size(); i++)
		{
			customers.get(i).displayInfo();
		}
	}
	
	public static void displayTickets()
	{
		System.out.println("\nDisplaying Tickets Details");
		for (int i=0; i<tickets.size(); i++)
		{
			tickets.get(i).displayInfo();
		}
	}
	
	public static ArrayList<Ticket> getTickets() {
		return tickets;
	}
	public static ArrayList<Customer> getCustomers() {
		return customers;
	}
	public static ArrayList<StationHead> getStationhead() {
		return stationhead;
	}
	public static ArrayList<SubwaySystem> getSubwaysystem() {
		return subwaysystem;
	}
	public static ArrayList<Member> getMembers() {
		return members;
	}	
	public static ArrayList<Admin> getAdmin() {
		return admin;
	}
}
