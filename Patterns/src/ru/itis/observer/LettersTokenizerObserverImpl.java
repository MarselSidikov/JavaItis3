package ru.itis.observer;

public class LettersTokenizerObserverImpl implements TokenizerObserver {
    @Override
    public void handleCharacter(char character) {
        if (Character.isLowerCase(character)) {
            System.out.println("Is lower " + character);
        }
    }
}
