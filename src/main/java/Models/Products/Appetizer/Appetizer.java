package Models.Products.Appetizer;

import Models.Products.Ingredients;
import Models.Products.Product;
import Models.Products.ProductType;

import java.util.HashMap;

public class Appetizer extends Product {

    private AppetizerType appetizerType;

    public Appetizer(AppetizerType appetizerType) {
        super(ProductType.Appetizer);
        this.appetizerType = appetizerType;
    }

    @Override
    public HashMap<Ingredients, Integer> getIngredientsAmount() {
        return appetizerType.getMaterial();
    }

    @Override
    public String getIngredients() {
        return appetizerType.getMaterial().keySet().toString();
    }

    @Override
    public String toString() {
        return appetizerType.name();
    }
}
