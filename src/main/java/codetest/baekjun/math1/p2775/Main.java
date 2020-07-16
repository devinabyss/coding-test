package codetest.baekjun.math1.p2775;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Long> cache = new HashMap<>();

    private static long[][] arr = new long[25][25];

    public static long recursiveWithCacheArray(int floor, int number) {
        if (number == 1)
            return 1;

        if (floor == 0)
            return number;

        if (arr[floor][number] == 0) {
            arr[floor][number] = recursiveWithCacheArray(floor, number - 1) + recursiveWithCacheArray(floor - 1, number);
        }

        return arr[floor][number];
    }

    public static long recursiveWithCacheMap(int floor, int number) {
        if (number == 1)
            return 1;

        if (floor == 0)
            return number;

        Couple couple = new Couple(floor, number);
        if (cache.containsKey(couple.hashCode())) {
            return cache.get(couple.hashCode());
        } else {
            long value = recursiveWithCacheMap(floor, number - 1) + recursiveWithCacheMap(floor - 1, number);
            cache.put(couple.hashCode(), value);
            return value;
        }
    }

    public static long recursive(int floor, int number) {
        if (number == 1)
            return 1;

        if (floor == 0)
            return number;

        return recursive(floor, number - 1) + recursive(floor - 1, number);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {

            int floor = Integer.parseInt(scanner.nextLine());
            int number = Integer.parseInt(scanner.nextLine());

            long start = System.currentTimeMillis();
            System.out.println(recursive(floor, number));
            System.out.println("## i : " + i + ", Recursive Execute Time : " + (System.currentTimeMillis() - start));

            long start2 = System.currentTimeMillis();
            System.out.println(recursiveWithCacheArray(floor, number));
            System.out.println("## i : " + i + ", RecursiveWithCacheArray Execute Time : " + (System.currentTimeMillis() - start2));

            long start3 = System.currentTimeMillis();
            System.out.println(recursiveWithCacheMap(floor, number));
            System.out.println("## i : " + i + ", RecursiveWithCacheMap1 Execute Time : " + (System.currentTimeMillis() - start3));
        }

        System.out.println(cache.size());
    }

    public static class Couple {
        private int floor;
        private int number;

        public Couple(int floor, int number) {
            this.floor = floor;
            this.number = number;
        }

        public String toString() {
            return "# Floor : " + floor + ", # Number : " + number;
        }

        public int hashCode() {
            return ("F" + floor + "N" + number).hashCode();
        }

    }

}
