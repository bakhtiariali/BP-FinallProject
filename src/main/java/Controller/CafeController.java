package Controller;

import Models.Database.UserDatabase;
import Models.Storage;
import Models.Store.Cafe;
import Models.UserType;
import View.MenuType;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class CafeController {

    ArrayList<String> productsName;
    private static CafeController cafeController;
    public static CafeController getInstance() {
        if (cafeController == null) {
            cafeController = new CafeController();
        }
        return cafeController;
    }

    public CafeController() {
        productsName = new ArrayList<>();
    }

    public String showMenu() {
        return Cafe.getInstance().getMenu();
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
        String res = Cafe.getInstance().addOrder(productsName);
        MenuController.getInstance().setCurrentMenu(MenuType.CustomerMenu);
        productsName.clear();
        return res;
    }

    public String showIngredient(Matcher matcher) {
        String productName = matcher.group("productName");
        return Cafe.getInstance().getIngredients(productName);
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

