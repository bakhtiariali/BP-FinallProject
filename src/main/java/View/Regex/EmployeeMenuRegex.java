package View.Regex;

public class EmployeeMenuRegex {
    public static final String logout = "^logout$";
    public static final String help = "^help$";
    public static final String showAllOrder = "^show all orders$";
    public static final String cancelOrder = "^cancel order --id (?<id>[0-9]+)$";
    public static final String StorageAmountReport = "^show storage inventory status$";
    public static final String increaseMaterialToAll = "^storage increase to all --amount (?<amount>[0-9]+)$";
    public static final String subtractMaterialFromAll = "^storage decrease from all --amount (?<amount>[0-9]+)$";
    public static final String addToSmt = "^storage add to(?<command>( --name \\S+ --amount [0-9]+)+)$";
}
