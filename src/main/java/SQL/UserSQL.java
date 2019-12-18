package SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserSQL extends SQL {

    public void add(String[] data) {

        String name = data[0];
        String type = data[1];
        String email = data[2];
        String password = data[3];

        try {
            UserTypesSQL userTypes = new UserTypesSQL();
            int typeId = userTypes.findTypeIDbyTypeName(type);
            connectToSQL();
            String sql = "INSERT INTO USER(NAME, TYPE_ID, EMAIL, PASSWORD) " +
                    "VALUES(?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, typeId);
            ps.setString(3, email);
            ps.setString(4, password);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void edit(String id, String columnName, String data) {
        connectToSQL();
        try {
            statement.executeUpdate(String.format("UPDATE USER SET %s = '%s' WHERE USER_ID = '%d'", columnName, data, id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public List<String> getNames(String type) {
        List<String> userNames = new ArrayList<>();
        try {
            UserTypesSQL userTypes = new UserTypesSQL();
            int typeId = userTypes.findTypeIDbyTypeName(type);

            connectToSQL();
            ResultSet rs = statement.executeQuery(String.format("SELECT * FROM USER WHERE TYPE_ID = %d;", typeId));
            while (rs.next()) {
                String name = rs.getString("NAME");
                userNames.add(name);
            }
            rs.close();
            closeConnection();
            return userNames;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public void remove(int id) {
//        "DELETE FROM USER WHERE USER_ID = %s;", id));
//            closeConnection();
//        int idToRemove = Integer.parseInt(id);

        try {
            connectToSQL();
            String sql = "DELETE FROM USER WHERE USER_ID = ?;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

//        connectToSQL();
//        try {
//            statement.executeUpdate(String.format("DELETE FROM USER WHERE USER_ID = %s;", id));
//            closeConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            closeConnection();
//        }
//    }

    public boolean isUserDataCorrect(String email, String password) {
        connectToSQL();
        try {
            ResultSet rs = statement.executeQuery(String.format("SELECT EMAIL, PASSWORD FROM USER" +
                    " WHERE EMAIL = '%s' AND PASSWORD = '%s';", email, password));
            if (!rs.isClosed()) {
                final boolean isCorrect = rs.getString("EMAIL").equals(email) && rs.getString("PASSWORD").equals(password);
                closeConnection();
                return isCorrect;
            }
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }
}