package codetest.programmers.dfsbfs.level3;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 완료안됨
 * https://programmers.co.kr/learn/courses/30/lessons/43164?language=java
 */
@Slf4j
public class TravelCourse {


    private Set<String[]> cache;

    private List<String> findCourses(String from, String[][] tickets, List<String> courses) {

        Optional<String[]> fromTicket = Arrays.stream(tickets)
                .filter(ticket -> ticket[0].equals(from) && !cache.contains(ticket)).min(Comparator.comparing(o -> o[1]));

        log.info("cache : {}", Arrays.deepToString(cache.toArray()));

        if (fromTicket.isEmpty()) {
            courses.add(from);
            return courses;
        }

        courses.add(fromTicket.get()[0]);
        cache.add(fromTicket.get());

        return findCourses(fromTicket.get()[1], tickets, courses);
    }


    public String[] solution(String[][] tickets) {
        cache = new HashSet<>();
        List<String> courses = findCourses("ICN", tickets, new ArrayList<>());
        return courses.toArray(new String[courses.size()]);
    }

    @Test
    public void test() {

        String[][][] tc = {
                {{"ICN", "F"}, {"F", "B"}, {"B", "F"}, {"F", "B"}, {"B", "F"}, {"F", "B"}},
                {{"ICN", "A"}},
                {{"ICN", "A"}, {"A", "B"}, {"B", "A"}, {"A", "ICN"}, {"ICN", "A"}},
                {{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"}},
                {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}},
                {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}
        };
        for (int i = 0; i < tc.length; i++) {
            String[] result = solution(tc[i]);
            log.info("## result : {}", Arrays.toString(result));
        }

    }
}
