package ro.siit.j4;


public class Main {

	public static void main(String[] args) {

		FestivalGate gate = new FestivalGate();
		FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
		statsThread.start();
		for (int i = 0; i < 100; i++) {
			FestivalAttendeeThread attendee = new FestivalAttendeeThread(TicketType.getRandomTicket(), gate);
			attendee.start();
		}

	}

}
