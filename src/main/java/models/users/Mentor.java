package models.users;


import controllers.MentorController;
import view.View;

import java.util.HashMap;

public class Mentor extends Worker {

    public Mentor(String login) {
        super(login);
    }

    @Override
    public void runController() {
        MentorController mentorcontroller = new MentorController();
        mentorcontroller.run(this);
    }
    public void viewGrades(){
        View.displayGrades(new HashMap<String, Integer>());
    }
    public void submitAnAssigment(){

    }
}
