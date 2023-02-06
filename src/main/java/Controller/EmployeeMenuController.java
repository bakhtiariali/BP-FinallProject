package Controller;

import Models.Database.OrderDatabase;
import Models.Database.UserDatabase;
import Models.Order;
import Models.Products.Ingredients;
import Models.Storage;
import View.MenuType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;

public class EmployeeMenuController {
    private static EmployeeMenuController employeeMenuController;
    public static EmployeeMenuController getInstance() {
        if (employeeMenuController == null) {
            employeeMenuController = new EmployeeMenuController();
        }
        return employeeMenuController;
    }

    public String logout() {
        UserDatabase.getInstance().setCurrentUser(null);
        MenuController.getInstance().setCurrentMenu(MenuType.WellComeMenu);
        return "You logged out Successfully!";
    }

    public String showAllOrders() {
        ArrayList<Order> orders = OrderDatabase.getInstance().getOrders();
        Collections.sort(orders, (a, b) -> a.getDateAndTime().compareTo(b.getDateAndTime()));
        String s = "";
        for (Order order : orders) {
            s += order + "\n";
        }
        return s;
    }

    public String cancel_a_Order(Matcher matcher) {
        int id = Integer.parseInt(matcher.group("id"));
        if (!OrderDatabase.getInstance().haveOrder(id)) {
            return "order not found!";
        }
        OrderDatabase.getInstance().removeOrder(id);
        return "order " + id + " removed successfully!";
    }

    public String help() {
        String s = "You can enter these commands: " + "\n";
        s += "\t" + "show all orders" + "\n";
        s += "\t" + "show storage inventory status" + "\n";
        s += "\t" + "storage increase to all --amount <amount>" + "\n";
        s += "\t" + "storage decrease from all --amount <amount>" + "\n";
        s += "\t" + "cancel order --id <id>" + "\n";
        s += "\t" + "storage add to --name <Ingredients name> --amount <amount> --name <Ingredients name> --amount <amount> ..." + "\n";
        s += "\t" + "logout" + "\n";
        return s;
    }

    public String showStorageReport() {
        return Storage.getInstance().getAmountReport();
    }

    public String increaseMaterialToAll(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        Storage.getInstance().addToAll(amount);
        return "All materials have been charged successfully!";
    }
    public String decreaseMaterialFromAll(Matcher matcher) {
        int amount = Integer.parseInt(matcher.group("amount"));
        return Storage.getInstance().subtractFromAll(amount);
    }

    public String increaseSomeIngredients(Matcher matcher) {
        String[] subCommands = matcher.group("command").split(" --name");
        HashMap<Ingredients, Integer> values = new HashMap<>();
        for (int i = 1; i < subCommands.length; i++) {
            String [] sb = subCommands[i].split("--amount ");
            String ingredient = null, amount = null;
            for (int j = 0; j < sb.length; ++j) {
                if (j == 0) {
                    ingredient = sb[j].trim();
                } else if (j == 1) {
                    amount = sb[j].trim();
                }
            }
            Ingredients ingredients = Ingredients.get(ingredient);
            if (ingredients == null) {
                return "ingredient not found!";
            }
            try {
                values.put(ingredients, Integer.parseInt(amount));
            }catch (Exception e) {
                return "some error was occur!";
            }
        }
        Storage.getInstance().addToSmt(values);
        return "increase amount " + values.size() + " item successfully!";
    }
}
