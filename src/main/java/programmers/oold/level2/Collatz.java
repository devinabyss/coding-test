package programmers.oold.level2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by HK on 2018-04-19.
 */
public class Collatz {

    private final Logger logger = LoggerFactory.getLogger(Collatz.class);

    public int collatz(int num) {
        int answer = -1;
        for (int i = 0; i < 500; i++) {
            num = collatzProcess(num);
            if (num == 1) {
                return i + 1;
            } else if (num < 0) { // int 범위를 넘어가는 * 결과가 나오면 - . 검사를 계속할 가치가 없음
                return answer;
            }
        }
        return answer;
    }

    private int collatzProcess(int num) {
        if (num % 2 == 0) {
            return num / 2;
        } else {
            return (num * 3) + 1;
        }
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        Collatz c = new Collatz();
        int ex = 704623;
        System.out.println(c.collatz(ex));
    }

}
