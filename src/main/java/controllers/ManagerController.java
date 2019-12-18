package controllers;

import SQL.UserSQL;
import view.View;
import java.sql.SQLException;
import java.util.List;

public class ManagerController {

    UserSQL sqlController = new UserSQL();

    public ManagerController() throws SQLException{
    }

    public void run() {
        System.out.println("YOU ARE A MANAGER");
        String[] options = {"List mentors", "List students", "Add mentor", "Remove mentor", "Edit mentor", "Exit CcMS"};
        View.displayMenu(options);
        int userChoice = View.getUserChoice(options.length);
        switch (userChoice) {
            case 1:
                showMentorsList();
                break;
            case 2:
                showStudentsList();
                break;
            case 3:
                addMentor();
                break;
            case 4:
                removeMentor();
                break;
            case 5:
                editMentor();
                break;
            case 6:
                LoginController controller = new LoginController();
                controller.logOut();
        }
    }

    private void showMentorsList() {
        List<String> mentorsNameList = getMentorsNames();
        View.showPersonList(mentorsNameList);
    }

    private void showStudentsList() {
        List<String> studentsNameList = sqlController.getNames("Student");
        View.showPersonList(studentsNameList);
    }

    private List<String> getMentorsNames() {
        return sqlController.getNames("Mentor");
    }


    private void editMentor() {

        View.printMessage("Which mentor would you like to edit?");
        showMentorsList();
        int userChoice = View.getUserChoice(getMentorsNames().size());
        String mentorLogin = getMentorsNames().get(userChoice - 1);

        String column = "";

        String[] options = {"Name"};

        View.displayMenu(options);

        int valueToEdit = chooseValueToEdit(options);
        if (valueToEdit == 1) {
            column = "NAME";
        }

        View.printMessage("Provide new name:");
        String newData = View.getUserInput();
        sqlController.edit(mentorLogin,column,newData);

    }

    private int chooseValueToEdit(String[] options) {
        View.printMessage("What would you like to change");
        return View.getUserChoice(options.length);
    }

    private void removeMentor() {
        View.showPersonList(getMentorsNames());
        View.printMessage("Which mentor would you like to remove?");
        int userChoice = View.getUserChoice(getMentorsNames().size());
        sqlController.remove(userChoice);
    }

    private void addMentor() {
        View.printMessage("Please, provide mentor's name:");
        String name = View.getLoginInput();
        View.printMessage("Please, provide mentor's email:");
        String email = View.getLoginInput();
        View.printMessage("Please, provide mentor's password:");
        String password = View.getLoginInput();
        String [] data = {name, "Mentor",email,password};

        sqlController.add(data);
    }

}
