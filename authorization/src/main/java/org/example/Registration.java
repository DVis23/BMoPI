package org.example;

import org.example.calculation.KeyHoldingReader;
import org.example.calculation.KeyIntervalReader;
import org.jnativehook.NativeHookException;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import static org.example.CheckerUniquenessLogin.checkUniquenessLogin;
import static org.example.Hashing.hashingSHA256;

public class Registration {

    public static List<User> createUser(Scanner scanner, List<User> users) throws IOException, NativeHookException, NoSuchAlgorithmException {
        String login = null;
        while (login == null || !checkUniquenessLogin(login, users)) {
            System.out.println("Enter the unique login: ");
            login = scanner.next();
        }
        System.out.println("Enter the password: ");

        List<long[]> keyEvents = KeyPressLogger.keyLogging();
        String password = KeyConverter.convertKeyCodesToString(keyEvents);
        List<KeyHoldingTime> keyHolding = KeyHoldingReader.readKeyHolding(keyEvents);
        List<KeyInterval> keyInterval = KeyIntervalReader.readKeyInterval(keyEvents);
        BiometricMatrix biometricMatrix = new BiometricMatrix(keyHolding, keyInterval);


        UUID id = UUID.randomUUID();

        User user = new User(login, id, hashingSHA256(password), biometricMatrix);
        users.add(user);
        UserWriterJson.writeUsers(users, "users/users.json");
        users = UserReaderJson.readUsers("users/users.json");
        scanner.next();
        return users;
    }
}
