package Models.Store;

import Models.Database.OrderDatabase;
import Models.Database.UserDatabase;
import Models.Order;
import Models.Products.Appetizer.Appetizer;
import Models.Products.Appetizer.AppetizerType;
import Models.Products.Dessert.Dessert;
import Models.Products.Drink.Drink;
import Models.Products.Drink.DrinkType;
import Models.Products.Food.Food;
import Models.Products.Food.FoodType;
import Models.Products.Product;
import Models.Products.ProductType;
import Models.Storage;

import java.util.ArrayList;

public class Restaurant extends Store{
    private static Restaurant restaurant;
    public static Restaurant getInstance() {
        if (restaurant == null) {
            restaurant = new Restaurant();
        }
        return restaurant;
    }
    public Restaurant() {
        super();
        products.add(new Food(FoodType.Pizza));
        products.add(new Food(FoodType.Burger));
        products.add(new Food(FoodType.steak));
        products.add(new Food(FoodType.FriedChicken));
        products.add(new Drink(DrinkType.SoftDrink));
        products.add(new Drink(DrinkType.Water));
        products.add(new Appetizer(AppetizerType.Salad));
        products.add(new Appetizer(AppetizerType.FrenchFries));
    }

    private String getFoods() {
        String res = "";
        for (Product product : products) {
            if (product.getProductType() == ProductType.Food) {
                if (canMake(product))
                    res += "\t\t" + product + " ^_^"  + "\n";
                else
                    res += "\t\t" + product + " :("  + "\n";
            }
        }
        return res;
    }
    private String getAppetizers() {
        String res = "";
        for (Product product : products) {
            if (product.getProductType() == ProductType.Appetizer) {
                if (canMake(product))
                    res += "\t\t" + product + " ^_^"  + "\n";
                else
                    res += "\t\t" + product + " :("  + "\n";
            }
        }
        return res;
    }
    private String getDrinks() {
        String res = "";
        for (Product product : products) {
            if (product.getProductType() == ProductType.Drink) {
                if (canMake(product))
                    res += "\t\t" + product + " ^_^"  + "\n";
                else
                    res += "\t\t" + product + " :("  + "\n";
            }
        }
        return res;
    }
    @Override
    public String getMenu() {
        return "Restaurant Menu: {" + "\n" +
                "\t" + "Food" + "\n" +
                    getFoods() +
                "\t" + "Appetizer" + "\n" +
                    getAppetizers() +
                "\t" + "Drink" + "\n" +
                    getDrinks() +
                "}" + "\n" +
                "^_^ : You can order" + "\n" +
                ":( : It is not possible to order"
                ;
    }

    @Override
    public String addOrder(ArrayList<String> productsName) {
        ArrayList<Product> productList = getProductList(productsName);
        for (Product product : productList) {
            if (!getMenu().contains(product.toString())) {
                return product + "not found in Restaurant Menu !";
            }
        }
        if (!Storage.getInstance().canMake(productList)) {
            return "we can not done right now!";
        }
        for (Product product : productList) {
            Storage.getInstance().updateStorageForMake(product);
        }
        Order order = new Order(UserDatabase.getInstance().getCurrentUser(), productList);
        OrderDatabase.getInstance().addOrder(order);
        OrderDatabase.getInstance().saveChanges();
        return "The order by ID: " + order.getID() + " was executed successfully!";
    }

    private ArrayList<Product> getProductList(ArrayList<String> productsName) {
        ArrayList<Product> productList = new ArrayList<>();
        for (String productName : productsName) {
            for (Product product : products) {
                if (product.toString().equals(productName))
                {
                    productList.add(product);
                }
            }
        }
        return productList;
    }
    public String getIngredients(String productName) {
        for (Product product : products) {
            if (product.toString().equals(productName)) {
                return product.getIngredients();
            }
        }
        return "not found in Restaurant menu!";
    }
}
