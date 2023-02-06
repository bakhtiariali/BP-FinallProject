package Models.Products.Appetizer;

import Models.Products.Ingredients;
import java.util.HashMap;

public enum AppetizerType {
    Salad, FrenchFries;
    public HashMap<Ingredients, Integer> getMaterial() {
        HashMap<Ingredients, Integer> hashMap = new HashMap<>();
        if (this == Salad) {
            hashMap.put(Ingredients.Vegetable, 3);
        }
        else if (this == FrenchFries) {
            hashMap.put(Ingredients.Potato, 2);
        }
        return hashMap;
    }

}
