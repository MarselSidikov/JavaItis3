package ru.itis.observer;

public interface TokenizerObservable {
    void addObserver(TokenizerObserver observer);
    void notifyObservers(char character);
}
