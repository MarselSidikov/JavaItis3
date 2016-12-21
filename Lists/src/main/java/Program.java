import ru.itis.lists.LinkedList;
import ru.itis.sort.LinkedListMergeSorter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Program {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<Integer>();

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(128));
        }
        LinkedList<Integer> result = LinkedListMergeSorter.sort(list);
        for (int current: result) {
            System.out.print(current + " ");
        }

        String[] words =
                {"desoxyribonucleoprotein",
                "magnetohydrodynamically",
                "antimaterialistically",
                "magnetothermoelectricity",
                "overintellectualization",
                "antiutilitarianism",
                "interdenominationalism",
                "trinitrophenylmethylnitramine",
                "anatomicopathological",
                "poliencephalomyelitis",
                "deoxyribonucleoprotein",
                "bioelectrogenetically",
                "cyclotrimethylenetrinitramine",
                "electrophysiologically",
                "dicyclopentadienyliron",
                "chorioepitheliomata",
                "disestablishmentarianism",
                "phenylethylmalonylurea",
                "polytetrafluoroethylene",
                "aerobacteriologically",
                "triacetyloleandomycin",
                "electrocardiographically",
                "overindividualization"};

        LinkedList<String> listOfWords = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            listOfWords.add(words[i]);
        }

        LinkedList<String> sortedListOfWords = LinkedListMergeSorter.sort(listOfWords);
        for (String current: sortedListOfWords) {
            System.out.println(current + " ");
        }

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        sortedListOfWords = LinkedListMergeSorter.sort(sortedListOfWords, stringComparator);

        for (String current: sortedListOfWords) {
            System.out.println(current + " ");
        }

    }
}
