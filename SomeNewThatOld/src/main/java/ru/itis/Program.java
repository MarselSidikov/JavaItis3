package ru.itis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        // карта, словарь, ассоциативный массив
        Map<String, Integer> map;

        // восходящее преобразование:
        // смена типа объектной переменной типа класса-потомка
        // к типу класса-предка
        map = new HashMap<String, Integer>();

        /**
         * Хеш-функция - X -> Y. При этом могут быть коллизии
         * Хотим положить в HashMap пару <K, V>
         * h = h(K) - посчитали хэш-функцию ключа (вызвали у K функцию hashCode())
         * h* - урезание h до размеров таблицы (по умолчанию 16 корзин)
         * h* - номер списка в который мы должны положить пару <K,V>
         * 1) Если список под индексом h* - пустой, просто кладем пару <K,V>
         * 2) Если там уже есть элементы:
         *  Идем по всем элементам списка и сравниванием по hashCode
         *  Если у элемента K*,V* хэш-код совпал с K,V - проверяем по equals K* и K
         *  Если equals - true, заменяем K* и V* на K,V
         *  Если equals - false, добавляем K,V в список.
         */
        map.put("Marsel", 22);
        map.put("Alexey", 24);
        map.put("Evgeniy", 44);

        System.out.println(map.get("Alexey"));

        // entries - это переменная, которая содержит множество ключей-значений
        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        for(Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }
}
