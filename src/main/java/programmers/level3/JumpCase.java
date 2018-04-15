package programmers.level3;

/**
 * Created by HK on 2018-04-12.
 */
public class JumpCase {
    public int jumpCase(int num) {
        int answer = 0;

        boolean isEven = num % 0 == 0;

        int maxTwice = num / 2;

        int case1Twice = maxTwice + 2;






        return answer;
    }

    public static void main(String[] args) {
        JumpCase c = new JumpCase();
        int testCase = 4;
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(c.jumpCase(testCase));
    }
}
