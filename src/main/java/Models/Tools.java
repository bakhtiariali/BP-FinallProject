package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {
    private static Tools tools;
    public static Tools getInstance() {
        if (tools == null) {
            tools = new Tools();
        }
        return tools;
    }

    private Scanner in;
    private Matcher matcher;
    private Random random = new Random();
    private int ID;
    public Tools() {
        ID = RandomNumberGenerator(1111, 5555);
        in = new Scanner(System.in);
    }

    public int UniqueIdGenerator() {
        ID += 1;
        return ID;
    }

    public int RandomNumberGenerator(int a, int b) {
        return random.nextInt(a, b);
    }

    public String readLine() {
        System.out.print("> ");
        return in.nextLine().trim();
    }

    public boolean checkMatching(String regex, String input) {
        Pattern p = Pattern.compile(regex);
        matcher = p.matcher(input);
        return matcher.matches();
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public String getDateAndTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
