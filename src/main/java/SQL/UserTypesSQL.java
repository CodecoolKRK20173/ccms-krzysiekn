package SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTypesSQL extends SQL {

    public int findTypeIDbyTypeName(String type) throws SQLException {
        connectToSQL();
        int ID = statement.executeQuery("SELECT TYPE,TYPE_ID FROM USER_TYPES WHERE TYPE ='" + type + "';").getInt("TYPE_ID");
        closeConnection();
        return ID;
    }

    public String getUserType(String email) {
        connectToSQL();
        try {
            String query = "SELECT USER.USER_ID,USER_TYPES.TYPE FROM USER " +
                    "INNER JOIN USER_TYPES ON USER_TYPES.TYPE_ID = USER.TYPE_ID WHERE USER.EMAIL = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (!rs.isClosed()) {
                String type = rs.getString("TYPE");
                closeConnection();
                return type;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }
}