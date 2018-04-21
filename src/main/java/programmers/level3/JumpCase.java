package programmers.level3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by HK on 2018-04-12.
 */
public class JumpCase {
    private static final Logger logger = LoggerFactory.getLogger(JumpCase.class);

    public int jumpCase(int num) {

        return num < 2 ? 1 : jumpCase(num-1) + jumpCase(num-2);

    }

    public static void main(String[] args) {
        JumpCase c = new JumpCase();
        int[] testCase = {4, 5, 6, 21};
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        Arrays.stream(testCase).forEach(tc -> {
            System.out.println(c.jumpCase(tc));
        });

    }
}
