package View.Regex;

public class RestaurantRegex {
    public static final String showMenu = "^show menu$";
    public static final String order = "^order --product (?<productName>\\S+)$";
    public static final String back = "^back$";
    public static final String submit = "^submit$";
    public static final String help = "^help$";
    public static final String showIngredients = "^show ingredients --product (?<productName>\\S+)$";
}
