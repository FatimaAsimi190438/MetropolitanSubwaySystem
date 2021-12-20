package application;

public class Ticket {

	private String ticketNumber;
	private String destination;
	private String origin;
	private double fare;
	private String U_ID;
	
	public Ticket(String ticketNumber, String destination, String origin, double fare) {
		super();
		this.ticketNumber = ticketNumber;
		this.destination = destination;
		this.origin = origin;
		this.fare = fare;
	}

	public boolean searchTicket(String tno)
	{
		if (ticketNumber.equals(tno))
			return true;
		else
			return false;
	}
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public void displayInfo()
	{
		System.out.println("ticketNo = " + ticketNumber + ", destination = " + destination + ", origin = " + origin + ", fare = Rs." + fare + ", userID = " + U_ID);
	}
	
	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getU_ID() {
		return U_ID;
	}

	public void setU_ID(String u_ID) {
		U_ID = u_ID;
	}
}
