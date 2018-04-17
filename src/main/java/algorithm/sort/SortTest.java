package algorithm.sort;

import algorithm.sort.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTest {

    private static SecureRandom random = new SecureRandom();

    private static Logger logger = LoggerFactory.getLogger(SortTest.class);

    public static void main(String[] args) {

        Sort bubble = new BubbleSort();
        Sort selection = new SelectionSort();
        Sort insertion = new InsertionSort();
        Sort merge = new MergeSort();
        Sort quick = new QuickSort();

        List<Sort> algorithms = new ArrayList<>();
        // algorithms.add(bubble);
        // algorithms.add(selection);
        // algorithms.add(insertion);
        // algorithms.add(merge);
        algorithms.add(quick);

        int[] param = {5, 2, 7, 8, 3, 6, 9, 4};

        customTest(algorithms, param);

        // simpleSortTest(algorithms);

        // hardSortTest(algorithms);

        // for (int i = 0; i < 100; i++) {
        // logger.info("RANDOM : {}", random.nextInt(0));
        // }

    }

    private static void customTest(List<Sort> algorithms, int[] param) {
        for (Sort algorithm : algorithms) {
            String name = algorithm.getClass().getSimpleName();
            logger.info("## {} Sort Algorithm Custom Test Start ##", name);

            logger.info("Param : {}", param);
            algorithm.sort(param);
            logger.info("Result : {}", param);

            logger.info("## {} Sort Algorithm Custom Test End ##\n\n", name);
        }
    }

    private static void simpleSortTest(List<Sort> algorithms) {

        for (Sort algorithm : algorithms) {
            String name = algorithm.getClass().getSimpleName();
            logger.info("## {} Sort Algorithm Simple Test Start ##", name);

            for (int i = 0; i < 10; i++) {
                int size = 20;
                int[] param = new int[size];
                for (int j = 0; j < size; j++) {
                    param[j] = random.nextInt(1000);
                }
                logger.info("Param : {}", param);
                algorithm.sort(param);
                logger.info("Result : {}\n", param);

            }

            logger.info("## {} Sort Algorithm Simple Test End ##\n\n", name);
        }
    }

    private static void hardSortTest(List<Sort> algorithms) {

        int size = 100000000;
        int[] param = new int[size];
        for (int i = 0; i < size; i++) {
            param[i] = random.nextInt(1000);
        }

        for (Sort algorithm : algorithms) {
            String name = algorithm.getClass().getSimpleName();
            logger.info("## {} Sort Algorithm Hard Test Start ##", name);

            // for (int i = 0; i < 10; i++) {

            int[] copy = Arrays.copyOf(param, size);

            // logger.info("PARAM : {}", copy);

            algorithm.sort(copy);

            // }

            logger.info("## {} Sort Algorithm Hard Test End ##\n", name);
        }

        for (Sort algorithm : algorithms) {
            String name = algorithm.getClass().getSimpleName();
            logger.info("## {} Sort Algorithm Hard Test 2 Start ##", name);

            // for (int i = 0; i < 10; i++) {

            int[] copy = Arrays.copyOf(param, size);

            // logger.info("PARAM : {}", copy);

            algorithm.sort(copy);

            // }

            logger.info("## {} Sort Algorithm Hard Test 2 End ##\n", name);
        }
    }

}
