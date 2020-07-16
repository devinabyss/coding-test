package codetest.baekjun.math1.p1712;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String source = scanner.nextLine();//"1000 70 170";

        int[] values = Arrays.stream(source.split("\\s")).mapToInt(Integer::parseInt).toArray();

        int cha = values[2] - values[1];
        boolean benefitable = cha > 0;

        System.out.println(benefitable ? values[0] / cha + 1 : -1);


    }
}
