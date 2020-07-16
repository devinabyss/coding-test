package codetest.baekjun.level5.p2446;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(star(number, i)).append("\n");
        }


        for (int i = number -2; i >= 0; i--) {
            sb.append(star(number, i)).append("\n");
        }


        System.out.println(sb.toString());
    }

    public static String star(int number, int space) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number; i++) {
            sb.append(space <= i ? "*" : " ");//.append(sb.toString().Stirn)


        }

        for (int i=0; i< number - 1; i++){
            sb.append(number - space - 1> i ? "*" : "");
        }


        return sb.toString();
    }
}
