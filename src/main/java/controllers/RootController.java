package controllers;

import SQL.SQL;
import models.users.Worker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RootController {

    public void run() {
        SQL sql = new SQL();
        String statement = getStatementsFromtxt("src/main/resources/dbInit.txt");
        sql.createDB(statement);
        LoginController loginController = new LoginController();
        Worker worker = loginController.run();
        while (true) {
            worker.runController();
        }
    }

    public String getStatementsFromtxt(String fileName) {
        File file = new File(fileName);
        String content = "";
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext())
                content += scan.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return content;
    }
}
