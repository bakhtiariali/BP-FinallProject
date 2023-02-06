package Models.Products.Dessert;

import Models.Products.Ingredients;

import java.util.HashMap;

public enum DessertType {
    ChocolateCake, VanillaCake, IceCream;
    public HashMap<Ingredients, Integer> getMaterial() {
        HashMap<Ingredients, Integer> hashMap = new HashMap<>();
        if (this == ChocolateCake) {
            hashMap.put(Ingredients.Chocolate, 2);
            hashMap.put(Ingredients.Soda, 1);
            hashMap.put(Ingredients.Flour, 2);
            hashMap.put(Ingredients.Egg, 2);
        }
        else if (this == VanillaCake) {
            hashMap.put(Ingredients.Vanilla, 2);
            hashMap.put(Ingredients.Soda, 1);
            hashMap.put(Ingredients.Flour, 2);
            hashMap.put(Ingredients.Egg, 2);
        }
        else if (this == IceCream) {
            hashMap.put(Ingredients.IceCream, 4);
        }
        return hashMap;
    }

}
