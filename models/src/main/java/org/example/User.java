package org.example;

import java.util.UUID;
import com.fasterxml.jackson.annotation.*;

public class User {
    private String login;
    private final UUID uuid;
    private final String hashPassword;
    private BiometricMatrix biometricMatrix;

    @JsonCreator
    public User(@JsonProperty("login") String login,
                @JsonProperty("uuid") UUID uuid,
                @JsonProperty("hashPassword") String hashPassword,
                @JsonProperty("biometricMatrix") BiometricMatrix biometricMatrix) {
        this.login = login;
        this.uuid = uuid;
        this.hashPassword = hashPassword;
        this.biometricMatrix = biometricMatrix;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public UUID getUuid() {
        return uuid;
    }
    public String getHashPassword() {
        return hashPassword;
    }

    public BiometricMatrix getBiometricMatrix() {
        return biometricMatrix;
    }
    public void setBiometricMatrix(BiometricMatrix biometricMatrix) {
        this.biometricMatrix = biometricMatrix;
    }

    public void enterUserToConsole(){
        System.out.println("Login: " + login);
        System.out.println("ID: " + uuid.toString());
    }
}
