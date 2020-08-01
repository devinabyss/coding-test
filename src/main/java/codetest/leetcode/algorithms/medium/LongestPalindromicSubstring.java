package codetest.leetcode.algorithms.medium;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * medium 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/submissions/
 */
@Slf4j
public class LongestPalindromicSubstring {

    // 0 = not set, 1 = true, -1 = false
    private static int[][] cache;

    public String longestPalindrome(String s) {

        cache = new int[s.length()][s.length()];

        String max = "";
        String current = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i && j - i > max.length(); j--) {
                current = s.substring(i, j);
                boolean isPalindromic = isPalindromic(i, j, s);
                if (isPalindromic) {
                    max = current.length() > max.length() ? current : max;
                }
            }
        }

        return max;
    }

    public boolean isPalindromic(int i, int j, String s) {
        if (j - i < 2) {
            boolean a = i == j - 1 || s.charAt(i) == s.charAt(j - 1);
            cache[i][j - 1] = a ? 1 : -1;
            return a;
        }

        switch (cache[i][j - 1]) {

            case 1:
                return true;

            case -1:
                return false;

            default:
                boolean a = isPalindromic(i + 1, j - 1, s) && s.charAt(i) == s.charAt(j - 1);
                cache[i][j - 1] = a ? 1 : -1;
                return a;
        }

    }

    public boolean isPalindromic2(String s) {

        if (s.length() == 0)
            return true;

        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String[] tc = {"babad", "cbbd", "a", "babad",
                "flsuqzhtcahnyickkgtfnlyzwjuiwqiexthpzvcweqzeqpmqwkydhsfipcdrsjkefehhesubkirhalgnevjugfohwnlhbjfewiunlgmomxkafuuokesvfmcnvseixkkzekuinmcbmttzgsqeqbrtlwyqgiquyylaswlgfflrezaxtjobltcnpjsaslyviviosxorjsfncqirsjpkgajkfpoxxmvsyynbbovieoothpjgncfwcvpkvjcmrcuoronrfjcppbisqbzkgpnycqljpjlgeciaqrnqyxzedzkqpqsszovkgtcgxqgkflpmrikksaupukdvkzbltvefitdegnlmzeirotrfeaueqpzppnsjpspgomyezrlxsqlfcjrkglyvzvqakhtvfmeootbtbwfhqucbnuwznigoyatvkocqmbtqghybwrhmyvvuchjpvjckiryvjfxabezchynfxnpqaeampvaapgmvoylyutymdhvhqfmrlmzkhuhupizqiujpwzarnszrexpvgdmtoxvjygjpmiadzdcxtggwamkbwrkeplesupagievwsaaletcuxtpsxmbmeztcylsjxvhzrqizdmgjfyftpzpgxateopwvynljzffszkzzqgofdlwyknqfruhdkvmvrrjpijcjomnrjjubfccaypkpfokohvkqndptciqqiscvmpozlyyrwobeuazsawtimnawquogrohcrnmexiwvjxgwhmtpykqlcfacuadyhaotmmxevqwarppknoxthsmrrknu",
                "kztakrekvefgchersuoiuatzlmwynzjhdqqftjcqmntoyckqfawikkdrnfgbwtdpbkymvwoumurjdzygyzsbmwzpcxcdmmpwzmeibligwiiqbecxwyxigikoewwrczkanwwqukszsbjukzumzladrvjefpegyicsgctdvldetuegxwihdtitqrdmygdrsweahfrepdcudvyvrggbkthztxwicyzazjyeztytwiyybqdsczozvtegodacdokczfmwqfmyuixbeeqluqcqwxpyrkpfcdosttzooykpvdykfxulttvvwnzftndvhsvpgrgdzsvfxdtzztdiswgwxzvbpsjlizlfrlgvlnwbjwbujafjaedivvgnbgwcdbzbdbprqrflfhahsvlcekeyqueyxjfetkxpapbeejoxwxlgepmxzowldsmqllpzeymakcshfzkvyykwljeltutdmrhxcbzizihzinywggzjctzasvefcxmhnusdvlderconvaisaetcdldeveeemhugipfzbhrwidcjpfrumshbdofchpgcsbkvaexfmenpsuodatxjavoszcitjewflejjmsuvyuyrkumednsfkbgvbqxfphfqeqozcnabmtedffvzwbgbzbfydiyaevoqtfmzxaujdydtjftapkpdhnbmrylcibzuqqynvnsihmyxdcrfftkuoymzoxpnashaderlosnkxbhamkkxfhwjsyehkmblhppbyspmcwuoguptliashefdklokjpggfiixozsrlwmeksmzdcvipgkwxwynzsvxnqtchgwwadqybkguscfyrbyxudzrxacoplmcqcsmkraimfwbauvytkxdnglwfuvehpxd"
        };
        for (int i = 0; i < tc.length; i++) {
            String result = longestPalindrome(tc[i]);
            log.info("## result : {}", result);
        }
    }

    @Test
    public void test2() {
        boolean[] a = new boolean[10];
        log.info("## {}", Arrays.toString(a));
    }

    public String bruteForce(String s) {
        String max = "";
        String current = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i && j - i > max.length(); j--) {
                current = s.substring(i, j);
                boolean isPalindromic = isPalindromic2(current);
                if (isPalindromic) {
                    max = current.length() > max.length() ? current : max;
                }
            }
        }
        return max;
    }

}
