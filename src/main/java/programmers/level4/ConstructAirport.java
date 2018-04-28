package programmers.level4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;

/**
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
