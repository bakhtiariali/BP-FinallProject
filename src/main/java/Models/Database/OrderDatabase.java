package Models.Database;

import Models.Order;
import Models.Products.Food.Food;
import Models.Products.Product;
import Models.Storage;
import Models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class OrderDatabase {

    private ArrayList<Order> orders;
    private static OrderDatabase database;
    public static OrderDatabase getInstance() {
        if (database == null) {
            database = new OrderDatabase();
        }
        return database;
    }

    public OrderDatabase() {
        orders = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("orders.json"));
            orders = new Gson().fromJson(br, new TypeToken<ArrayList<Order>>(){}.getType());
            br.close();
        }
        catch (Exception ex) {
//            ex.printStackTrace();
            orders = new ArrayList<>();
            saveData();
        }
    }

    private void saveData() {
        try {
            FileWriter writer = new FileWriter("orders.json");
            writer.write(new Gson().toJson(orders));
            writer.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void saveChanges() {
        saveData();
    }

    public Order getOrderById(int id) {
        for (Order order : orders) {
            System.out.print(order);
            if (order.getID() == id) return order;
        }
        return null;
    }

    public void addOrder(Order order)
    {
        orders.add(order);
    }

    public ArrayList<Order> getOrdersOfUser(User user) {
        ArrayList<Order> res = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomer().getName().equals(user.getName())) {
                res.add(order);
            }
        }
        return res;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public boolean haveOrder(int id) {
        for (Order order : orders) {
            if (order.getID() == id) return true;
        }
        return false;
    }

    public void removeOrder(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getID() == id) {
                ArrayList<Product> p = orders.get(i).getProducts();
                for (Product product : p) {
                    Storage.getInstance().addToSmt(product.getIngredientsAmount());
                }
                orders.remove(i);
                return;
            }
        }
    }
}