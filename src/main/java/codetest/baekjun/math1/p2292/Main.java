package codetest.baekjun.math1.p2292;

import java.util.Scanner;

public class Main {

    public static int soleve(int input) {

        int max = 1;
        int move = 0;
        int edge = 6;
        int append = 1;
        int acumulated = 0;

        for (int i = 0; max <= input; i++) {
            acumulated += i;
            int curMax = Math.max(acumulated * edge, 1) + append; // layer max value
            //int curCount = i == 0 ? append : i * edge; // layer total count
            int innerMove = (curMax - input) % ((i == 0) ? 1 : i);

            move = i + innerMove + (i == 0 ? 0 : append);
            max = curMax;
            //System.out.println(input + " " + curMax + " " + innerMove + " " + move + " " + max);
        }

        return move;
    }

    public static int solve(int input) {

        int max = 0;
        int count = 0;
        for (int i = count; input > max; i++) {
            max = max(i);
            count++;
        }

        return count;
    }

    public static int max(int a) {
        if (a == 0)
            return 1;
        else
            return max(a - 1) + a * 6;
    }


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        System.out.println(solve(input));

//        int[] inputs = new int[]{13, 25, 58};
//
//        for(int input : inputs) {
//            System.out.println(solve(input));
//        }

    }
}
