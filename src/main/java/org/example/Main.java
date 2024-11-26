package org.example;

import org.jnativehook.NativeHookException;

import java.io.IOException;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;


import static org.example.Authentication.authentication;
import static org.example.Registration.*;

// 3 лаба - 4 вариант

public class Main {
    public static void main(String[] args) throws NativeHookException, NoSuchAlgorithmException, IOException {

        List<User> users = UserReaderJson.readUsers("users/users.json");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option: \n" +
                    "0 - create the user \n" +
                    "1 - log in as a user \n" +
                    "2 - enter the users \n" +
                    "3 - exit");
            int index = scanner.nextInt();
            if (index == 0) {
                createUser(scanner, users);
            } else if (index == 1) {
                authentication(scanner, users);
            } else if (index == 2) {
                for (User user : users) {
                    user.enterUserToConsole();
                }
            } else if (index == 3) {
                break;
            } else {
                System.out.println("The wrong command");
            }
        }
    }


}


