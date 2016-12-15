package ru.itis.generics.token.example;

public class Main {
    public static void main(String[] args) {
        PasswordNumber passwordNumber = new PasswordNumber("passowrd", 99999, 7777);
        Token<PasswordNumber> passwordNumberToken = new Token<PasswordNumber>("99999 77777", 12, 19, passwordNumber);

        Digits digits = new Digits("digits", 123);
        Token<Digits> digitsToken = new Token<Digits>("123", 27, 30, digits);
        digitsToken.getType().getTypeName();

        // Token<String> token;
    }
}
