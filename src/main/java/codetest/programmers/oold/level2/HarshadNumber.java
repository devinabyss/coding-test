package codetest.programmers.oold.level2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by HK on 2018-04-19.
 */
public class HarshadNumber {

    private final Logger logger = LoggerFactory.getLogger(HarshadNumber.class);

    public boolean isHarshad(int num) {
        if (num > 10) {
            String str = String.valueOf(num);

            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                Character character = str.charAt(i);
                Integer number = Character.getNumericValue(character);
                sum += number;
            }
            return num % sum == 0;
        }
        return true;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        HarshadNumber sn = new HarshadNumber();
        System.out.println(sn.isHarshad(18));
    }

}
