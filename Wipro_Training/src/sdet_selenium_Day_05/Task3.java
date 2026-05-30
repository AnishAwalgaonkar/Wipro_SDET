package sdet_selenium_Day_05;

final class SecurityModule {

    public String encrypt(String data) {
        return "ENC(" + data + ")";
    }
}

public class Task3 {
    public static void main(String[] args) {

        SecurityModule sm = new SecurityModule();

        String encrypted = sm.encrypt("Hello");
        System.out.println("Encrypted: " + encrypted);
    }
}
