package codetest.baekjun.math1.p1193;

import java.util.Scanner;

public class Main {


    public static int sumOfNumber(int input) {
        if (input <= 1)
            return input;

        if (input % 2 == 0)
            return (input + 1) * (input / 2);

        return sumOfNumber(input - 1) + input;
    }

    public static String solve(int input) {

        int prevSum = 1;
        int currentSum = 1;
        int curIt = 0;

        for (int i = 0; currentSum < input; i++) {
            curIt = i;
            prevSum = currentSum;
            currentSum = sumOfNumber(i);
        }

        int minusValue = input - prevSum;
        boolean isOdd = curIt % 2 == 0;

        int child = isOdd ? 0 : curIt + 1;
        int mother = isOdd ? curIt + 1 : 0;

        for (int i = 1; i <= minusValue; i++) {
            if (isOdd) {
                mother--;
                child++;
            } else {
                mother++;
                child--;
            }
        }

        return child + "/" + mother;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(solve(input));
    }
}
