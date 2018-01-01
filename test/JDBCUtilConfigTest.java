package jdbc.util.test;

import jdbc.util.JDBCUtilConfig;

import java.sql.Connection;

public class JDBCUtilConfigTest {
public static void main(String[] args) {
	Connection connection=JDBCUtilConfig.GetConnection();
	System.out.println(connection);
}
}
