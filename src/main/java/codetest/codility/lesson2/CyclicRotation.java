package codetest.codility.lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * Created by HK on 2018-04-11.
 *
 * https://app.codility.com/demo/results/trainingYY625P-W6K/
 */
public class CyclicRotation {

    public int[] solution(int[] array, int k) {

        int length = array.length;

        // Runtime Error Case. Zero Divide Problem.
        if (length == 0) {
            return array;
        }

        int mid = length / 2;

        int realK = k % length;
        int gap = length - realK;

        int count = mid > gap ? gap : realK;
        Direction direction = mid > gap ? Direction.LEFT : Direction.RIGHT;

        System.out.println("Real K : " + realK + ", length : " + length + ", mid : " + mid + ", gap : " + gap + ", count : " + count + ", Direction : " + direction);

        for (int i = 0; i < count; i++) {
            switch (direction) {
                case RIGHT:
                    array = right(array);
                    break;

                default:
                    array = left(array);
                    break;
            }
        }

        return array;
    }

    private enum Direction {
        RIGHT,
        LEFT
    }


    private int[] right(int[] array) {
        int last = array[array.length - 1];
        int[] copied = Arrays.copyOfRange(array, 0, array.length - 1);
        List<Integer> copedList = Arrays.stream(copied).boxed().collect(Collectors.toList());

        List<Integer> list = new ArrayList<>();
        list.add(last);
        list.addAll(copedList);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private int[] left(int[] array) {
        int first = array[0];
        int[] copied = Arrays.copyOfRange(array, 1, array.length);
        List<Integer> copiedList = Arrays.stream(copied).boxed().collect(Collectors.toList());
        copiedList.add(first);
        return copiedList.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        CyclicRotation rotation = new CyclicRotation();

        int[] array = {1, 2, 3, 4};
        System.out.println(Arrays.toString(rotation.solution(new int[]{}, 3)));
        System.out.println(Arrays.toString(rotation.solution(array, 63)));
    }
}