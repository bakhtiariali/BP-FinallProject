package View;

import Controller.CustomerMenuController;
import Controller.MenuController;
import Controller.WellComeMenuController;
import Models.Tools;
import View.Regex.CustomerMenuRegex;
import View.Regex.WellComeMenuRegex;

import javax.crypto.Cipher;

public class CustomerMenu implements Menu {

    @Override
    public void run() {
        while (MenuController.getInstance().getCurrentMenu() == MenuType.CustomerMenu) {
            System.out.println("--Customer menu--");
            String line = Tools.getInstance().readLine();
            if (Tools.getInstance().checkMatching(CustomerMenuRegex.history, line)) {
                System.out.println(CustomerMenuController.getInstance().getHistory());
            }
            else if (Tools.getInstance().checkMatching(CustomerMenuRegex.logout, line)) {
                System.out.println(CustomerMenuController.getInstance().logout());
            }
            else if (Tools.getInstance().checkMatching(CustomerMenuRegex.gotoCafe, line)) {
                System.out.println(CustomerMenuController.getInstance().gotoCafe());
            }
            else if (Tools.getInstance().checkMatching(CustomerMenuRegex.gotoRestaurant, line)) {
                System.out.println(CustomerMenuController.getInstance().gotoRestaurant());
            }
            else if (Tools.getInstance().checkMatching(WellComeMenuRegex.help, line)) {
                System.out.println(CustomerMenuController.getInstance().help());
            }
            else {
                System.out.println(WellComeMenuController.getInstance().invalidCommand());
            }
        }
    }
}
