package ru.itis.generics.token.example;


public class Token<T extends Type> {
    private String text;
    private int begin;
    private int end;
    private T type;

    public Token(String text, int begin, int end, T type) {
        this.text = text;
        this.begin = begin;
        this.end = end;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public T getType() {
        return type;
    }
}
