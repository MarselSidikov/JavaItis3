package ru.itis;

public class Main {

    public static void main(String[] args) {
	    Human human = new Human(22, "Marsel", false);
        Human human1 = new Human(22, "Marsel", false);
        System.out.println(human);

        System.out.println(human == human1);

        System.out.println(human.equals(human1));
        System.out.println(human.hashCode());
    }
}
