package programmers.oold.level3;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by HK on 2018-04-21.
 */
public class NextBigNumber {
    private static final Logger logger = LoggerFactory.getLogger(NextBigNumber.class);

    public int nextBigNumber2(int n) {

        long countOfOne = countOfOne(n);

        int answer = 0;
        for (int i = n + 1; answer == 0; i++) {
            long currentCountOfOne = countOfOne(i);
            if (currentCountOfOne == countOfOne) {
                answer = i;
            }
        }
        return answer;
    }

    public long countOfOne(int n) {
        String str = Integer.toBinaryString(n);
        long countOfOne = str.chars().filter(ch -> ch == 49).count();
        return countOfOne;
    }

    public int nextBigNumber(int n) {

        int countOfOne = Integer.bitCount(n);

        int answer = 0;
        for (int i = n + 1; answer == 0; i++) {
            int currentCountOfOne = Integer.bitCount(i);
            if (currentCountOfOne == countOfOne) {
                answer = i;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        NextBigNumber test = new NextBigNumber();
        int n = 78;
        System.out.println(test.nextBigNumber(n));
    }
}
