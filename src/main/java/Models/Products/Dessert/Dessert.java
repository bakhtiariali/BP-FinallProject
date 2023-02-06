package Models.Products.Dessert;

import Models.Products.Ingredients;
import Models.Products.Product;
import Models.Products.ProductType;

import java.util.ArrayList;
import java.util.HashMap;

public class Dessert extends Product {
    private DessertType dessertType;

    public Dessert(DessertType dessertType) {
        super(ProductType.Dessert);
        this.dessertType = dessertType;
    }

    @Override
    public HashMap<Ingredients, Integer> getIngredientsAmount() {
        return dessertType.getMaterial();
    }

    @Override
    public String getIngredients() {
        return dessertType.getMaterial().keySet().toString();
    }

    @Override
    public String toString() {
        return dessertType.name();
    }
}
