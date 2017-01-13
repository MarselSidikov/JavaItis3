package ru.itis;


import static ru.itis.VolatileExample.MY_INT;

public class ChangeMaker extends Thread {
    public void run() {
        // создаем локальное значение переменной MY_INT
        int localValue = MY_INT;
        // пока МАЙ_ИНТ меньше 5
        while (MY_INT < 5) {
            // выдаем сообщение об увеличении МАЙ_ИНТ и при этом выводим лок_знач + 1
            System.out.println("Incrementing MY_INT to " + (localValue + 1));
            // увеличиваем лок_значи на 1 а потом кладем в МАЙ_ИНТ
            MY_INT = ++localValue;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }

    }
}
