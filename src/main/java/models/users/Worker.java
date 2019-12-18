package models.users;

public abstract class Worker {

    private String name;
    public Worker(String login){
        name = login;
    }

    public abstract void runController();

    public String getName(){
        return name;
    }
}
