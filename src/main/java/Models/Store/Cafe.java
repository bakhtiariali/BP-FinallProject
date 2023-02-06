package Models.Store;

import Models.Database.OrderDatabase;
import Models.Database.UserDatabase;
import Models.Order;
import Models.Products.Dessert.Dessert;
import Models.Products.Dessert.DessertType;
import Models.Products.Drink.Drink;
import Models.Products.Drink.DrinkType;
import Models.Products.Product;
import Models.Products.ProductType;
import Models.Storage;
import Models.UserType;

import java.util.ArrayList;

public class Cafe extends Store{
    private static Cafe cafe;
    public static Cafe getInstance() {
        if (cafe == null) {
            cafe = new Cafe();
        }
        return cafe;
    }
    public Cafe() {
        super();
        products.add(new Drink(DrinkType.Coffee));
        products.add(new Drink(DrinkType.Tea));
        products.add(new Drink(DrinkType.HotChocolate));
        products.add(new Dessert(DessertType.ChocolateCake));
        products.add(new Dessert(DessertType.VanillaCake));
        products.add(new Dessert(DessertType.IceCream));
    }

    private String getDrinks() {
        String res = "";
        for (Product product : products) {
            if (product.getProductType() == ProductType.Drink) {
                if (canMake(product)) {
                    res += "\t\t" + product + " ^_^"  + "\n";
                }
                else {
                    res += "\t\t" + product + " :("  + "\n";
                }
            }
        }
        return res;
    }

    private String getDesserts() {
        String res = "";
        for (Product product : products) {
            if (product.getProductType() == ProductType.Dessert) {
                if (canMake(product)) {
                    res += "\t\t" + product + " ^_^"  + "\n";
                }
                else {
                    res += "\t\t" + product + " :("  + "\n";
                }
            }
        }
        return res;
    }

    @Override
    public String getMenu() {
        return "Cafe Menu: {" + "\n" +
                "\t" + "Drink" + "\n" +
                getDrinks() +
                "\t" + "Dessert" + "\n" +
                getDesserts() +
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
                return product + "not found in Cafe Menu !";
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
        return "not found in Cafe menu!";
    }
}
