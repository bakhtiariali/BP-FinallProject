package Models.Database;

import Models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class UserDatabase {

    private ArrayList<User> users;
    private User currentUser;
    private static UserDatabase database;
    public static UserDatabase getInstance() {
        if (database == null) {
            database = new UserDatabase();
        }
        return database;
    }

    public UserDatabase() {
        this.users = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("users.json"));
            users = new Gson().fromJson(br, new TypeToken<ArrayList<User>>(){}.getType());
            br.close();
        }
        catch (Exception ex) {
            users = new ArrayList<>();
            saveData();
        }
    }

    private void saveData() {
        try {
            FileWriter writer = new FileWriter("users.json");
            writer.write(new Gson().toJson(users));
            writer.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void saveChanges() {
        saveData();
    }

    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) return user;
        }
        return null;
    }

    public void addUser(User user)
    {
        users.add(user);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}