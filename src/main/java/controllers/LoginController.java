package controllers;

import SQL.UserSQL;
import SQL.UserTypesSQL;
import models.users.Worker;
import models.users.UserFactory;
import view.View;

public class LoginController {

    private String login;
    private String password;

    public Worker run() {
        getUserLoginInfo();
        return tryLogin();
    }

    private Worker tryLogin() {
        UserSQL sqlController = new UserSQL();
        UserTypesSQL userTypesSQL = new UserTypesSQL();

        UserFactory userFactory = new UserFactory();
        if (sqlController.isUserDataCorrect(login, password)) {
            return userFactory.createUser(userTypesSQL.getUserType(login), login);
        } else {
            View.printMessage("Data not correct!");
        }
        return run();
    }

    private void getUserLoginInfo() {
        View.printMessage("Login: ");
        login = View.getLoginInput();
        View.printMessage("Password: ");
        password = View.getLoginInput();
    }

    public void logOut() {
        RootController root = new RootController();
        root.run();
    }

}
