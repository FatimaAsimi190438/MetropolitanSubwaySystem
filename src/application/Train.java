package application;

public class Train {

	private int trainNo;
	private String trainRoute;
	private String trainName;
	private String departureTime;
	
	public Train(int trainNo, String trainRoute, String trainName, String departureTime) {
		super();
		this.trainNo = trainNo;
		this.trainRoute = trainRoute;
		this.trainName = trainName;
		this.departureTime = departureTime;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainRoute() {
		return trainRoute;
	}

	public void setTrainRoute(String trainRoute) {
		this.trainRoute = trainRoute;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
}
