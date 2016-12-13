package ru.itis.observer;

public class Main {
    public static void main(String[] args) {
        TokenizerObservable tokenizerObservable = new TokenizerImpl();

        TokenizerObserver digitObserver = new TokenizerObserverDigitsImpl();
        TokenizerObserver lettersObserver = new LettersTokenizerObserverImpl();

        tokenizerObservable.addObserver(digitObserver);
        tokenizerObservable.addObserver(lettersObserver);

        // анонимный класс
        TokenizerObserver anonObserver = new TokenizerObserver() {
            @Override
            public void handleCharacter(char character) {
                System.out.println("I'm on character");
            }
        };

        tokenizerObservable.addObserver(anonObserver);

        // лямбда-выражения
        tokenizerObservable.addObserver((character -> {
            if (character == ' ') {
                System.out.println("I'm on separator");
            }
        }));

        Tokenizer tokenizer = (Tokenizer)tokenizerObservable;
        tokenizer.tokenize("HE 248 he");
    }
}
