package org.valeria.javatests.util;

public class PasswordUtil {
    public  enum SecurityLevel {
        WEAK, MEDIUM, STRONG
    }
    public static SecurityLevel assessPassword(String password) {
        if (password.length() <= 8) {
            return SecurityLevel.WEAK;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
        }
        if (hasUpper && hasLower && hasDigit) {
            return SecurityLevel.STRONG;
        }
        return SecurityLevel.MEDIUM;
    }
}
