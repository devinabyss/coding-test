package algorithm.sort.impl;


import algorithm.sort.Sort;

public class BubbleSort extends Sort {
    @Override
    public void sort(int[] array) {
        // array.length -1 의 이유를 알아야 할 듯
        for (int i = 0; i < array.length; i++) {
            // 현재 위치와 현재 위치 +1 의 값을 비교하므로 loop 는 length -1 만큼 실행
            // 상위 루프가 돈 만큼 높은 값들이 후방으로 갔을 것이므로
            // 굳이 더 탐색할 필요가 없이 상위 루프가 돈 만큼 탐색 횟수를 줄임
            for (int j = 0; j < array.length - 1 - i; j++) {

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
