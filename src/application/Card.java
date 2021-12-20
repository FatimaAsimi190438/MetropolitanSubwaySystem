package application;

public class Card {

	private String cardID;
	private double cardBalance;
	private String m_ID;
	
	public String getM_ID() {
		return m_ID;
	}

	public void setM_ID(String m_ID) {
		this.m_ID = m_ID;
	}

	public Card(String cardID, double cardBalance) {
		super();
		this.cardID = cardID;
		this.cardBalance = cardBalance;
	}

	public void displayInfo()
	{
		System.out.println("cID = " + cardID + ", balance = " + cardBalance + ", mID = " + m_ID);
	}
	
	public double checkCardBalance(String cID)
	{
		return cardBalance;
	}
	
	public Card() {
		// TODO Auto-generated constructor stub
	}

	public double removeBalance(double amount,int tno)
	{
		return cardBalance -= amount*tno;
	}
	
	public double addBalance(double amount)
	{
		return cardBalance += amount;
	}
	
	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public double getCardBalance() {
		return cardBalance;
	}

	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}
}
