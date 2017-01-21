package ru.itis;

import java.util.Scanner;

/**
 * 22.11.16
 * Program
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Program {
    public static void main(String[] args) {
        // создаем экземпляр service
        ClientMessagesService service = new ClientMessagesService();
        // запускаем процесс обработки сообщений
        service.messagesProcessing();
    }
}
