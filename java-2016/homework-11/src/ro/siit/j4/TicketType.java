package ro.siit.j4;

import java.util.Random;

public enum TicketType {
	
	FULL, FULL_VIP, FREE_PASS,ONE_DAY,ONE_DAY_VIP;
	
	private static TicketType[] tickets = TicketType.values();
	private static Random rand = new Random();
	
	public static TicketType getRandomTicket(){
		
		return tickets[rand.nextInt(tickets.length)];
	}
}
