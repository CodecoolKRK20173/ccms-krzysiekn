package view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {

    public static String getLoginInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void displayMenu(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println(String.format("(%d) %s",i+1,options[i]));
        }
    }

    public static int getUserChoice(int optionsLength) {
        Scanner scan = new Scanner(System.in);
        String userChoice = scan.nextLine();
        try {
            validateUserChoice(userChoice, optionsLength);
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
        return Integer.parseInt(userChoice);
    }

    public static void validateUserChoice(String userChoice, int optionsLength) throws Exception {
        int userChoiceInt = Integer.parseInt(userChoice);

        if(userChoiceInt > optionsLength  || userChoiceInt < 1) {
            throw new Exception("Invalid input!\n");
        }
    }

    public static void showPersonList(List<String> people) {
        for (int i = 0; i < people.size(); i++) {
            System.out.println((i + 1) + ". " + people.get(i));
        }
    }

    public static void displayGrades(Map<String, Integer> grades) {
        for (String assigment : grades.keySet()) {
            System.out.println(assigment + ": " + grades.get(assigment));
        }
    }

    public static void displayAssignments(List<String> assignments) {
        for (int i = 0; i < assignments.size(); i++) {
            System.out.println((i + 1) + ". " + assignments.get(i));
        }
    }
    public static String getUserInput(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
