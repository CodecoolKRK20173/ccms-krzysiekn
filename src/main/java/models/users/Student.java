package models.users;

import SQL.StudentAssignmentSQL;
import controllers.StudentController;
import view.View;
import java.util.List;

public class Student extends Worker {

    public Student(String login) {
        super(login);
    }

    @Override
    public void runController() {
        StudentController controller = new StudentController();
        controller.run(this);
    }
    public void viewGrades(){
        StudentAssignmentSQL sql = new StudentAssignmentSQL();
        List<String> grades = sql.getStudentAssigments(getName());
        View.displayAssignments(grades);
    }
}
