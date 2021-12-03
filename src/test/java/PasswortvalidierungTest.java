import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswortvalidierungTest {

    String examplePassword = "n€uef|Sch3";

    String[] badPassword = {"passwort", "password", "hello", "hallo", "123456"};

    @Test
    public void testPasswordLength() {
        assert examplePassword.length() >= 8;
    }

    @Test
    public void testPasswordContainsNumbers() {
        assert examplePassword.matches(".*\\d.*");
    }

    @Test
    public void testPasswordContainsLetter() {
        assert examplePassword.matches(".*\\D.*");
    }

    @Test
    public void testPasswordContainsNonWordChar() {
        assert examplePassword.matches(".*\\W.*");
    }

    @Test
    public void testPasswordContainsLowerCamelCases() {
        assert examplePassword.matches(".*[a-z].*");
    }
    @Test
    public void testPasswordContainsUpperCamelCases() {
        assert examplePassword.matches(".*[A-Z].*");
    }

    @Test
    public void testPasswordNotEqualsBadWords() {
        //assertNotEquals(badPassword, examplePassword);
        assertNotEquals("passwort", examplePassword);
    }
}