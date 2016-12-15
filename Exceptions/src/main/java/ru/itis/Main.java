package ru.itis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Лучшая практика по отлову проверяемых исключений:
 * 1) Ни в коем случае не использовать e.printStackTrace (аналогично пустому catch
 * 2) В catch проверяемого исключения выбрасывать непроверяемое
 */
public class Main {

    // Error
    public static void rec() {
        rec();
    }
    public static void main(String[] args) {
        // checked exception - FileNotFoundException
        try {
            InputStream stream = new FileInputStream("text.txt");
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        }

        // unchecked exception - ArithmeticException
        try {
            int i = 1 / 0;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        SomeClass someClass = new SomeClass();
        try {
            someClass.throwCheckedException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // error
        rec();
    }
}
