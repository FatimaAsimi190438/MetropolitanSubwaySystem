package application;

import java.sql.SQLException;

public class Multithreading{

	public static void retreiveInformation() throws SQLException
	{
		MetropolitanManagementSytem sms = new MetropolitanManagementSytem();
		DataBase DB = new DataBase();
		
		/* ---------- ADMIN DATA ------------ */
		try {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                		DB.retreiveAdminCredentials();
                		DB.retreiveTno();
                		sms.displayAdmin();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
            t.start();
            //t.join();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
		
		/* ---------- STATION HEAD & SUBWAY STATION ------------ */
		try {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                    	DB.retreiveStationHeadInformation();
                    	sms.displayStationHead();
                    	DB.retreiveSubwayStationInformation();
                    	sms.displaySubwaySystem();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
            t.start();
            //t.join();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
		
		/* ---------- TICKET,CUSTOMERS,MEMBERS,CARD ------------ */
		try {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                    	DB.retreiveTicketInformation();
                		MetropolitanManagementSytem.displayTickets();
                		DB.retreiveUserInformation();
                		MetropolitanManagementSytem.displayUsers();
                		DB.retreiveCardInformation();
                		MetropolitanManagementSytem.displayCard();
                    	DB.retreiveMemberInformation();
                		MetropolitanManagementSytem.displayMembers();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
            t.start();
            //t.join();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
	}
}
