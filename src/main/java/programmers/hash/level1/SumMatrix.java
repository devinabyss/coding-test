package programmers.hash.level1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class SumMatrix {

    private static final Logger logger = LoggerFactory.getLogger(SumMatrix.class);

    int[][] sumMatrix(int[][] A, int[][] B) {
        int[][] answer = new int[A.length][A[0].length];


        for (int i =0; i < A.length; i++){

            for (int j = 0; j < A[i].length; j ++) {

                answer[i][j] = A[i][j] + B[i][j];


            }

        }


//
//        for (int i = 0; i < A.length; i++) {
//            for (int j = ; j < B[i].length; j++){
//                for (int k = 0; k < B[j].length; k++) {
//                    logger.info("## I : {} , J : {} , K : {}, A[i] {}, B[j] {}", i,  j , k , A[i][k], B[j][k]);
//                    answer[i][k] = A[i][k] + B[j][k];
//                }
//            }
//        }

        return answer;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        SumMatrix c = new SumMatrix();
//        int[][] A = {{1, 2}, {2, 3}};
//        int[][] B = {{3, 4}, {5, 6}};
        int[][] A = {{10, 3, 9, 6}};
        int[][] B = {{8, 7, 5, 7}};
        int[][] answer = c.sumMatrix(A, B);

        for (int[] anAnswer : answer) {
            logger.info("{}", Arrays.toString(anAnswer));
        }


    }
}