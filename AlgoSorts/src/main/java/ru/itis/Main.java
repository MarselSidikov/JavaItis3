package ru.itis;

import ru.itis.sort.Sorter;
import ru.itis.sort.SorterMergeImpl;

public class Main {
    public static void main(String[] args) {
        int array[] = {4, -10, 11, 45, 0, -23, 35, 62, 11, 0, -9, 11, -3, 4, 5, 1};



        Sorter sorter = new SorterMergeImpl();

        sorter.sort(array);

        //Sorter sorter = new SorterHeapImpl();

        //sorter.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
        }
    }
}
