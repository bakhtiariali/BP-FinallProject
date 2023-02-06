package Controller;

import Models.Store.Cafe;
import Models.Store.Restaurant;
import View.MenuType;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class RestaurantController {
    ArrayList<String> productsName;
    private static RestaurantController restaurantController;
    public static RestaurantController getInstance() {
        if (restaurantController == null) {
            restaurantController = new RestaurantController();
        }
        return restaurantController;
    }

    public RestaurantController() {
        productsName = new ArrayList<>();
    }

    public String showMenu() {
        return Restaurant.getInstance().getMenu();
    }

    public String back () {
        productsName.clear();
        MenuController.getInstance().setCurrentMenu(MenuType.CustomerMenu);
        return "You back to Customer Menu.";
    }

    public String order(Matcher matcher) {
        String productName = matcher.group("productName");
        if (!showMenu().contains(productName)) {
            return "product not found in Cafe menu!";
        }
        productsName.add(productName);
        return "added successfully!";
    }

    public String submit() {
        String res = Restaurant.getInstance().addOrder(productsName);
        MenuController.getInstance().setCurrentMenu(MenuType.CustomerMenu);
        productsName.clear();
        return res;
    }

    public String showIngredient(Matcher matcher) {
        String productName = matcher.group("productName");
        return Restaurant.getInstance().getIngredients(productName);
    }

    public String help() {
        String s = "You can enter these commands: " + "\n";
        s += "\t" + "show menu" + "\n";
        s += "\t" + "order --product <productName>" + "\n";
        s += "\t" + "show ingredients --product <productName>" + "\n";
        s += "\t" + "submit" + "\n";
        s += "\t" + "back" + "\n";
        return s;
    }
}
