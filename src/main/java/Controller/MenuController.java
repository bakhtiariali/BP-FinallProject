package Controller;

import View.*;

public class MenuController {
    private static MenuController menuController;
    public static MenuController getInstance() {
        if (menuController == null) {
            menuController = new MenuController();
        }
        return menuController;
    }

    private MenuType currentMenu;
    private final Menu wellComeMenu;
    private final Menu customerMenu;
    private final Menu employeeMenu;
    private final Menu cafeMenu;
    private final Menu restaurantMenu;

    public MenuController() {
        currentMenu = MenuType.WellComeMenu;
        wellComeMenu = new WellComeMenu();
        customerMenu = new CustomerMenu();
        employeeMenu = new EmployeeMenu();
        cafeMenu = new CafeMenu();
        restaurantMenu = new RestaurantMenu();
    }

    public MenuType getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(MenuType currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void run() {
        System.out.println("welcome to bp final project");
        while (currentMenu != MenuType.Exit) {
            wellComeMenu.run();
            customerMenu.run();
            employeeMenu.run();
            cafeMenu.run();
            restaurantMenu.run();
        }
    }
}
