package Models.Products.Drink;

import Models.Products.Ingredients;

import java.util.ArrayList;
import java.util.HashMap;

public enum DrinkType {
    Coffee, Tea, HotChocolate, SoftDrink, Water;
    public HashMap<Ingredients, Integer> getMaterial() {
        HashMap<Ingredients, Integer> hashMap = new HashMap<>();
        if (this == Coffee) {
            hashMap.put(Ingredients.CoffeeBeans, 1);
        }
        else if (this == Tea) {
            hashMap.put(Ingredients.Tea, 1);
        }
        else if (this == HotChocolate) {
            hashMap.put(Ingredients.Chocolate, 1);
        }
        return hashMap;
    }
}
