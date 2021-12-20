package application;

public class Route {

	private int routeID;
	private String routeStartingPoint;
	private String routeEndingPoint;
	
	public Route(int routeID, String routeStartingPoint, String routeEndingPoint) {
		super();
		this.routeID = routeID;
		this.routeStartingPoint = routeStartingPoint;
		this.routeEndingPoint = routeEndingPoint;
	}

	public int getRouteID() {
		return routeID;
	}

	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}

	public String getRouteStartingPoint() {
		return routeStartingPoint;
	}

	public void setRouteStartingPoint(String routeStartingPoint) {
		this.routeStartingPoint = routeStartingPoint;
	}

	public String getRouteEndingPoint() {
		return routeEndingPoint;
	}

	public void setRouteEndingPoint(String routeEndingPoint) {
		this.routeEndingPoint = routeEndingPoint;
	}
}
