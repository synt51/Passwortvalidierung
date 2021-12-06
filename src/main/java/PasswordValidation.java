import java.util.Locale;

public class PasswordValidation {

    public static final int MIN_LENGTH = 8;
    private static final String[] FORBIDDEN_WORDS = new String[]{"Hallo1234!", "Qwertz123!", "ThisI$Safe42"};

    public static boolean checkLength(String password) {
        boolean lengthOk = (password.length()>= MIN_LENGTH);
        return lengthOk;
    }

    public static boolean checkMixedLetters(String password) {
        String lowerCaseLetters = password.toLowerCase(Locale.ROOT);
        String upperCaseLetters = password.toUpperCase(Locale.ROOT);
        return !lowerCaseLetters.equals(password) && !upperCaseLetters.equals(password);
    }

    public static boolean checkDigits(String password) {
        char[] passwordArray = password.toCharArray();
        for (char symbol : passwordArray){
            if (Character.isDigit(symbol)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkForbiddenWord(String password) {
        for (String passwordForbidden : FORBIDDEN_WORDS){
            if(password.equals(passwordForbidden)){
                return false;
            }
        }
        return true;
    }

    public static boolean checkNonWordChar(String password) {
        char[] nonWordCharArray = password.toCharArray();
        for (char nonWordChar : nonWordCharArray){
            if(!Character.isAlphabetic(nonWordChar) && !Character.isDigit(nonWordChar)){
                return true;
            }
        }
        return false;
    }
}
