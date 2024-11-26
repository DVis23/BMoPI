package org.example;

import org.jnativehook.NativeHookException;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

import static org.example.CheckerKeyHandwriting.checkKeyHandwriting;
import static org.example.CheckerUniquenessLogin.checkUniquenessLogin;
import static org.example.Hashing.hashingSHA256;

public class Authentication {

    public static void authentication(Scanner scanner, List<User> users) throws NativeHookException, NoSuchAlgorithmException {
        String login = null;
        while (login == null || checkUniquenessLogin(login, users)) {
            System.out.println("Enter the unique login: ");
            login = scanner.next();
        }
        User user = null;
        for(User u : users) {
            if (u.getLogin().equals(login)) user = u;
        }
        System.out.println("Enter the password: ");

        List<long[]> keyEvents = KeyPressLogger.keyLogging();
        String password = KeyConverter.convertKeyCodesToString(keyEvents);

        if (user != null) {
            if (user.getHashPassword().equals(hashingSHA256(password))) {
                if (checkKeyHandwriting(keyEvents, user.getBiometricMatrix())) {
                    System.out.println("Successfully");
                } else {
                    System.out.println("Authentication failed");
                }
            } else {
                System.out.println("Invalid password");
            }
        }
        scanner.next();
    }
}
