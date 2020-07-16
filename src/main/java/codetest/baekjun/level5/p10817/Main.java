package codetest.baekjun.level5.p10817;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).sorted().toArray();

        System.out.println(array[1]);

    }
}
