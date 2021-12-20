package application;

public class ModelMemberTable {

	String member, password, name, age, cno, gender, card, totalrides;

	public ModelMemberTable(String member, String password, String name, String age, String cno, String gender,
			String card, String totalrides) {
		this.member = member;
		this.password = password;
		this.name = name;
		this.age = age;
		this.cno = cno;
		this.gender = gender;
		this.card = card;
		this.totalrides = totalrides;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getTotalrides() {
		return totalrides;
	}

	public void setTotalrides(String totalrides) {
		this.totalrides = totalrides;
	}
}
