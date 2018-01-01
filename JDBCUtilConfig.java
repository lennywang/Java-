package jdbc.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.swing.plaf.PanelUI;

public class JDBCUtilConfig {
	private static Connection connection;
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;

	static {
		try {
			readConfig();
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException("数据库连接失败");
		}
	}

	private static void readConfig() throws Exception {
		InputStream inputStream = JDBCUtilConfig.class.getClassLoader().getResourceAsStream("database.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		driverClass = properties.getProperty("driverClass");
		url = properties.getProperty("url");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
	}

	public static Connection GetConnection() {
		return connection;
	}
}
