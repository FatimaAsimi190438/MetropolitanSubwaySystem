package application;

public class Customer extends User{

	private String userID;

	public Customer(String name, String age, long contactNo, String gender, long cNIC, String userID) {
		super(name, age, contactNo, gender);
		this.userID = userID;
	}

	public Customer(String name, String age, long contactNo, String gender, long cNIC) {
		super(name, age, contactNo, gender);
		// TODO Auto-generated constructor stub
	}

	public Customer() {
		super();
	}

	public void displayInfo()
	{
		System.out.println("name = " + name + ", contactNo = " + contactNo + ", age = " + age + ", gender = " + gender + ", userID = "
				+ userID);
		for (int i=0; i<tickets.size(); i++)
		{
			tickets.get(i).displayInfo();
		}
	}
	
	@Override
	public boolean makePayment() {
		
		double amount = 0;
		if (amount > 10000)
		return false;
		else
			return true;
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
