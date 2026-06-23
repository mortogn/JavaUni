package controller;

import model.User;
import services.UserServices;

public class AuthController {
    private UserServices userServices;

    public AuthController() {
        userServices = new UserServices();
    }

    public boolean login(String email, String password) {
        User user = userServices.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            Session.setCurrentUser(user);
            return true;
        }

        Session.setCurrentUser(null);

        return false;
    }

    public boolean register(String email, String password, String fullname) {
        User newUser = new User(email, password, fullname);
        boolean result = userServices.saveUser(newUser);

        if (result) {
            Session.setCurrentUser(newUser);
        }

        return result;
    }
}
