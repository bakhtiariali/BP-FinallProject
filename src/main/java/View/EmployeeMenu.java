package View;

import Controller.EmployeeMenuController;
import Controller.MenuController;
import Controller.WellComeMenuController;
import Models.Tools;
import View.Regex.EmployeeMenuRegex;
import View.Regex.WellComeMenuRegex;

public class EmployeeMenu implements Menu{
    @Override
    public void run() {
        while (MenuController.getInstance().getCurrentMenu() == MenuType.EmployeeMenu) {
            System.out.println("--Employee menu--");
            String line = Tools.getInstance().readLine();
            if (Tools.getInstance().checkMatching(EmployeeMenuRegex.logout, line)) {
                System.out.println(EmployeeMenuController.getInstance().logout());
            }
            else if (Tools.getInstance().checkMatching(EmployeeMenuRegex.cancelOrder, line)) {
                System.out.println(EmployeeMenuController.getInstance().cancel_a_Order(Tools.getInstance().getMatcher()));
            }
            else if (Tools.getInstance().checkMatching(EmployeeMenuRegex.showAllOrder, line)) {
                System.out.println(EmployeeMenuController.getInstance().showAllOrders());
            }
            else if (Tools.getInstance().checkMatching(EmployeeMenuRegex.help, line)) {
                System.out.println(EmployeeMenuController.getInstance().help());
            }
            else if (Tools.getInstance().checkMatching(EmployeeMenuRegex.StorageAmountReport, line)) {
                System.out.println(EmployeeMenuController.getInstance().showStorageReport());
            }
            else if (Tools.getInstance().checkMatching(EmployeeMenuRegex.increaseMaterialToAll, line)) {
                System.out.println(EmployeeMenuController.getInstance().
                        increaseMaterialToAll(Tools.getInstance().getMatcher()));
            }
            else if (Tools.getInstance().checkMatching(EmployeeMenuRegex.subtractMaterialFromAll, line)) {
                System.out.println(EmployeeMenuController.getInstance().
                        decreaseMaterialFromAll(Tools.getInstance().getMatcher()));
            }
            else if (Tools.getInstance().checkMatching(EmployeeMenuRegex.addToSmt, line))
                System.out.println(EmployeeMenuController.getInstance()
                        .increaseSomeIngredients(Tools.getInstance().getMatcher()));
            else {
                System.out.println(WellComeMenuController.getInstance().invalidCommand());
            }
        }
    }
}
