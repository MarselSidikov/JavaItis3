package ru.itis.composition;

// Завод
public class Works {

    private Worker worker;

    public Works() {
        worker = new Worker();
    }
    public void createDetailByName(String detailName) {
        worker.createDetailByName(detailName);
    }
}
