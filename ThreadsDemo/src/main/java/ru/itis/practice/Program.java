package ru.itis.practice;

public class Program {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("Bye");
                }
            }
        };

        BestThread thread = new BestThread(task);
    }
}
