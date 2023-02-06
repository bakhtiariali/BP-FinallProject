package Models.Products;

import java.util.ArrayList;
import java.util.List;

public enum Ingredients {
    Flour, Cheese, Meat, Bread, Vegetable, Chicken, Potato, CoffeeBeans, Tea, Chocolate, Soda,
    IceCream, Egg, Vanilla;

    public static ArrayList<Ingredients> getAllType() {
        return new ArrayList<Ingredients>(List.of(Ingredients.values()));
    }

    public static Ingredients get(String str) {
        for (Ingredients ingredient : getAllType()) {
            if (str.equals(ingredient.name())) {
                return ingredient;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return this.name();
    }
}

