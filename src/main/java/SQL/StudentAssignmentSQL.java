package SQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentAssignmentSQL extends SQL {

    public List<String> getStudentAssigments(String email) {
//        Map<String, Integer> grades = new LinkedHashMap<>();
        List<String> assignments = new ArrayList<>();
        connectToSQL();
        try {
            ResultSet rs = statement.executeQuery(String.format("SELECT * FROM STUDENT_ASSIGMENT" +
                    "INNER JOIN ASSIGMENT ON STUDENT_ASSIGMENT.ASSIGMENT_ID = ASSIGMENT.ASSIGMENT_ID" +
                    "INNER JOIN USER ON USER.USER_ID = STUDENT_ASSIGMENT.STUDENT_ID" +
                    "WHERE USER.EMAIL = '%s'", email));
            while (rs.next()) {
                assignments.add(rs.getString("ASSIGMENT_NAME"));
            }
            closeConnection();
            return assignments;
        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection();
        }
        return null;
    }

}
