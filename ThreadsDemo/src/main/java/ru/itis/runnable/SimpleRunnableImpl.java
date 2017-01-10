package ru.itis.runnable;

public class SimpleRunnableImpl implements Runnable {
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Hello");
        }
    }
}
