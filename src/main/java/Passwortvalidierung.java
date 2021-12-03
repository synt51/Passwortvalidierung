import java.util.Scanner;

public class Passwortvalidierung {

    public static void print(String what) {
        System.out.println(what);
    }

    public static void initPasswordvalidation() {
        print("Willkommen im Login Menu!");
        print("Bitte denk dir ein Passwort aus!");
        print("(mindestens 8-stellig, min. 1 Ziffer, min. 1 Groß-/ und 1 Kleinbuchstabe, min. ein Sonderzeichen)");
    }

    public static boolean isPasswordValid(String passwordCheck) {
        String[] forbiddenWords = {"passwort"};
        boolean valid = true;
        if (passwordCheck.equals(forbiddenWords)) {
            print("Passwort ungültig, nicht sicher genug.");
            valid = false;
        } else if (passwordCheck.length() < 8) { // atleast 8 characters
            print("Passwort ungültig, zu kurz.");
            valid = false;
        } else if (!passwordCheck.matches(".*\\d.*")) { // atleast 1 Digit
            print("Passwort ungültig, mindestens eine Zahl.");
            valid = false;
        } else if (!passwordCheck.matches(".*\\D.*")) { // atleast 1 Letter
            print("Passwort ungültig, mindestens ein Buchstabe.");
            valid = false;
        } else if (!passwordCheck.matches(".*\\W.*")) { // atleast 1 non-char
            print("Passwort ungültig, mindestens ein Sonderzeichen.");
            valid = false;
        }
        return valid;
    }

    public static void checkPassword(String passwordSaved) {
        boolean passwordValid = isPasswordValid(passwordSaved);
        Scanner scanner = new Scanner(System.in);
        if (passwordValid) {
            print("Bitte Passwort zur Bestätigung erneut eingeben!");
            String passwordCheck = scanner.next();
            int i = 1;


            while (passwordSaved.equals(passwordCheck) && i < 3) {
                print("Falsches Passwort... Bitte erneut bestätigen!");
                passwordCheck = scanner.next();
                i++;
            }
            if (passwordSaved.equals(passwordCheck)) {
                print("Eingabe korrekt. Viel Spaß und bis dann.");
            } else {
                print("Passwort zu oft falsch bestätigt!");
                print("Bitte ein anderes Mal probieren!");
            }
        } else {
            print("Passwort ungültig, bitte Validierung neu starten.");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Scanner passwordInput = new Scanner(System.in);
        initPasswordvalidation();
        String passwordSaved = passwordInput.next();
        checkPassword(passwordSaved);
    }
}