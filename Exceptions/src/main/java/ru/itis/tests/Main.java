package ru.itis.tests;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
       /**
        try {
            InputStream inputStream = new FileInputStream("Hello");
        } catch (Exception e) {
            // 1
        } catch (FileNotFoundException e) {
            // 2
        }
        **/

       try {
           System.out.println("1");
           throw new IllegalArgumentException();
       } catch (IllegalStateException ex) {
           System.out.println("2");
           throw new IOException();
       } catch (Exception ex) {
           System.out.println("3");
           throw new IOException();
       } finally {
           System.out.println("4");
       }

       // System.out.println("5");
    }
}
