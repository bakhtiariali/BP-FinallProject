package Models.Products.Drink;

import Models.Products.Ingredients;
import Models.Products.Product;
import Models.Products.ProductType;

import java.util.HashMap;

public class Drink extends Product {
    private DrinkType drinkType;

    public Drink(DrinkType drinkType) {
        super(ProductType.Drink);
        this.drinkType = drinkType;
    }

    @Override
    public HashMap<Ingredients, Integer> getIngredientsAmount() {
        return drinkType.getMaterial();
    }

    @Override
    public String getIngredients() {
        return drinkType.getMaterial().keySet().toString();
    }

    @Override
    public String toString() {
        return drinkType.name();
    }
}
