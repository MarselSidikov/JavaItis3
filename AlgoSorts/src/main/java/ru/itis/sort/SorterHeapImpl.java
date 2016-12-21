package ru.itis.sort;

import ru.itis.sort.Sorter;

public class SorterHeapImpl implements Sorter {

    // размер кучи
    public int heapSize;

    // пирамидальная сортировка
    public void sort(int array[]) {
        // строим кучу
        buildHeap(array);
        // пока куча не пустая
        while (heapSize > 1) {
            // меняем последний с первым
            swap(array, 0, heapSize - 1);
            // уменьшаем размер кучи
            heapSize--;
            // перестраиваем кучу
            heapify(array, 0);
        }
    }
    // N log N
    public void buildHeap(int array[]) {
        // изначально размер кучи - размер массива
        heapSize = array.length;
        // начиная с серединки
        for (int i = array.length / 2; i >= 0; i--) {
            // перестраиваем кучу
            heapify(array, i);
        }
    }

    /**
     *
     * @param array куча
     * @param i узел дерева, для которого нужно выполнить перестроение - родитель
     */
    public void heapify(int[] array, int i) {
        // левый сын
        int left = 2 * i + 1;
        // правый сын
        int right = 2 * i + 2;

        // предполагаем, что родитель - максимальный (largest - индекс максимального)
        int largest = i;

        // если есть левый сын и он больше - то он максимальный
        if (left < heapSize && array[i] < array[left]) {
            largest = left;
        }
        // если есть правый сын и он больше, чем левый либо родитель - то он максимальный
        if (right < heapSize && array[largest] < array[right]) {
            largest = right;
        }

        // если родитель - не максимальный
        if (i != largest) {
            // меняем местами
            swap(array, i, largest);
            // перестраиваем дерево относительно бывшего максимального
            heapify(array, largest);
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
