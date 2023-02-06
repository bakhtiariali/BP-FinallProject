package View;

import Controller.MenuController;
import Controller.RestaurantController;
import Controller.WellComeMenuController;
import Models.Tools;
import View.Regex.RestaurantRegex;

public class RestaurantMenu implements Menu {
    @Override
    public void run() {
        while (MenuController.getInstance().getCurrentMenu() == MenuType.RestaurantMenu) {
            System.out.println("--Restaurant menu--");
            String line = Tools.getInstance().readLine();
            if (Tools.getInstance().checkMatching(RestaurantRegex.showMenu, line)) {
                System.out.println(RestaurantController.getInstance().showMenu());
            }
            else if (Tools.getInstance().checkMatching(RestaurantRegex.back, line)) {
                System.out.println(RestaurantController.getInstance().back());
            }
            else if (Tools.getInstance().checkMatching(RestaurantRegex.order, line)) {
                System.out.println(RestaurantController.getInstance().order(Tools.getInstance().getMatcher()));
            }
            else if (Tools.getInstance().checkMatching(RestaurantRegex.submit, line)) {
                System.out.println(RestaurantController.getInstance().submit());
            }
            else if (Tools.getInstance().checkMatching(RestaurantRegex.help, line)) {
                System.out.println(RestaurantController.getInstance().help());
            }
            else if (Tools.getInstance().checkMatching(RestaurantRegex.showIngredients, line)) {
                System.out.println(RestaurantController.getInstance().showIngredient(Tools.getInstance().getMatcher()));
            }
            else {
                System.out.println(WellComeMenuController.getInstance().invalidCommand());
            }
        }
    }
}
