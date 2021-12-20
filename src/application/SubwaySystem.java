package application;

public class SubwaySystem {

	private String subwayStationID;
	private String subwayStationName;
	private String subwayStationLocation;
	private int ticketsSold;
	private double totalEarnings;
	private StationHead StHeadID; // Composition
	
	public SubwaySystem(String subwayStationID, String subwayStationName, String subwayStationLocation,
			int ticketsSold) {
		super();
		this.subwayStationID = subwayStationID;
		this.subwayStationName = subwayStationName;
		this.subwayStationLocation = subwayStationLocation;
		this.ticketsSold = ticketsSold;
	}
	
	public SubwaySystem() {
		// TODO Auto-generated constructor stub
	}

	public void displayInfo()
	{
		System.out.println("STID = " + subwayStationID + ", STName = " + subwayStationName + ", STLocation = " + subwayStationLocation + ", tickets Sold = " + ticketsSold + ", total Earnings = "
				+ totalEarnings + ", STHID = " + StHeadID.getLoginID());
	}
	
	public double calculateEarnings(int ticketsSold)
	{ 
		double amount = 0;
		amount = ticketsSold * 100;
		return amount;
	}
	
	public String getSubwayStationID() {
		return subwayStationID;
	}
	
	public void setSubwayStationID(String subwayStationID) {
		this.subwayStationID = subwayStationID;
	}
	
	public String getSubwayStationName() {
		return subwayStationName;
	}
	
	public void setSubwayStationName(String subwayStationName) {
		this.subwayStationName = subwayStationName;
	}
	
	public String getSubwayStationLocation() {
		return subwayStationLocation;
	}
	
	public void setSubwayStationLocation(String subwayStationLocation) {
		this.subwayStationLocation = subwayStationLocation;
	}
	
	public int getTicketsSold() {
		return ticketsSold;
	}
	
	public void setTicketsSold(int ticketsSold) {
		this.ticketsSold = ticketsSold;
	}
	
	public double getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}
	
	public StationHead getStHeadID() {
		return StHeadID;
	}

	public void setStHeadID(StationHead stHeadID) {
		StHeadID = stHeadID;
	}
}
