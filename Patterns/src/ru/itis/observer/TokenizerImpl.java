package ru.itis.observer;

public class TokenizerImpl implements Tokenizer, TokenizerObservable {
    private static final int MAX_OBSERVERS = 5;

    private TokenizerObserver[] observers;
    private int countOfObservers;

    public TokenizerImpl() {
        this.observers = new TokenizerObserver[MAX_OBSERVERS];
        this.countOfObservers = 0;
    }

    @Override
    public void tokenize(String text) {
        char[] textAsCharArray = text.toCharArray();

        for (int i = 0; i < textAsCharArray.length; i++) {
            notifyObservers(textAsCharArray[i]);
        }
    }

    @Override
    public void addObserver(TokenizerObserver observer) {
        if (countOfObservers < MAX_OBSERVERS) {
            this.observers[countOfObservers] = observer;
            countOfObservers++;
        } else System.out.println("Observers is full");
    }

    @Override
    public void notifyObservers(char character) {
        for (int i = 0; i < countOfObservers; i++) {
            observers[i].handleCharacter(character);
        }
    }
}
