package application;

public class StationHead {

	private String name;
	private long contactNo;
	private int age;
	private String gender;
	private String loginID;
	private String password;
	
	public StationHead(String name, long contactNo, int age, String gender, String loginID, String password) {
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.age = age;
		this.gender = gender;
		this.loginID = loginID;
		this.password = password;
	}

	public boolean checkStationHead(String lID,String pass)
	{
		if (lID.equals(loginID) && pass.equals(password))
		{
			return true;
		}
		else
			return false;
	}
	
	public static boolean authenticatePassenger(String tno)
	{
		boolean flag = false;
		for (int i=0; i<MetropolitanManagementSytem.getTickets().size(); i++)
		{
			if (MetropolitanManagementSytem.getTickets().get(i).searchTicket(tno))
			{
				flag = true;
			}
		}
		return flag;
	}
	
	public void ManageCardBalance(String cID,double amount)
	{
		if (amount > 10000)
		{
			System.out.println("Amount should be less than 10000");
		}
	}
	
	public StationHead() {
		// TODO Auto-generated constructor stub
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
