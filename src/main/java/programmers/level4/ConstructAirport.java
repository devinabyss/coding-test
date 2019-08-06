package programmers.level4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 알고리즘 35. 공항 건설하기
 * 1보다 큰 N개의 도시 중 한 곳에 공항을 지을 예정입니다.
 * 사람들의 편의를 위해 공항으로부터 각 사람들까지의 도시간 이동 거리가 최소가 되는 도시에 짓기로 하였습니다.
 * 편의상 도시는 일직선상에 놓여있다고 가정하며 좌표의 범위는 음수가 포함됩니다. 또한 좌표는 정렬되어 있지 않습니다.
 * 직선상의 위치와 그 도시에 사는 사람들의 수가 주어질 때, 공항을 지을 도시의 위치를 반환해주는 함수 chooseCity 함수를 완성하세요.
 * 거리가 같은 도시가 2개 이상일 경우 위치가 더 작은 쪽의 도시를 선택하면 됩니다.
 * 예를 들어 다음과 같은 정보의 도시가 있다고 가정해 봅시다.
 * 위치	1	2	3
 * 인구수	5	2	3
 * 이 살 경우, 각각의 도시에 공항을 지었을 때의 사람들의 이동 거리는 8, 8, 12 이므로 1번 또는 2번에 지을 수 있지만, 1의 위치가 더 작으므로 1을 반환해주면 됩니다.
 * Created by HK on 2018-04-22.
 */
public class ConstructAirport {
    private static final Logger logger = LoggerFactory.getLogger(ConstructAirport.class);

    public int chooseCity2(int n, int[][] city) {
        int answer = 0;


        //logger.info("## sorted : {}", Arrays.toString(city[0]));

        int minZ = 999999999;
        int minCity = 999999999;

        for (int i = 0; i < city.length; i++) {

            int sumZ = 0;
            for (int j = 0; j < city.length; j++) {
                if (i == j) continue;
                int curZ = Math.abs(city[i][0] - city[j][0]) * city[j][1];
                sumZ += curZ;
            }
            logger.info("## mincity : {}, minZ : {}, curcity : {} , curZ : {}", minCity, minZ, i, sumZ);
            if (minZ >= sumZ) {
                minCity = minZ == sumZ ? minCity > city[i][0] ? city[i][0] : minCity : city[i][0];
                minZ = sumZ;
            }
        }

        logger.info("## : z : {}, min city : {}", minZ, minCity);

        return 0;
    }

    public int chooseCity(int n, int[][] city) {

        Arrays.sort(city, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] > o2[0] ? -1 : 0;
            }
        });

        logger.info("## sorted : {}", Arrays.toString(city[0]));

        return 0;

    }


    public static void main(String[] args) {
        ConstructAirport test = new ConstructAirport();
        int tn = 3;
        int[][] tcity = {{1, 5}, {2, 2}, {3, 3}};
        int[][] tcity2 = {{4, 5}, {2, 7}, {3, 6}};
        System.out.println(test.chooseCity(tn, tcity2));
    }
}
