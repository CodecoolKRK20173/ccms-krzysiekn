package models.users;

public class UserFactory {

    public Worker createUser(String userName, String login) {
        switch (userName) {
            case "Manager":
                return new Manager(login);
            case "Mentor":
                return new Mentor(login);
//            case "Employee":
//                return new Employee(login);
            case "Student":
                return new Student(login);
            default:
                return null;
        }
    }

}
