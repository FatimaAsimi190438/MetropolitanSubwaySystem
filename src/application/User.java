package application;

import java.sql.SQLException;
import java.util.ArrayList;

abstract public class User {

	protected String name;
	protected String age;
	protected long contactNo;
	protected String gender;
	protected ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	
	public User(String name, String age, long contactNo, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.contactNo = contactNo;
		this.gender = gender;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public void buyTicket(String uID,int tno, String d, String o) throws SQLException
	{
		// update database
		DataBase DB = new DataBase();
		DB.createConnection();
	
		for (int i=0; i<tno; i++)
		{
			Ticket t = new Ticket();
			t.setDestination(d);
			t.setOrigin(o);
			t.setTicketNumber("TN-"+Integer.toString(MetropolitanManagementSytem.gettNo()+1));
			MetropolitanManagementSytem.settNo(1);
			t.setU_ID(uID);
			t.setFare(100);
			tickets.add(t);
			MetropolitanManagementSytem.getTickets().add(t);
			DB.insertTicket("TN-"+Integer.toString(MetropolitanManagementSytem.gettNo()+1),o,d,100,uID);
		}
	}
	
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}

	public void cancelTicket(String tno) throws SQLException
	{
		DataBase DB = new DataBase();
		
		String t = null;
		String ID = null;
		for (int i=0; i<tickets.size(); i++)
		{
			if (tickets.get(i).searchTicket(tno))
			{
				t = tno;
				ID = tickets.get(i).getU_ID();
				tickets.remove(i);
			}
		}
		char[] ch = {'x'};
		if (ID != null)
		{
			ch = ID.toCharArray();
		}
		if (ch[0] == 'm')
		{
			System.out.println("Member Ticket");
			DB.removeTickets(t,ID);
		}
		else if (ID != null)
		DB.removeTickets(t,ID);
	}
	
	public void checkTicket()
	{
		
	}
	
	public void checkSubwaySchedule()
	{
		
	}
	
	public abstract boolean makePayment();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
