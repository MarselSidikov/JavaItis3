package ru.itis.abstracts;

public abstract class Transport {
    private String type;

    public Transport(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void go();
}
