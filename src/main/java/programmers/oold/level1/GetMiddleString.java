package programmers.oold.level1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by HK on 2018-04-11.
 */
public class GetMiddleString {

    private static final Logger logger = LoggerFactory.getLogger(GetMiddleString.class);

    String getMiddle(String word) {
        int length = word.length();
        int middle = length / 2;
        boolean isEven = length % 2 == 0;
        int start = isEven ? middle - 1 : middle;
        logger.info("Length : {}, Middle : {}, isEven : {}, start : {}", length, middle, isEven, start);

        String result = word.substring(start, middle + 1);
        logger.info("## result : {}", result);

        return result;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        GetMiddleString gms = new GetMiddleString();
        System.out.println(gms.getMiddle("size"));
    }
}
