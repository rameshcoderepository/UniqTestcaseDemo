package Unittestcase.UnitTestCaseDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionProvider {
    Connection getConnection() throws SQLException;
}


//class Imple implements ConnectionProvider{
//
//	@Override
//	public Connection getConnection() throws SQLException {
//		String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_name";
//		String username = "your_username";
//		String password = "your_password";
//
//		Connection connection = null;
//
//		try {
//
//			connection = DriverManager.getConnection(jdbcUrl, username, password);
//
//			System.out.println("Connected to the database!");
//
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		} finally {
//		try {
//
//			if (connection != null && !connection.isClosed()) {
//					connection.close();
//					System.out.println("Connection closed.");
//				}
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//			}
//		}
//		return connection;
//	}
//	
//}
