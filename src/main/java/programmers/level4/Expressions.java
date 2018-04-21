package programmers.level4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다
 * https://programmers.co.kr/learn/challenge_codes/40/solutions
 * Created by HK on 2018-04-22.
 */
public class Expressions {

    private static final Logger logger = LoggerFactory.getLogger(Expressions.class);


    public int expressions(int num) {
        int answer = 0;

        for (int i = 1; i <= num; i += 2) {
            if (num % i == 0) {
                answer++;
            }
        }

        return answer;
    }


    public int expressionsLowPerformance(int num) {
        int answer = 0;

        for (int i = 1; i <= num / 2; i++) {

            int temp = 0;
            for (int j = i; temp < num; j++) {
                temp += j;
                if (temp == num) answer++;
                //logger.info("## i : {}, temp : {}", i,temp);

            }
        }
        return answer + 1;
    }

    public static void main(String args[]) {
        Expressions expressions = new Expressions();
        // 아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(expressions.expressions(3941));
    }
}
