package programmers.level2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by HK on 2018-04-19.
 */
public class ProductMatrix {

    private final Logger logger = LoggerFactory.getLogger(ProductMatrix.class);

    public int[][] productMatrix(int[][] A, int[][] B) {


        int[][] answer = new int[A.length][B.length];

        for (int i = 1; i < A[i].length; i++) {

            int first = 0;
            if (i == 1) {
                first += A[i - 1][i - 1] * A[i-1][i];
            } else {
                first = first * A[i][i];
            }

            int seond = 0;
            for (int j = 1; j < B[i].length; j++) {
                if (j == 1) {
                    seond += B[i-1][j - 1] * B[i-1][j-1];
                } else {
                    seond = seond * B[i][j];
                }

                answer[i-1][i] = seond;
            }

            answer[i-1][i-1] = first;


            System.out.println("first : " + first);
            System.out.println("seond : " + seond);


        }




        return answer;
    }

    public int[][] solution(int[][] A, int[][] B) {




        int[][] result = new int[A.length][B.length];



        for (int i = 0; i < A.length; i ++) {

            for (int j= 0; j < B[0].length; j++) {
                //logger.info("## I : {} - {}, J : {} - {}", i ,A[i], j, B[j]);

                for (int k = 0; k < B.length; k++) {
                    result[i][j] = A[i][k] * B[k][j];
                }


            }


        }


        for (int i = 0; i < result.length; i++) {
            logger.info(Arrays.toString(result[i]));
        }


        return result;
    }

    public static void main(String[] args) {
        ProductMatrix c = new ProductMatrix();
//        int[][] a = {{2}, {5}, {10}, {8}, {4}};
//        int[][] b = {{7}};

        int [][] a = {{1,2,},{3,4}};
        int [][] b = {{3,4,},{5,6}};

//        System.out.println(a.length);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i].length);
//        }
        // 아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println("행렬의 곱셈 : " + Arrays.toString(c.solution(a, b)));
    }

}
