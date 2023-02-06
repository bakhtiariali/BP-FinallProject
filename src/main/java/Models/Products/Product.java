package Models.Products;

import java.util.HashMap;
public abstract class Product {
    private ProductType productType;

    public Product(ProductType productType) {
        this.productType = productType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public abstract HashMap<Ingredients, Integer> getIngredientsAmount();
    public abstract String getIngredients();
    public abstract String toString();
}
