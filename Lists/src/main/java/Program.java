import ru.itis.lists.LinkedList;
import ru.itis.sort.LinkedListMergeSorter;

import java.util.Random;

public class Program {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(128));
        }

        LinkedList result = LinkedListMergeSorter.sort(list);
        for (int current: result) {
            System.out.print(current + " ");
        }
    }
}
