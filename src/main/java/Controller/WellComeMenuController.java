package Controller;

import Models.Database.UserDatabase;
import Models.User;
import Models.UserType;
import View.MenuType;

import java.util.regex.Matcher;

public class WellComeMenuController {
    private static WellComeMenuController wellComeMenuController;
    public static WellComeMenuController getInstance() {
        if (wellComeMenuController == null) {
            wellComeMenuController = new WellComeMenuController();
        }
        return wellComeMenuController;
    }

    public String Login(Matcher matcher) {
        String name = matcher.group("name");
        String password = matcher.group("password");
        User user = UserDatabase.getInstance().getUserByName(name);
        if (user == null) {
            return "user not found!";
        }
        if (user.getPassword().equals(password)) {
            UserDatabase.getInstance().setCurrentUser(user);
            if (user.getUserType() == UserType.Customer) {
                MenuController.getInstance().setCurrentMenu(MenuType.CustomerMenu);
            }
            else {
                MenuController.getInstance().setCurrentMenu(MenuType.EmployeeMenu);
            }
            return "You Logged in Successfully!";
        }
        else {
            return "incorrect password!";
        }
    }


    public String Register(Matcher matcher) {
        String name = matcher.group("name");
        String password = matcher.group("password");
        String type = matcher.group("type");
        if (UserDatabase.getInstance().getUserByName(name) != null) {
            return "name already exist!";
        }
        User user;
        if (type.equals("customer")) {
            user = new User(UserType.Customer, name, password);
        }
        else if (type.equals("employee")) {
            user = new User(UserType.Employee, name, password);
        }
        else {
            return "incorrect type!";
        }
        UserDatabase.getInstance().addUser(user);
        UserDatabase.getInstance().saveChanges();
        if (user.getUserType() == UserType.Customer) {
            MenuController.getInstance().setCurrentMenu(MenuType.CustomerMenu);
        }
        else {
            MenuController.getInstance().setCurrentMenu(MenuType.EmployeeMenu);
        }
        return "account created successfully";
    }

    public String help() {
        String s = "You can enter these commands: " + "\n";
        s += "\t" + "user login --name <name> --password <password>" + "\n";
        s += "\t" + "user create --name <name> --password <password> --type <type>";
        return s;
    }

    public String Exit() {
        MenuController.getInstance().setCurrentMenu(MenuType.Exit);
        return "You Exited Successfully!";
    }

    public String invalidCommand() {
        return "invalid command!";
    }
}
