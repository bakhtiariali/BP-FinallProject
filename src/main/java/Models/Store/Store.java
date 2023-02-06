package Models.Store;

import Models.Products.Product;
import Models.Storage;

import java.util.ArrayList;

public abstract class Store {
    protected ArrayList<Product> products;

    public Store() {
        products = new ArrayList<>();
    }

    public abstract String getMenu();
    public abstract String addOrder(ArrayList<String> productsName);

    protected boolean canMake(Product product) {
        return Storage.getInstance().canMake(product);
    }
}
