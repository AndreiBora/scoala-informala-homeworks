package ro.siit.j4;

public class FestivalStatisticsThread extends Thread {

	FestivalGate gate;
	private static int nrFullTickets = 0;
	private static int nrFullVipTickets = 0;
	private static int nrFreePassTickets = 0;
	private static int nrOneDayTickets = 0;
	private static int nrOneDayVip = 0;

	public FestivalStatisticsThread(FestivalGate gate) {
		this.gate = gate;
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (gate) {

					while (gate.isEmpty()) {
						gate.wait();
					}
					for (int i = 0; i < gate.getLength(); i++) {
						switch (gate.removeFirst()) {
						case FULL:
							nrFullTickets++;
							break;
						case FULL_VIP:
							nrFullVipTickets++;
							break;
						case FREE_PASS:
							nrFreePassTickets++;
							break;
						case ONE_DAY:
							nrOneDayTickets++;
							break;
						case ONE_DAY_VIP:
							nrOneDayVip++;
							break;
						}
					}
				}
				printStatistics();

				Thread.sleep(5000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	private void printStatistics() {
		int totalNrOfAttendee = nrFullTickets + nrFullVipTickets + nrFreePassTickets + nrOneDayTickets + nrOneDayVip;
		System.out.println(totalNrOfAttendee + " people entered");
		System.out.println(nrFullTickets + "people have full tickets");
		System.out.println(nrFullVipTickets + "have full VIP passes");
		System.out.println(nrFreePassTickets + "have free passes");
		System.out.println(nrOneDayTickets + "have one-day passes");
		System.out.println(nrOneDayVip + "have one-day passes");

	}
}
