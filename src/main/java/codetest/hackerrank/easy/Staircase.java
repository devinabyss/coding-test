package codetest.hackerrank.easy;

/**
 * Created by HK on 2018-04-21.
 */
public class Staircase {

    static void staircase(int n) {

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < n - i; j++) {
                sb.append(" ");
            }

            for (int k = 1; k <= i; k++) {
                sb.append("#");
            }

            if (i != n) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int n = 6;

        staircase(n);
    }

}
