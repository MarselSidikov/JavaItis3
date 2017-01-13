package ru.itis.practice;

public class BestThread {
    private Thread targetThread;

    public BestThread(Runnable target) {
        this.targetThread = new Thread(target);
        this.targetThread.start();
    }
}
