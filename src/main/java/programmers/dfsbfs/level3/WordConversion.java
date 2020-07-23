package programmers.dfsbfs.level3;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class WordConversion {

    public int recursive(String begin, String target, String[] words, boolean[] cache) {

        String temp = "";
        for (int i = 0; i < words.length; i++) {
            if (cache[i]) continue;

            String word = words[i];

            int diff = 0;
            for (int j = 0; j < word.length(); j++) {
                if (begin.charAt(j) != word.charAt(j))
                    diff++;
                if (diff > 1)
                    break;
            }

            if (diff == 1) {
                cache[i] = true;
                if (word.equals(target)) {
                    return 1;
                } else {
                    temp = word;
                }
            }
        }

        return temp.length() > 1 ? recursive(temp, target, words, cache) + 1 : 0;
    }


    public int solution(String begin, String target, String[] words) {

        if (!contains(words, target))
            return 0;

        boolean[] visited = new boolean[words.length];

        return recursive(begin, target, words, visited);
    }


    private boolean contains(String[] words, String target) {
        for (String word : words) {
            if (word.equals(target))
                return true;
        }
        return false;
    }


    @Test
    public void test() {

        String[] begins = {"hit", "hit"};
        String[] targets = {"cog", "cog"};
        String[][] tc = {
                {"hot", "dot", "dog", "lot", "log", "cog"},
                {"hot", "dot", "dog", "lot", "log"}
        };

        for (int i = 0; i < begins.length; i++) {
            int result = solution(begins[i], targets[i], tc[i]);
            log.info("## result : {}", result);
        }
    }
}
