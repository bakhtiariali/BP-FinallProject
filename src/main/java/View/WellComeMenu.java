package View;

import Controller.MenuController;
import Controller.WellComeMenuController;
import Models.Tools;
import View.Regex.WellComeMenuRegex;

public class WellComeMenu implements Menu {
    @Override
    public void run() {
        while (MenuController.getInstance().getCurrentMenu() == MenuType.WellComeMenu) {
            System.out.println("--WellCome Menu--");
            String line = Tools.getInstance().readLine();
            if (Tools.getInstance().checkMatching(WellComeMenuRegex.Login, line)) {
                System.out.println(WellComeMenuController.getInstance().Login(Tools.getInstance().getMatcher()));
            }
            else if (Tools.getInstance().checkMatching(WellComeMenuRegex.register, line)) {
                System.out.println(WellComeMenuController.getInstance().Register(Tools.getInstance().getMatcher()));
            }
            else if (Tools.getInstance().checkMatching(WellComeMenuRegex.Exit, line)) {
                System.out.println(WellComeMenuController.getInstance().Exit());
            }
            else if (Tools.getInstance().checkMatching(WellComeMenuRegex.help, line)) {
                System.out.println(WellComeMenuController.getInstance().help());
            }
            else {
                System.out.println(WellComeMenuController.getInstance().invalidCommand());
            }
        }
    }
}
