package ru.itis;

public class Main {
    public static void main(String[] args) {
        Runnable showNumbersTask = new TaskShowNumbers();

        Runnable showLettersATask = new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + "A");
                }
            }
        };

        Runnable showLettersBTask = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + " " + "B");
            }
        };

        WorkQueue workQueue = new WorkQueue(2);

        workQueue.execute(showNumbersTask);
        workQueue.execute(showLettersATask);
        workQueue.execute(showLettersBTask);
    }
}
