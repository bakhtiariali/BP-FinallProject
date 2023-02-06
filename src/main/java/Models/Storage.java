package Models;

import Models.Products.Ingredients;
import Models.Products.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
    private static Storage storage;
    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    HashMap<Ingredients, Integer> STORAGE;
    public Storage() {
        loadData();
    }
    private void initialize() {
        STORAGE = new HashMap<>();
        for (Ingredients ingredient : Ingredients.getAllType()) {
            int amount = Tools.getInstance().RandomNumberGenerator(0, 10);
            STORAGE.put(ingredient, amount);
        }
    }
    private void loadData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("storage.json"));
            STORAGE = new Gson().fromJson(br, new TypeToken<HashMap<Ingredients, Integer>>(){}.getType());
            br.close();
        }
        catch (Exception ex) {
            initialize();
            saveData();
        }
    }
    private void saveData() {
        try {
            FileWriter writer = new FileWriter("storage.json");
            writer.write(new Gson().toJson(STORAGE));
            writer.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getAmountReport() {
        String s = "Storage Amount Report {" + "\n";
        for (Ingredients ingredient : STORAGE.keySet()) {
            s += "\t" + ingredient.name() + ": '" + STORAGE.get(ingredient) + "'\n";
        }
        s += "}";
        return s;
    }

    public void addToAll(int amount) {
        for (Ingredients ingredient : STORAGE.keySet()) {
            int val = STORAGE.get(ingredient);
            STORAGE.replace(ingredient, val +  amount);
        }
        saveData();
    }

    public String subtractFromAll(int amount) {
        for (Ingredients ingredient : STORAGE.keySet()) {
            int val = STORAGE.get(ingredient);
            if (amount > val) {
                return "we can not subtract " + amount + " from " + ingredient + "!";
            }
        }
        for (Ingredients ingredient : STORAGE.keySet()) {
            int val = STORAGE.get(ingredient);
            STORAGE.replace(ingredient, val -  amount);
        }
        saveData();
        return "done successfully!";
    }

    public void addToSmt(HashMap<Ingredients, Integer> i) {
        for (Ingredients ingredient : i.keySet()) {
            int val = STORAGE.get(ingredient);
            int amount = i.get(ingredient);
            STORAGE.replace(ingredient, val +  amount);
        }
        saveData();
    }

    public boolean canMake(ArrayList<Product> productList) {
        HashMap<Ingredients, Integer> hashMap = new HashMap<>();
        for (Product product : productList) {
            for (Ingredients ingredient : product.getIngredientsAmount().keySet()) {
                if (hashMap.containsKey(ingredient)) {
                    int val = hashMap.get(ingredient);
                    hashMap.replace(ingredient, val + product.getIngredientsAmount().get(ingredient));
                }
                else {
                    hashMap.put(ingredient, product.getIngredientsAmount().get(ingredient));
                }
            }
        }
        for (Ingredients ingredient : hashMap.keySet()) {
            int val = hashMap.get(ingredient);
            int have = STORAGE.get(ingredient);
            if (val > have) return false;
        }
        return true;
    }

    public boolean canMake(Product products) {
        for (Ingredients ingredient : products.getIngredientsAmount().keySet()) {
            int val = STORAGE.get(ingredient);
            int need = products.getIngredientsAmount().get(ingredient);
            if (need > val) return false;
        }
        return true;
    }
    public void updateStorageForMake(Product product) {
        for (Ingredients ingredient : product.getIngredientsAmount().keySet()) {
            int need = product.getIngredientsAmount().get(ingredient);
            int val = STORAGE.get(ingredient);
            STORAGE.replace(ingredient, val - need);
        }
        saveData();
    }
}
