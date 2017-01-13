package ru.itis.example.messages;


public class CustomMessage implements Message {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
