package ru.itis.dao;

public class Main {
    public static void main(String[] args) {
        UsersService service = new UsersService(new UsersDaoFakeImpl());
        System.out.println(service.isRegistered("Marsel"));
        System.out.println(service.isRegistered("Nastya"));
        System.out.println(service.isRegistered("Vanya"));
    }
}
