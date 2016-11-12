package ro.siit.j4;

import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataTest {
	
	private Connection conn;

	@Test
	public void testIfdataIsCorrectlyInserted(){
		
		Object[] expected = {1,"hostel", "single",1,"cheep",100.0, "winter"};
				
		AccomodationRoomFair arf = new AccomodationRoomFair();
		arf.createAccomodation(1, "hostel", "single",1,"cheep");
		arf.createRoomFair(1, 100, "winter");
		arf.createAccomodationFairRelation(1, 1, 1);
	
		
		Object[] result = arf.writePriceForAccomodation();
		assertArrayEquals(expected,result);
		
		clearDB();
		
		
	}
	private void clearDB() {
		
		conn = connect("postgresql", "localhost", 5432, "Booking", "postgres", "steaua");
		
		String sqlQuery1 = "delete from accomodation_fair_relation *";
		String sqlQuery2 = "delete from accomodation *";
		String sqlQuery3 = "delete from room_fair *";
		
		try (PreparedStatement ps = conn.prepareStatement(sqlQuery1)) {
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try (PreparedStatement ps = conn.prepareStatement(sqlQuery2)) {
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try (PreparedStatement ps = conn.prepareStatement(sqlQuery3)) {
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("Cannot close connection: " + e.getMessage());
		}
	}
	
	private static Connection connect(String type, String host, int port, String dbName, String user, String pw) {
		Connection conn = null;
		DriverManager.setLoginTimeout(60);

		String url = new StringBuilder().append("jdbc:").append(type).append("://").append(host).append(":")
				.append(port).append("/").append(dbName).append("?user=").append(user).append("&password=").append(pw)
				.toString();
		System.out.println("URL: " + url);
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("Cannot connect to the database: " + e.getMessage());
		}
		return conn;
	}
}
