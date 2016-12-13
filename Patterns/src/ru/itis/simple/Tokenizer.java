package ru.itis.simple;


public class Tokenizer {
    public void tokenize(String text) {
        char[] textAsCharArray = text.toCharArray();

        for (int i = 0; i < textAsCharArray.length; i++) {
            if (Character.isDigit(textAsCharArray[i])) {
                System.out.println("I'm a digit " + textAsCharArray[i]);
                int currentNumber = Integer.parseInt(textAsCharArray[i] + "");
                if (currentNumber % 2 == 0) {
                    System.out.println((currentNumber / 2));
                } else {
                    System.out.println("Not even " + textAsCharArray[i]);
                }
            } else if (Character.isLowerCase(textAsCharArray[i])) {
                System.out.println("is Lower " + textAsCharArray[i]);
            }
        }
    }
}
