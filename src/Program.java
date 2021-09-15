import java.sql.ResultSet;
import java.sql.SQLException;

public class Program {

	public static void main(String[] args) {
		// TODO: Test your exercise solutions from here, You can use the displayResultSet method.

			
			
			
			
		
	}

	private static void displayResultSet(ResultSet rs) throws SQLException {
		while(rs.next()) {
			int colCount = rs.getMetaData().getColumnCount();
			String output = "";
			for(int i = 1; i <= colCount; i++){
				output += rs.getString(i) + "\t";
			}
			System.out.println(output);
		}		
	}
}
