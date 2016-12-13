package ru.itis.builder;

public class Human {

    private String name;
    private int age;
    private char sex;
    private String nation;
    private boolean isMongol;
    private boolean isCrocodile;

    private Human(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
        this.nation = builder.nation;
        this.isMongol = builder.isMongol;
        this.isCrocodile = builder.isCrocodile;

    }

    public static class Builder {
        private String name;
        private int age;
        private char sex;
        private String nation;
        private boolean isMongol;
        private boolean isCrocodile;

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder age(int value) {
            this.age = value;
            return this;
        }

        public Builder sex(char value) {
            this.sex = value;
            return this;
        }

        public Builder nation(String value) {
            this.nation = value;
            return this;
        }

        public Builder isMongol(boolean value) {
            this.isMongol = value;
            return this;
        }

        public Builder isCrocodile(boolean value) {
            this.isCrocodile = value;
            return this;
        }

        public Human build() {
            return new Human(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

    public String getNation() {
        return nation;
    }

    public boolean isMongol() {
        return isMongol;
    }

    public boolean isCrocodile() {
        return isCrocodile;
    }
}
