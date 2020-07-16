package codetest.codility.lesson4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MissingInteger {

    private static final Logger logger = LoggerFactory.getLogger(MissingInteger.class);

    public int solution(int[] A) {

//        List<Integer> removed = Arrays.stream(A).filter(num -> num >= 0).distinct()
//                .boxed().collect(Collectors.toList());
//
//        Collections.sort(removed);

        //AtomicInteger min = new AtomicInteger(1);
        //Arrays.sort(A);

        int min = 1;
        for (int i = 0; i < A.length; i++) {
            int cur = A[i];

            if (min < cur) {
                break;
            }

            if (cur == min) {
                min++;
            }
        }
        return min;

    }

    public static void main(String[] args) {

        int[] input = {-1, -3, 1, 3, 6, 4, 1, 2};

        MissingInteger missingInteger = new MissingInteger();
        int result = missingInteger.solution(input);

        logger.info("## Result : {}", result);


    }
}
