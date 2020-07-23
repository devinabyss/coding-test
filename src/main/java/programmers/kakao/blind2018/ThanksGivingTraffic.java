package programmers.kakao.blind2018;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Slf4j
public class ThanksGivingTraffic {


    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");


    @ToString
    private static class Log implements Comparable<Log> {
        private final LocalDateTime start;
        private final LocalDateTime end;
        private final int duration;
        private String source;

        public Log(LocalDateTime start, LocalDateTime end, int duration, String source) {
            this.start = start;
            this.end = end;
            this.duration = duration;
            this.source = source;
        }

        public boolean isInclusion(LocalDateTime time) {
            LocalDateTime from = start.truncatedTo(ChronoUnit.SECONDS);
            LocalDateTime to = end.truncatedTo(ChronoUnit.SECONDS).plus(999, ChronoUnit.MILLIS);
            boolean a = time.compareTo(from) >= 0;
            boolean b = time.compareTo(to) <= 0;
            log.info("## THIS : {}, time : {}, from : {}, to : {}, a better : {}, b smaller : {}", this, time, from, to, a, b);
            return a && b;
        }

        @Override
        public int compareTo(Log o) {
            return this.start.compareTo(o.start);
        }
    }

    public int solution(String[] lines) {
        int answer = 0;


        List<Log> logs = new ArrayList<>();

        for (String line : lines) {
            String[] splited = line.split("\\s");
            log.info("## Splited : {}", Arrays.toString(splited));
            int total = getDuration(splited[2]);
            String source = splited[0] + " " + splited[1];
            LocalDateTime end = LocalDateTime.parse(source, formatter);
            LocalDateTime start = end.minus(total, ChronoUnit.MILLIS);
            logs.add(new Log(start, end, total,source ));
        }

        Collections.sort(logs);

        LocalDateTime min = logs.get(0).start.truncatedTo(ChronoUnit.SECONDS);
        LocalDateTime max = logs.get(logs.size() - 1).end.truncatedTo(ChronoUnit.SECONDS);

        Map<LocalDateTime, Integer> map = new HashMap<>();

        for (LocalDateTime ldt = min; ldt.compareTo(max) < 0; ldt = ldt.plus(1, ChronoUnit.MILLIS)) {
            int count = 0;
            for (Log log : logs) {
                if (log.isInclusion(ldt))
                    count++;
            }
            map.put(ldt, count);
        }

        log.info("## Logs :{}", logs);
        log.info("## Map : {}", map);
        return map.values().stream().mapToInt(Integer::intValue).max().orElseGet(() -> 0);
    }


    public int getDuration(String str) {
        String[] timeSplited = str.substring(0, str.length() - 1).split("\\.");
        int first = Integer.parseInt(timeSplited[0]) * 1000;
        log.info("## TimeSplited : {}", Arrays.toString(timeSplited));
        int last = timeSplited.length == 1 ? 0 : Integer.parseInt(String.format("%-3s", timeSplited[1]).replaceAll(" ", "0"));

        return first + last;
    }

    @Test
    public void test1() {

        log.info("## {}", String.format("%-3s", "8").replaceAll(" ", "0"));
        getDuration("0.8s");
    }

    @Test
    public void test() {


        String[][] testCases = {
                {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"},
                {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"},
                {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s",
                        "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s",
                        "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"}
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = solution(testCases[i]);
            log.info("## result : {}", result);
        }

        LocalDateTime ldt = LocalDateTime.parse("2016-09-15 01:00:04.001", formatter);
        log.info("## LDT : {}", ldt);


    }
}
