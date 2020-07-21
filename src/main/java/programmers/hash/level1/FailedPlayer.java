package programmers.hash.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 문제 : 완주하지 못한 선수
 * 카테고리 : 해시
 * <p>
 * 문제 설명
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * <p>
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class FailedPlayer {

    public static String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        return participant[participant.length - 1];
    }

    public static String recursionMain(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        return recursion(participant, completion, 0);

    }

    public static String recursion(String[] participant, String[] completion, int index) {

        if (completion.length == index) {
            return participant[index];
        }


        boolean isSame = participant[index].equals(completion[index]);

        if (index == 100) {
            throw new RuntimeException("AA");
        }

//        if (isSame){
//            throw new RuntimeException("AA");
//        }

        return isSame ? recursion(participant, completion, ++index) : participant[index];
    }

    public static String[] getCompletion(int length) {


        List<String> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(String.valueOf(i));
        }

        return list.stream().map(String::valueOf).toArray(String[]::new);
    }

    public static void main(String[] args) {

//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completed = {"leo", "kiki"};

        List<String> a = new ArrayList<String>(Arrays.asList(getCompletion(1000)));

        a.add("AA");

        System.out.println(a.toString());

        String[] completed = getCompletion(1000);
        String[] participant = a.toArray(new String[1001]);
        System.out.println("## pa : " + Arrays.toString(participant));

        String failed = recursionMain(participant, completed);

        System.out.println("Failed Player : " + failed);
    }
}
