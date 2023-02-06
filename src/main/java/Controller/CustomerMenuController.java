package Controller;

import Models.Database.OrderDatabase;
import Models.Database.UserDatabase;
import Models.Order;
import View.MenuType;

public class CustomerMenuController {
    private static CustomerMenuController customerMenuController;
    public static CustomerMenuController getInstance() {
        if (customerMenuController == null) {
            customerMenuController = new CustomerMenuController();
        }
        return customerMenuController;
    }
    public String logout() {
        UserDatabase.getInstance().setCurrentUser(null);
        MenuController.getInstance().setCurrentMenu(MenuType.WellComeMenu);
        return "You logged out Successfully!";
    }

    public String getHistory() {
        String s = "";
        for (Order order : OrderDatabase.getInstance().getOrdersOfUser
                (UserDatabase.getInstance().getCurrentUser()))
        {
            s += order;
        }
        return s;
    }

    public String gotoCafe() {
        MenuController.getInstance().setCurrentMenu(MenuType.CafeMenu);
        return "You entered the cafe menu.";
    }

    public String gotoRestaurant() {
        MenuController.getInstance().setCurrentMenu(MenuType.RestaurantMenu);
        return "You entered the restaurant menu.";
    }

    public String help() {
        String s = "You can enter these commands: " + "\n";
        s += "\t" + "show history" + "\n";
        s += "\t" + "go to cafe" + "\n";
        s += "\t" + "go to restaurant" + "\n";
        s += "\t" + "logout" + "\n";
        return s;
    }
}
