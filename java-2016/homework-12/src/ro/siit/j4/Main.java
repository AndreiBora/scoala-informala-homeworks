package ro.siit.j4;

public class Main {

	public static void main(String[] args) {
		loadDriver();
		AccomodationRoomFair arf = new AccomodationRoomFair();
		arf.createAccomodation(1, "hostel", "single",1,"cheep");
		arf.createRoomFair(1, 100, "winter");
		arf.createAccomodationFairRelation(1, 1, 1);
		
		arf.createRoomFair(2, 150, "summer");
		arf.createAccomodationFairRelation(2, 1, 2);
		
		arf.createAccomodation(2, "hotel", "double",2,"Beautiful landscape");
		arf.createRoomFair(3, 200, "summer");
		arf.createAccomodationFairRelation(3, 2, 3);
		
		
		arf.writePriceForAccomodation();
	}

	private static void loadDriver() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
