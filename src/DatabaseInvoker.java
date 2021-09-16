import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseInvoker {

	// TODO: Exercise 1
	public static ResultSet ex1_SearchInfoForClient(String clientName) throws SQLException {

		final String query = "SELECT Client.cpr, Client.name, Client.status, Account.accNo, Account.balance "
				+ "FROM Client "
				+ "JOIN Account ON Account.clientNo = Client.Cpr "
				+ "WHERE Client.name = ?";
		PreparedStatement statement = Database.getConnection().prepareStatement(query);
       
		statement.setString(1, clientName); 
		ResultSet rs = statement.executeQuery();
		return rs;
	}
	
	// TODO: Exercise 2
	public static ResultSet ex2_GetClientListByStatusAndCity(String status, String city) throws SQLException {

		final String query = "SELECT Client.cpr, Client.name, Client.street, Client.postalCode, PostalCity.city, Client.status "
				+ "FROM Client "
				+ "JOIN PostalCity ON PostalCity.postalCode = Client.postalCode "
				+ "WHERE PostalCity.city = ? "
				+ "AND Client.status = ?";
		PreparedStatement statement = Database.getConnection().prepareStatement(query);
		
		// set the parameters (bind variables):
		statement.setString(1, city); 
		statement.setString(2, status); 
		ResultSet rs = statement.executeQuery();

		return rs;
	}	
		
	// TODO: Exercise 3
	public static int ex3_InsertCity(String postalCode, String city) throws SQLException{

		final String query = "INSERT INTO PostalCity values(?, ?);";
		
		PreparedStatement statement = Database.getConnection().prepareStatement(query);
		
		// set the parameters (bind variables) - the order is important!:
		statement.setString(1, postalCode);
		statement.setString(2, city);
		
		return statement.executeUpdate();
	}
	
	// TODO: Exercise 4
	public static ResultSet ex4_GetClientsByArea(String postalCode1, String postalCode2) throws SQLException {

		final String query = "SELECT Client.cpr, Client.name, Client.street, Client.postalCode, PostalCity.city "
				+ "FROM Client "
				+ "JOIN PostalCity ON PostalCity.postalCode = Client.postalCode "
				+ "WHERE PostalCity.postalCode BETWEEN ? AND ?";
		
		PreparedStatement statement = Database.getConnection().prepareStatement(query);
        
		// set the parameters (bind variables):
		statement.setString(1, postalCode1); 
		statement.setString(2, postalCode2); 
		ResultSet rs = statement.executeQuery();

		return rs;
	}
	
	// TODO: Exercise 5
	public static int ex5_CreateAccount(String cpr, int accNo, double balance, double intRate) throws SQLException{

		final String query = "INSERT INTO Account values(?, ?, ?, ?);";
		
		PreparedStatement statement = Database.getConnection().prepareStatement(query);
		
		// set the parameters (bind variables) - the order is important!:
        statement.setString(4, cpr);
        statement.setInt(1, accNo);
        statement.setDouble(2, balance);
        statement.setDouble(3,intRate);
		
        int result = statement.executeUpdate();
        
        return result;
	}
	
	// TODO: Exercise 6
	public static boolean ex6_CheckClientByCpr(String cpr) throws SQLException {
		
		final String query = "SELECT * FROM Client WHERE cpr = ?";
		
		PreparedStatement statement = Database.getConnection().prepareStatement(query);
		        
		// set the parameters (bind variables):
		statement.setString(1, cpr); 
		ResultSet rs = statement.executeQuery();

		boolean found = rs.next();
		return found;
	}

	
	// TODO: Exercise 7
	public static int ex7_CreateAccount(String cpr, String name, String street, String postalCode, int accNo, double balance, double intRate) throws SQLException{
		
		if(!ex6_CheckClientByCpr(cpr)) {
        	// create client
			String query = "INSERT INTO Client VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = Database.getConnection().prepareStatement(query);
			statement.setString(1, cpr);
			statement.setString(2, name);
			statement.setString(3, street);
			statement.setString(4, postalCode);
			statement.setString(5, "A");
			statement.executeUpdate();
        }

		int result = ex5_CreateAccount(cpr, accNo, balance, intRate);
		return result;
	}
	
}
