package jdbc.util.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.JDBCUtil;

public class JDBCUtilTest {
	public static void main(String[] args) throws SQLException {
		Connection connection = JDBCUtil.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from score");
		ResultSet resultSet = preparedStatement.executeQuery();
		String name = "";
		double math = 0;
		double pahliy = 0;
		while (resultSet.next()) {
			name = resultSet.getString("name");
			math = resultSet.getDouble("math");
			pahliy = resultSet.getDouble("pahliy");
			System.out.println("姓名：" + name + "\t数学：" + math + "\t物理：" + pahliy);
		}
		JDBCUtil.close(connection, preparedStatement, resultSet);
	}
}
