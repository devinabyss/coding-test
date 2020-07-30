package codetest.programmers.oold.level2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by HK on 2018-04-18.
 */
public class MakeMinValue {

    private final Logger logger = LoggerFactory.getLogger(MakeMinValue.class);

    public int getMinSum(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int length = A.length;

        // 최소값 * 최대값 ~ 최대값 * 최소값 으로..

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[length - 1 - i];
        }

        return answer;
    }


    public static void main(String[] args) {
        MakeMinValue test = new MakeMinValue();
        int[] A = {1, 2};
        int[] B = {3, 4};
        System.out.println(test.getMinSum(A, B));
    }
}
