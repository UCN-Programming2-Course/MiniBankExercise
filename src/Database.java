import java.sql.Connection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class Database {
	public static Connection getConnection() throws SQLServerException {

		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setUser("minibankuser");
		ds.setPassword("password");
		ds.setServerName("localhost\\sqlexpress");
		ds.setDatabaseName("Minibank01");
		return ds.getConnection();
	}
}
