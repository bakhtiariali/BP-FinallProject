package View.Regex;

public class WellComeMenuRegex {
    public static final String Login =
            "^user login --name (?<name>[a-zA-Z0-9]+) --password (?<password>\\S+)$";

    public static final String register =
            "^user create --name (?<name>[a-z0-9]+) --password (?<password>\\S+) --type (?<type>\\S+)$";

    public static final String help = "^help$";
    public static final String Exit = "^exit$";
}
