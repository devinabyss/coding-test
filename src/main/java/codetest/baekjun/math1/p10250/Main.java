package codetest.baekjun.math1.p10250;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    private static final DecimalFormat decimalFormat = new DecimalFormat("00");

    public static String solve(int height, int width, int number) {

        int divided = number / height;
        int rest = number % height; // 층

        int targetHeight = rest == 0 ? height : rest;
        int targetWidth = divided + (rest == 0 ? 0 : 1);

        return targetHeight + decimalFormat.format(targetWidth);

    }

    public static void main(String[] args) {
        // 6 12 10
        // 30 50 72
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0 ; i < count; i++) {
            String[] test = scanner.nextLine().split("\\s");
            System.out.println(solve(Integer.parseInt(test[0]), Integer.parseInt(test[1]), Integer.parseInt(test[2])));
        }

//        int height = 30;
//        int width = 50;
//        int number = 72;
    }
}
