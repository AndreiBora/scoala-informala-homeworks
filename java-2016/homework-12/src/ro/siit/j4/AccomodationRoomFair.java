package ro.siit.j4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccomodationRoomFair {

	private Connection conn;


	public void createAccomodation(int id, String type, String bed_type, int max_guests, String description) {
		
		conn = connect("postgresql", "localhost", 5432, "Booking", "postgres", "steaua");
		
		String sqlQuery = "INSERT INTO accomodation(id, type, bed_type,max_guests,description) VALUES (?,?,?,?,?)";
		try (PreparedStatement ps = conn.prepareStatement(sqlQuery)) {
			ps.setInt(1, id);
			ps.setString(2, type);
			ps.setString(3, bed_type);
			ps.setInt(4, max_guests);
			ps.setString(5, description);
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Cannot execute query: " + e.getMessage());
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("Cannot close connection: " + e.getMessage());
		}
		
	}

	public void createRoomFair(int id, double value, String season) {
		
		conn = connect("postgresql", "localhost", 5432, "Booking", "postgres", "steaua");
		
		String sqlQuery = "INSERT INTO room_fair(id, value,season) VALUES (?,?,?)";
		try (PreparedStatement ps = conn.prepareStatement(sqlQuery)) {
			ps.setInt(1, id);
			ps.setDouble(2, value);
			ps.setString(3, season);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Cannot execute query: " + e.getMessage());
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("Cannot close connection: " + e.getMessage());
		}
		
	}

	public void createAccomodationFairRelation(int id, int id_accomodation, int id_room_fair) {
		conn = connect("postgresql", "localhost", 5432, "Booking", "postgres", "steaua");
		
		String sqlQuery = "INSERT INTO accomodation_fair_relation(id, id_accomodation,id_room_fair) VALUES (?,?,?)";
		try (PreparedStatement ps = conn.prepareStatement(sqlQuery)) {
			ps.setInt(1, id);
			ps.setInt(2, id_accomodation);
			ps.setInt(3, id_room_fair);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Cannot execute query: " + e.getMessage());
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("Cannot close connection: " + e.getMessage());
		}
	}

	public Object[] writePriceForAccomodation() {
		
		conn = connect("postgresql", "localhost", 5432, "Booking", "postgres", "steaua");
		Object[] accomodation = new Object[7];
		
		ResultSet rs = null;
		
		final String format = "%10s%10s%15s%15s%20s%20s%20s\n";
		String sqlQuery = "SELECT * FROM accomodation_fair_relation  JOIN accomodation ON accomodation.id = accomodation_fair_relation.id_accomodation JOIN room_fair ON  room_fair.id = accomodation_fair_relation.id_room_fair";
		
		try (PreparedStatement ps = conn.prepareStatement(sqlQuery)) {
			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {
				System.out.format(format, "id", "type", "bed_type","max_guests","description","value","season");
				do {
					for(int i = 0; i < accomodation.length;i++){
						accomodation[0] = rs.getInt("id");
						accomodation[1] = rs.getString("type");
						accomodation[2] = rs.getString("bed_type");
						accomodation[3] = rs.getInt("max_guests");
						accomodation[4] = rs.getString("description");
						accomodation[5] = rs.getDouble("value");
						accomodation[6] = rs.getString("season");
					}
					System.out.format(format, accomodation[0], accomodation[1], accomodation[2],accomodation[3],accomodation[4],accomodation[5],accomodation[6]);
				} while (rs.next());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accomodation;
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
