import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {
        /*
    - min 8 Buchstaben !
    - Klein- und Großbuchstaben !
    - min 1 Zahl !
    - verbotene Passwörter !
    - Sonderzeichen !
     */
    @Test
    public void checkLength(){
        String password = "n€uef|Sch3";
        boolean actual = PasswordValidation.checkLength(password);
        assertTrue(actual);
    }

    @Test
    public void checkLengthFalse(){
        String password = "n€uf|S3";
        boolean actual = PasswordValidation.checkLength(password);
        assertFalse(actual);
    }

    @Test
    public void checkMixedCaseLetters(){
        String password = "n€uef|Sch3";
        boolean actual = PasswordValidation.checkMixedLetters(password);
        assertTrue(actual);
    }

    @Test
    public void checkOnlyLowerLetters(){
        String password = "n€uef|sch3";
        boolean actual = PasswordValidation.checkMixedLetters(password);
        assertFalse(actual);
    }
    @Test
    public void checkOnlyUpperLetters(){
        String password = "N€UEF|SCH3";
        boolean actual = PasswordValidation.checkMixedLetters(password);
        assertFalse(actual);
    }

    @Test
    public void checkIfContainsDigit(){
        String password = "n€uef|Sch3";
        boolean actual = PasswordValidation.checkDigits(password);
        assertTrue(actual);
    }

    @Test
    public void checkIfContainsDigitFalse(){
        String password = "n€uef|Sche";
        boolean actual = PasswordValidation.checkDigits(password);
        assertFalse(actual);
    }

    @Test
    public void checkForbiddenWords(){
        String password = "n€uef|Sch3";
        boolean actual = PasswordValidation.checkForbiddenWord(password);
        assertTrue(actual);
    }

    @Test
    public void checkForbiddenWordsFalse(){
        String password = "Qwertz123!";
        boolean actual = PasswordValidation.checkForbiddenWord(password);
        assertFalse(actual);
    }

    @Test
    public void checkNonWordChar(){
        String password = "n€uef|Sch3";
        boolean actual = PasswordValidation.checkNonWordChar(password);
        assertTrue(actual);
    }

    @Test
    public void checkNonWordCharFalse(){
        String password = "nEuefISch3";
        boolean actual = PasswordValidation.checkNonWordChar(password);
        assertFalse(actual);
    }
}