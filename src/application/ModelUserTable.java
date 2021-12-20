package application;

/* For displaying table on GUI */
public class ModelUserTable {

	String U_ID,name,age,gender,Cno,amount,tickets;

	public ModelUserTable(String string, String string2, String string3, String string4, String string5, String string6,
			String string7) {
		this.U_ID = string;
		this.name = string2;
		this.age = string3;
		this.gender = string5;
		this.Cno = string4;
		this.tickets = string6;
		this.amount = string7;
	}

	public String getU_ID() {
		return U_ID;
	}

	public void setU_ID(String u_ID) {
		U_ID = u_ID;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCno() {
		return Cno;
	}

	public void setCno(String cno) {
		Cno = cno;
	}

	public String getTickets() {
		return tickets;
	}

	public void setTickets(String tickets) {
		this.tickets = tickets;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}
