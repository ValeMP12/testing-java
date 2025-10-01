package org.valeria.javatests.util;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.valeria.javatests.util.PasswordUtil.SecurityLevel.MEDIUM;
import static org.valeria.javatests.util.PasswordUtil.SecurityLevel.WEAK;

public class PasswordUtilTest {
    @Test
    public void weakWhenLessThan8Chars() {
        assertEquals(WEAK, PasswordUtil.assessPassword("12345"));
    }
    @Test
    public void weakWhenHasOnlyLetters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("abcdefgh"));
    }
    @Test
    public void mediumWhenHasLettersAndNumbers() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcd1234ed"));
    }
    @Test
    public void mediumWhenHasOnlyLetters() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcdefg52463h"));
    }
    @Test
    public void strongWhenHasLettersNumbersAndUpperCase() {
        assertEquals(PasswordUtil.SecurityLevel.STRONG, PasswordUtil.assessPassword("a3!%&1edA$"));
    }
}