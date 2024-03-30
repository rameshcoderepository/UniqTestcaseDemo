package Unittestcase.UnitTestCaseDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDatabaseService {

    private ConnectionProvider connectionProvider;

    public MyDatabaseService(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public String fetchDataFromDatabase() throws SQLException {
        try (Connection connection = connectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT data FROM my_table");
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getString("data");
            }
        }
        return null;
    }
}

