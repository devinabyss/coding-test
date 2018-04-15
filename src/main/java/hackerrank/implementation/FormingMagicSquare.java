package hackerrank.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by HK on 2018-04-15.
 */
public class FormingMagicSquare {

    static int formingMagicSquare(int[][] s) {
        // Complete this function

        int magicNumber = 15;

//        Map<Integer, Integer> horizon = new HashMap<>();
//        Map<>

        List<Integer> horizon = new ArrayList<>();
        List<Integer> vertical = new ArrayList<>();


        // horizonal check
        for (int i = 0; i < 3; i++) {

            if (Arrays.stream(s[i]).sum() == magicNumber) {
                continue;
            }

            horizon.add(i);
        }


        for (int i = 0; i < 3; i++) {
            if (s[i][i] + s[i + 1][i] + s[i + 2][i] == magicNumber) {
                continue;

            }
            vertical.add(i);
        }

        return 0;

    }


    public static void main(String[] args) {
        Random random = new Random();
        int[][] s = new int[3][3];
        for (int s_i = 0; s_i < 3; s_i++) {
            for (int s_j = 0; s_j < 3; s_j++) {
                s[s_i][s_j] = random.nextInt(10);
            }
        }
        int result = formingMagicSquare(s);
        System.out.println(result);
        //in.close();
    }
}
