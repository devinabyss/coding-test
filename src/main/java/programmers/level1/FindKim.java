package programmers.level1;

import java.util.Arrays;

/**
 * Created by HK on 2018-04-11.
 */
public class FindKim {
    public String findKim(String[] seoul) {
        //x에 김서방의 위치를 저장하세요.
        int x = 0;



        for (int i = 0; i < seoul.length; i++ ){
            if (seoul[i].equals("Kim")){
                x = i;
                break;
            }
        }
        return "김서방은 " + x + "에 있다";
    }

    // 실행을 위한 테스트코드입니다.
    public static void main(String[] args) {
        FindKim kim = new FindKim();
        String[] names = {"Queen", "Tod", "Kim"};
        System.out.println(kim.findKim(names));
    }
}
