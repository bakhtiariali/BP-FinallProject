package Models.Products.Food;

import Models.Products.Ingredients;
import Models.Products.Product;
import Models.Products.ProductType;

import java.util.ArrayList;
import java.util.HashMap;

public class Food extends Product {
    private FoodType foodType;

    public Food(FoodType foodType) {
        super(ProductType.Food);
        this.foodType = foodType;
    }

    @Override
    public HashMap<Ingredients, Integer> getIngredientsAmount() {
        return foodType.getMaterial();
    }

    @Override
    public String getIngredients() {
        return foodType.getMaterial().keySet().toString();
    }

    @Override
    public String toString() {
        return foodType.name();
    }
}
