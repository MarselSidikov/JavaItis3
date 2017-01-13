package ru.itis;

public class Product {
    // статус продукта - готовность
    private boolean status = false;

    // готовность
    public boolean isReady() {
        return status;
    }

    // использован
    public boolean isUsed() {
        return !status;
    }

    // подготовить к использованию
    public void produce() {
        this.status = true;
    }

    // использовали продукт
    public void use() {
        // using
        this.status = false;
    }
}
