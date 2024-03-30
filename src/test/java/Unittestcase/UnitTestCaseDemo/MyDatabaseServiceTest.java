package Unittestcase.UnitTestCaseDemo;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MyDatabaseServiceTest {

    @Test
    public void testFetchDataFromDatabase() throws SQLException {
        // Mock the ConnectionProvider interface
        ConnectionProvider connectionProvider = mock(ConnectionProvider.class);

        // Mock the objects needed for the test
        Connection connection = mock(Connection.class);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        ResultSet resultSet = mock(ResultSet.class);

        // Stubbing the behavior of the mocked objects
        when(connectionProvider.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        // Set up the data returned by the ResultSet
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getString("data")).thenReturn("MockedData");

        // Create an instance of the class being tested, injecting the mocked ConnectionProvider
        MyDatabaseService databaseService = new MyDatabaseService(connectionProvider);

        // Perform the actual test
        String result = databaseService.fetchDataFromDatabase();

        // Verify that the methods were called as expected
        verify(connectionProvider).getConnection();
        verify(connection).prepareStatement("SELECT data FROM my_table");
        verify(preparedStatement).executeQuery();

        // Assert the result of the test
        assertEquals("MockedData", result);
    }
}

