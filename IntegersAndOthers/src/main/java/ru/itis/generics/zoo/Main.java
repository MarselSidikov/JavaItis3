package ru.itis.generics.zoo;

public class Main {
    public static void main(String[] args) {
        Cage<HumanAnimal> humanAnimalCage = new Cage<HumanAnimal>();
        HumanAnimal someMadMan = new HumanAnimal();
        humanAnimalCage.add(someMadMan);
    }
}
