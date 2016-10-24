package ro.siit.j4;

import java.util.Random;

public class FestivalAttendeeThread extends Thread {

	TicketType ticketType;
	FestivalGate gate;
	Random rand = new Random();

	public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
		this.ticketType = ticketType;
		this.gate = gate;
	}

	@Override
	public void run() {
		try {
			synchronized (gate) {
				gate.add(ticketType);
				gate.notify();
			}
			Thread.sleep(rand.nextInt(500) + 500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
