package ru.itis.sort;

import ru.itis.lists.LinkedList;

import java.util.Comparator;
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
        goToStartState();
    }

    public static <T extends Comparable<? super T>> LinkedList<T> sort(LinkedList<T> list) {
        return sort(list, null);
    }

    private static void goToStartState() {
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
    private static <T extends Comparable<? super T>> LinkedList<T> merge(LinkedList<T> firstList, LinkedList<T> secondList, Comparator<T> comparator) {
        // создаем список для результата
        LinkedList<T> result = new LinkedList<>();

        // получили итератор первого списка
        Iterator<T> i = firstList.iterator();
        // получили итератор второго списка
        Iterator<T> j = secondList.iterator();
        // получили первый элемент первого списка
        T iValue = i.next();
        // получили первый элемент второго списка
        T jValue = j.next();
        // пока в обоих списках есть элементы
        do {
            // если элемент первого списка меньше элемента второго
            boolean iValueLessJValue = false;
            if (comparator == null) {
                iValueLessJValue = iValue.compareTo(jValue) < 0;
            } else {
                iValueLessJValue = comparator.compare(iValue, jValue) < 0;
            }
            if (iValueLessJValue) {
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

    // Параметр T должен быть сравниваемым Comparable
    // Сам Comparable должен уметь сравнивать все объекты-пердки T
    public static <T extends Comparable<? super T>> LinkedList<T> sort(LinkedList<T> list, Comparator<T> comparator) {
        // каждое значение списка кладем в корзины
        for (Object value : list) {
            putToBuckets(value, comparator);
        }
        // слививаем оставшиеся корзины
        processRemainsBuckets(comparator);
        // возвращаем первую корзину с отсортированным списком
        LinkedList<T> temp = buckets[0].list;
        goToStartState();
        return temp;
    }

    // процедура кладет в коризны значение
    private static <T> void putToBuckets(Object value, Comparator<T> comparator) {
        // в последний список кладем значение
        buckets[bucketsCount].list.add(value);
        // увеличиваем ранг корзины с последним списком
        buckets[bucketsCount].rank++;
        // увеличиваем количество реально используемых корзин
        bucketsCount++;
        // сливаем корзины
        showBuckets();
        processBuckets(comparator);
        showBuckets();
    }

    private static void showBuckets() {
        for (int i = 0; i < bucketsCount; i++) {
            LinkedList currentList = buckets[i].list;
            for (Object value : currentList) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }

    // процедура слияния корзин если их ранги совпадают
    private static void processBuckets(Comparator comparator) {
        // если в списке чет есть
        while (bucketsCount > 1 && isPreparedToProcess()) {
            mergePairListsFromBuckets(comparator);
        }
    }

    // слияние оставшихся корзин, независимо от их рангов
    private static void processRemainsBuckets(Comparator comparator) {
        while (bucketsCount > 1) {
            mergePairListsFromBuckets(comparator);
        }
    }

    // слияние корзин
    private static void mergePairListsFromBuckets(Comparator comparator) {
        // берем последний список
        LinkedList secondList = buckets[bucketsCount - 1].list;
        // берем предпоследний список
        LinkedList firstList = buckets[bucketsCount - 2].list;

        // сливаем
        buckets[bucketsCount - 2].list = merge(firstList, secondList, comparator);
        buckets[bucketsCount - 2].rank = buckets[bucketsCount - 2].list.getCount();
        buckets[bucketsCount - 1].list = new LinkedList();
        buckets[bucketsCount - 1].rank = 0;
        bucketsCount--;
    }
    private static boolean isPreparedToProcess() {
        return buckets[bucketsCount - 1].rank == buckets[bucketsCount - 2].rank;
    }
}
