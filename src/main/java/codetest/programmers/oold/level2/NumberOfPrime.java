package codetest.programmers.oold.level2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HK on 2018-04-19.
 */
public class NumberOfPrime {

    private final Logger logger = LoggerFactory.getLogger(NumberOfPrime.class);

    int numberOfPrime(int n) {

        List<Integer> primes = new ArrayList<>();

        // 2 는 무조건 소수
        if (n >= 2) {
            primes.add(2);
        }

        for (int i = 3; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        logger.info("## Number : {}, Primes : {}", n, primes);
        return primes.size();
    }

    private boolean isPrime(int number) {
        // 2 를 초과하는 짝수는 소수일 수 없다.
        if (number % 2 == 0) {
            return false;
        }

        // 홀수 중 절반을 넘는 숫자로 나누는 것은 무의미함. 나눗셈으로 떨어지지 않는다.
        for (int i = 3; i <= (number / 2) + 1; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NumberOfPrime prime = new NumberOfPrime();
        System.out.println(prime.numberOfPrime(10));
    }

}
