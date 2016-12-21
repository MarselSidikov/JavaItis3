package ru.itis.sort;

import ru.itis.lists.LinkedList;

import java.util.Iterator;

public class LinkedListMergeSorter {
    // максимальное количество корзин
    private static final int MAX_BUCKETS_COUNT = 32;

    // вложенный класс - корзина
    private static class Bucket {
        // связный список корзины
        LinkedList list;
        // ранг корзины - количество элементов в списке
        int rank;

        Bucket() {
            list = new LinkedList();
            rank = 0;
        }
    }

    // массив корзин
    private static Bucket[] buckets;
    // количество реально используемых корзин
    private static int bucketsCount;

    static {
        // создаем массив корзин
        buckets = new Bucket[MAX_BUCKETS_COUNT];
        // инициализируем каждую корзину
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
        // в начальный момент времени корзины не используются
        bucketsCount = 0;
    }

    // слияние двух упорядоченных списков в один упорядечнный
    public static LinkedList merge(LinkedList firstList, LinkedList secondList) {
        // создаем список для результата
        LinkedList result = new LinkedList();

        // получили итератор первого списка
        Iterator<Integer> i = firstList.iterator();
        // получили итератор второго списка
        Iterator<Integer> j = secondList.iterator();
        // получили первый элемент первого списка
        int iValue = i.next();
        // получили первый элемент второго списка
        int jValue = j.next();
        // пока в обоих списках есть элементы
        do {
            // если элемент первого списка меньше элемента второго
            if (iValue < jValue) {
                // добавляем его в результат
                result.add(iValue);
                // идем по первому списку дальше

                if (i.hasNext()) {
                    iValue = i.next();
                }
                // если элементы одного из списков кончились
                else {
                    // добавляем элемент из второго
                    result.add(jValue);
                    // останавливаем цикл
                    break;
                }
            }
            // в противном случае
            else {
                // добавляем элемент второго списка
                result.add(jValue);
                // идем по второму дальше
                if (j.hasNext()) {
                    jValue = j.next();
                } else {
                    result.add(iValue);
                    break;
                }
            }
        } while (true);

        // если в первом списке остались элементы, значит они гарантированно
        // больше элементов второго
        while(i.hasNext()) {
            // добавляем их
            result.add(i.next());
        }

        // аналогично по второму
        while (j.hasNext()) {
            result.add(j.next());
        }

        return result;
    }

    public static LinkedList sort(LinkedList list) {
        // каждое значение списка кладем в корзины
        for (Integer value : list) {
            putToBuckets(value);
        }
        // слививаем оставшиеся корзины
        processRemainsBuckets();
        // возвращаем первую корзину с отсортированным списком
        return buckets[0].list;
    }

    // процедура кладет в коризны значение
    private static void putToBuckets(int value) {
        // в последний список кладем значение
        buckets[bucketsCount].list.add(value);
        // увеличиваем ранг корзины с последним списком
        buckets[bucketsCount].rank++;
        // увеличиваем количество реально используемых корзин
        bucketsCount++;
        // сливаем корзины
        showBuckets();
        processBuckets();
        showBuckets();
    }

    private static void showBuckets() {
        for (int i = 0; i < bucketsCount; i++) {
            LinkedList currentList = buckets[i].list;
            for (int value : currentList) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }

    // процедура слияния корзин если их ранги совпадают
    private static void processBuckets() {
        // если в списке чет есть
        while (bucketsCount > 1 && isPreparedToProcess()) {
            mergePairListsFromBuckets();
        }
    }

    // слияние оставшихся корзин, независимо от их рангов
    private static void processRemainsBuckets() {
        while (bucketsCount > 1) {
            mergePairListsFromBuckets();
        }
    }

    // слияние корзин
    private static void mergePairListsFromBuckets() {
        // берем последний список
        LinkedList secondList = buckets[bucketsCount - 1].list;
        // берем предпоследний список
        LinkedList firstList = buckets[bucketsCount - 2].list;

        // сливаем
        buckets[bucketsCount - 2].list = merge(firstList, secondList);
        buckets[bucketsCount - 2].rank = buckets[bucketsCount - 2].list.getCount();
        buckets[bucketsCount - 1].list = new LinkedList();
        buckets[bucketsCount - 1].rank = 0;
        bucketsCount--;
    }
    private static boolean isPreparedToProcess() {
        return buckets[bucketsCount - 1].rank == buckets[bucketsCount - 2].rank;
    }
}
