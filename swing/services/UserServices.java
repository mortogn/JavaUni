package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import model.User;
import util.FileUtil;

public class UserServices {
    private static final String USER_DATA_PATH = "data/users.json";
    private Gson gson = new Gson();

    public List<User> getUsers() {
        String json = FileUtil.readFile(USER_DATA_PATH);

        if (json == null || json.isBlank()) {
            return new ArrayList<>();
        }

        User[] users = gson.fromJson(json, User[].class);
        return users == null ? new ArrayList<>() : new ArrayList<>(Arrays.asList(users));
    }

    public User getUserByEmail(String email) {
        List<User> users = getUsers();
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    public boolean saveUser(User user) {
        List<User> users = getUsers();

        // Check whether a user with the same email already exists
        for (User existingUser : users) {
            if (existingUser.getEmail().equalsIgnoreCase(user.getEmail())) {
                return false;
            }
        }

        users.add(user);
        String json = gson.toJson(users);
        FileUtil.writeFile(USER_DATA_PATH, json);
        return true;
    }

}
