package programmers.hash.level3;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 *
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 * 입출력 예
 * genres	plays	return
 * [classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 * 입출력 예 설명
 * classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
 *
 * 고유 번호 3: 800회 재생
 * 고유 번호 0: 500회 재생
 * 고유 번호 2: 150회 재생
 * pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
 *
 * 고유 번호 4: 2,500회 재생
 * 고유 번호 1: 600회 재생
 * 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 */
public class BestAlbum {
    private static class Song implements Comparable<Song> {
        private int no;
        private int plays;
        private String genre;

        public Song(int no, int plays, String genre) {
            this.no = no;
            this.plays = plays;
            this.genre = genre;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public int getPlays() {
            return plays;
        }

        public void setPlays(int plays) {
            this.plays = plays;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        @Override
        public int compareTo(Song o) {
            return o.plays - this.plays;
        }
        @Override
        public String toString(){
            return "Song [ no = " + no + ", plays = " + plays + ", genre = " + genre + "]";

        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreStat = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i ++) {
            String key = genres[i];
            genreStat.put(key, Optional.ofNullable(genreStat.get(key)).orElse(0) + plays[i]);
            List<Song> songs = Optional.ofNullable(genreSongs.get(key)).orElse(new ArrayList<>());
            songs.add(new Song(i, plays[i], key));
            genreSongs.put(key, songs);
        }

        Map<String, Integer> sortedStat =
                genreStat.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> newValue, LinkedHashMap::new));

        List<Integer> best = new ArrayList<>();
//        System.out.println(genreStat);
        System.out.println(sortedStat);
//

//
        for (String genre : sortedStat.keySet()) {

            System.out.println("### GENRE : " + genre);

            List<Song> songs = genreSongs.get(genre);
            Collections.sort(songs);
            System.out.println(songs);
            for (int i =0; (i < 2 && i < songs.size()); i++) {
                System.out.println("genre : " + genre + ", i : " + i);
                best.add(songs.get(i).getNo());
            }
        }

        return best.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop","kpop", "jpop"};
        int[] plays = {500, 600, 150, 800, 2500, 100, 2500};
        int[] result = solution(genres, plays);
        System.out.println(Arrays.toString(result));
    }
}
