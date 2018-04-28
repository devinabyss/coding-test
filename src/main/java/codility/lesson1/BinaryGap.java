package codility.lesson1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
 * For example,
 * Number 9 has binary representation 1001 and contains a binary gap of length 2.
 * The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
 * The number 20 has binary representation 10100 and contains one binary gap of length 1.
 * The number 15 has binary representation 1111 and has no binary gaps.
 * Created by HK on 2018-04-11.
 * <p>
 * Result : https://app.codility.com/demo/results/trainingM8FWX6-GKR/
 */
public class BinaryGap {

    private static final Logger logger = LoggerFactory.getLogger(BinaryGap.class);

    public int solution(int number) {

        String binary = Integer.toBinaryString(number);

        System.out.println("Decimal : " + number + ", Binary : " + binary);

        Integer index1 = null;
        Integer index2 = null;
        Integer maxGap = null;


        for (int i = 0; i < binary.length(); i++) {
            char str = binary.charAt(i);
            if (str == 49) {
                if (Optional.ofNullable(index1).isPresent()) {
                    index2 = i;
                } else {
                    index1 = i;
                }

                if (Optional.ofNullable(index1).isPresent() && Optional.ofNullable(index2).isPresent()) {
                    Integer currentGap = index2 - index1 - 1;
                    if (currentGap > Optional.ofNullable(maxGap).orElse(0)) {
                        maxGap = currentGap;
                    }
                    System.out.println("Index1 : " + index1 + ", Index2 : " + index2 + ", Gap : " + maxGap);
                    index1 = index2;
                    index2 = null;
                }
            }
        }
        return Optional.ofNullable(maxGap).orElse(0);
    }


    public static void main(String[] args) {
        Integer[] numbers = {1041, 15, 1001, 529};

        BinaryGap binaryGap = new BinaryGap();

        for (Integer n : numbers) {
            Integer gap = binaryGap.solution(n);
            logger.info("## Binary Gap : {}", gap);
        }
    }
}
