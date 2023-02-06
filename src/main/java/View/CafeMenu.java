package View;

import Controller.CafeController;
import Controller.MenuController;
import Controller.WellComeMenuController;
import Models.Store.Cafe;
import Models.Tools;
import View.Regex.CafeRegex;

public class CafeMenu implements Menu {
    @Override
    public void run() {
        while (MenuController.getInstance().getCurrentMenu() == MenuType.CafeMenu) {
            System.out.println("--Cafe menu--");
            String line = Tools.getInstance().readLine();
            if (Tools.getInstance().checkMatching(CafeRegex.showMenu, line)) {
                System.out.println(CafeController.getInstance().showMenu());
            }
            else if (Tools.getInstance().checkMatching(CafeRegex.back, line)) {
                System.out.println(CafeController.getInstance().back());
            }
            else if (Tools.getInstance().checkMatching(CafeRegex.order, line)) {
                System.out.println(CafeController.getInstance().order(Tools.getInstance().getMatcher()));
            }
            else if (Tools.getInstance().checkMatching(CafeRegex.submit, line)) {
                System.out.println(CafeController.getInstance().submit());
            }
            else if (Tools.getInstance().checkMatching(CafeRegex.help, line)) {
                System.out.println(CafeController.getInstance().help());
            }
            else if (Tools.getInstance().checkMatching(CafeRegex.showIngredients, line)) {
                System.out.println(CafeController.getInstance().showIngredient(Tools.getInstance().getMatcher()));
            }
            else {
                System.out.println(WellComeMenuController.getInstance().invalidCommand());
            }
        }
    }
}
