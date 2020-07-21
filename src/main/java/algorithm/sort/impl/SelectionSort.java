package algorithm.sort.impl;


import algorithm.sort.Sort;

public class SelectionSort extends Sort {

    @Override
    public void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {

            int minPos = i;
            int min = array[i];

            for (int j = i + 1; j < array.length; j++) {

                if (min > array[j]) {
                    min = array[j];
                    minPos = j;
                }
            }

            if (minPos != i) {
                int temp = array[i];
                array[i] = array[minPos];
                array[minPos] = temp;
            }

        }

    }

}
