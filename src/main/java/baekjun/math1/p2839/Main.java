package baekjun.math1.p2839;

import java.util.Scanner;

public class Main {

    public static int solve(int kg) {
        int max5 = kg / 5;
        int rest = kg % 5;

        Integer vinyls = null;
        if (rest == 0)
            return max5;

        for (int i = max5; i >= 0; i--) {

            int target3 = kg - (i * 5);

            if (target3 % 3 == 0) {
                int vinyl3 = target3 / 3;
                vinyls = i + vinyl3;
                break;
            }
        }

        return vinyls == null ? -1 : vinyls;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int kg = scanner.nextInt();
//        for (int i = 4; i <= 50; i++) {
//            System.out.println("i : " + i + ", result : " + solve(i));
//        }

        System.out.println(solve(kg));




    }
}
