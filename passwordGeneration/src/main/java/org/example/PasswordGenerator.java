package org.example;

import java.util.*;
public class PasswordGenerator {
    private static final String LOWER_CASE_LETTER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE_LETTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&()-";

    public static String generatePassword(int length, int alphabetSize) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        if (length < 8) {
            System.out.println("Minimal password length size exceeded.");
            length = 8;
        }
        String lowerCase;
        String upperCase;
        String digit;
        String specialCharacters;

        alphabetSize -= alphabetSize%4;
        if (alphabetSize < 12) {
            System.out.println("Minimal alphabet size exceeded. The size of the alphabet is set to: 12");
            alphabetSize = 12;
        } else if (alphabetSize > 72) {
            System.out.println("Maximum alphabet size exceeded. The size of the alphabet is set to: 72");
            alphabetSize = 72;
        }
        int index = alphabetSize / 4;
        if (index <= SPECIAL_CHARACTERS.length()) {
             lowerCase =  LOWER_CASE_LETTER.substring(0, index);
             upperCase = UPPER_CASE_LETTER.substring(0, index);
             digit = DIGITS.substring(0, index);
             specialCharacters = SPECIAL_CHARACTERS.substring(0, index);
        } else {
            specialCharacters = SPECIAL_CHARACTERS;
            digit = DIGITS;
            index = alphabetSize/2 - SPECIAL_CHARACTERS.length();
            lowerCase =  LOWER_CASE_LETTER.substring(0, index);
            upperCase = UPPER_CASE_LETTER.substring(0, index);
        }

        int repetitions = length / 4 + 1;

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < repetitions; j++) {
                numbers.add(i + 1);
            }
        }

        Collections.shuffle(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            if (i >= length) break;
            if (numbers.get(i) == 1) {
                password.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
            } else if (numbers.get(i) == 2) {
                password.append(upperCase.charAt(random.nextInt(upperCase.length())));
            } else if (numbers.get(i) == 3) {
                password.append(digit.charAt(random.nextInt(digit.length())));
            } else {
                password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
            }
        }

        return password.toString();
    }
}
