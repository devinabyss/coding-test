package programmers.oold.level3;

/**
 * Created by HK on 2018-04-21.
 */
public class NLCM {

//    public int gcd(int[] num){
//        if (num.length == 0) {
//            return 0;
//        }
//
//        int result = num[0];
//        for ( int i =1; i < num.length; i++ ){
//            result = gcd(result, num[i]);
//        }
//        return  result;
//    }

    public long gcd(long num1, long num2){
        while (num2 > 0) {
            long temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public long lcm(long num1, long num2) {
        return num1 * (num2 / gcd(num1, num2));
    }


    public long nlcm(int[] num) {

        if (num.length == 0) {
            return 0;
        }

        long answer = num[0];
        for (int i = 1; i < num.length; i++) {
            answer = lcm(answer, num[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        NLCM c = new NLCM();
        //int[] ex = {2, 6, 8, 14};
        int[] test = {45, 55, 4, 25, 45, 46, 99, 14, 75, 71};
        int[] test2 = {33, 60, 50, 37, 2, 92, 81, 85, 1, 60};
        // 아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(c.nlcm(test2));
    }

}
