package Models.Products.Food;

import Models.Products.Ingredients;

import java.util.ArrayList;
import java.util.HashMap;

public enum FoodType {
    Pizza, Burger, steak, FriedChicken;
    public HashMap<Ingredients, Integer> getMaterial() {
        HashMap<Ingredients, Integer> hashMap = new HashMap<>();
        if (this == Pizza) {
            hashMap.put(Ingredients.Meat, 2);
            hashMap.put(Ingredients.Chicken, 2);
            hashMap.put(Ingredients.Cheese, 2);
            hashMap.put(Ingredients.Vegetable, 1);
            hashMap.put(Ingredients.Potato, 1);

        }
        else if (this == Burger) {
            hashMap.put(Ingredients.Bread, 2);
            hashMap.put(Ingredients.Meat, 2);
            hashMap.put(Ingredients.Cheese, 1);
            hashMap.put(Ingredients.Vegetable, 1);
        }
        return hashMap;
    }
}
