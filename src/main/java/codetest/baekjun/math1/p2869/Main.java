package codetest.baekjun.math1.p2869;

import java.util.Scanner;

public class Main {
    public static int solve(int forward, int back, int instance) {
        int cha = forward - back;
        int lastInstance = instance - forward;
        int divided = lastInstance / cha;
        int rest = lastInstance % cha;
        return rest > 0 ? divided + 2 : divided + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s");
        //Arrays.stream().mapToInt(Integer::parseInt).toArray();

        int forward = Integer.parseInt(input[0]);
        int back = Integer.parseInt(input[1]);
        int instance = Integer.parseInt(input[2]);

        System.out.println(solve(forward, back, instance));
    }
}
