package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {
	private JDBCUtil() {
	}

	private static Connection connection;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			String username = "root";
			String password = "";
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(e + "数据库连接失败");
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void close(Connection connection, Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
