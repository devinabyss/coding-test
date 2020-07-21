package codetest.baekjun.level5.p2523;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < number; i++) {
            sb.append(star(i)).append("\n");
        }

        for (int i = number; i >= 0; i--) {
            sb.append(star(i)).append("\n");
        }
        String result = sb.toString();

        System.out.println(result.trim());

    }

    public static String star(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}
