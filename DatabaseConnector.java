import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector {
    // Database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    // Method to establish a connection to the database
    public Connection connect() {
        Connection connection = null;
        try {
            // Load MySQL JDBC driver (optional for newer versions of Java)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
        return connection;
    }

    // Method to insert data into the database
    public void insertData(String tableName, String column1, String value1, String column2, String value2) {
        String query = "INSERT INTO " + tableName + " (" + column1 + ", " + column2 + ") VALUES (?, ?)";

        try (Connection connection = connect(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, value1);
            preparedStatement.setString(2, value2);
            preparedStatement.executeUpdate();
            System.out.println("Data inserted successfully!");
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }
    }
        // Method to fetch data from the database
    public void fetchData(String tableName) {
        String query = "SELECT * FROM " + tableName;

        try (Connection connection = connect(); PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("Row: " + resultSet.getString(1) + ", " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        DatabaseConnector dbConnector = new DatabaseConnector();

        // Example usage
        dbConnector.insertData("your_table_name", "column1", "value1", "column2", "value2");
        dbConnector.fetchData("your_table_name");
    }
}
