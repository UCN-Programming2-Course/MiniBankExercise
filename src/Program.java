import java.sql.ResultSet;
import java.sql.SQLException;

public class Program {

	public static void main(String[] args) {
		// TODO: Test your exercise solutions from here, You can use the
		// displayResultSet method.

		try {

			// test exercise 1
			// ResultSet rs = DatabaseInvoker.ex1_SearchInfoForClient("Lars");
			// displayResultSet(rs);

			// test exercise 2
			// ResultSet rs = DatabaseInvoker.ex2_GetClientListByStatusAndCity("A",
			// "Aalborg");
			// displayResultSet(rs);

			// test exercise 3
			// int result = DatabaseInvoker.ex3_InsertCity("9500", "Hobro");
			// System.out.println(result);

			// test exercise 4
			// ResultSet rs = DatabaseInvoker.ex4_GetClientsByArea("9000", "9700");
			// displayResultSet(rs);

			// test exercise 5
			// int result = DatabaseInvoker.ex5_CreateAccount("1234567890", 8, 8765.8, 4.6);
			// System.out.println(result);

			// test exercise 6
			// boolean found = DatabaseInvoker.ex6_CheckClientByCpr("1234567890");
			// System.out.println(found);

			// test exercise 7
			int result = DatabaseInvoker.ex7_CreateAccount("1234569821", "Kurt", "Z Street", "9500", 10, 1100.00, 2.3);
			System.out.println(result);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void displayResultSet(ResultSet rs) throws SQLException {
		while (rs.next()) {
			int colCount = rs.getMetaData().getColumnCount();
			String output = "";
			for (int i = 1; i <= colCount; i++) {
				output += rs.getString(i) + "\t";
			}
			System.out.println(output);
		}
	}
}
