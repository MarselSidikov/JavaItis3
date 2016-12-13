package ru.itis.observer;

public class TokenizerObserverDigitsImpl implements TokenizerObserver {
    @Override
    public void handleCharacter(char character) {
        if (Character.isDigit(character)) {
            System.out.println("I'm digit " + character);
        }
    }
}
