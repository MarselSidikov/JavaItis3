package ru.itis.runnable;

/**
 * Created by ZheLe on 10.01.2017.
 */
public class Program {
    public static void main(String[] args) {
        Thread thread = new Thread(new SimpleRunnableImpl());
        thread.start();
    }
}
