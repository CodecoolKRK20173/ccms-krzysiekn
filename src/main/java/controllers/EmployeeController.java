//package controllers;
//
//import SQL.UserSQL;
//import models.users.Employee;
//import view.View;
//
//public class EmployeeController {
//
//    private UserSQL userSQL = new UserSQL();
//
//    public void run(Employee employee) {
//        System.out.println("YOU ARE EMPLOYEE");
//        String[] options = {"View a list of students.", "Logout."};
//        View.displayMenu(options);
//        int userChoice = View.getUserChoice(options.length);
//        switch (userChoice) {
//            case 1:
//                viewStudents();
//                break;
//            case 2:
////                LoginController controller = new LoginController();
////                controller.logOut();
//                break;
//
//        }
//    }
//
//    private void viewStudents(){
//        View.showPersonList(userSQL.getNames("Student"));
//    }
//}
