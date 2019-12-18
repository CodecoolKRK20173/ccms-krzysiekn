package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {

    protected Connection connection;
    protected Statement statement;

    public void createDB(String statement) {
        try {
            connectToSQL();
            this.statement.executeUpdate(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    protected void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void connectToSQL() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/codecoolMS.db");
            connection.setAutoCommit(true);

            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}