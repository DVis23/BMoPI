package org.example;

import java.util.List;

public class CheckerUniquenessLogin {

    public static boolean checkUniquenessLogin(String login, List<User> users) {
        for (User user : users) {
            if (user.getLogin().equals(login)) return false;
        }
        return true;
    }
}
