package ru.itis;

import static ru.itis.VolatileExample.MY_INT;

public class ChangeListener extends Thread {
    public void run() {
        // делаем копию МАЙ_ИНТ
        int localValue = MY_INT;
        // пока лок_знач меньше пяти
        while (localValue < 5) {
            // лок_знач если не равно МАЙ_ИНТ
            if (localValue != MY_INT) {
                // ИЗМЕНИЛСЯ МАЙ_ИНТ
                System.out.println("Got change for MY_INT: " + MY_INT);
                // лок_знач меняем
                localValue = MY_INT;
            }
        }
    }

}
