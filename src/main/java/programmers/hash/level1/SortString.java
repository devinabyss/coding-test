package programmers.hash.level1;

import java.util.Arrays;

public class SortString {

    public String reverseStr(String str) {

        int[] array = new int[str.length()];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) str.charAt(i);
        }

        Arrays.sort(array);

        //System.out.println(Arrays.toString(array));

        StringBuilder sb = new StringBuilder();
        Arrays.stream(array).forEach(num -> sb.append(Character.valueOf((char) num)));

        return sb.reverse().toString();
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        SortString rs = new SortString();
        System.out.println(rs.reverseStr("Zbcdefg"));
    }

}
