package programmers.stackque.level2;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 * 채점은 완료되었는데 풀이 상태가 업데이트 되지 않음
 */
@Slf4j
public class PrinterPriority {


    private static class Printer {

        public Printer(int[] priorities) {
            this.que = new LinkedList<>();
            for (int i = 0; i < priorities.length; i++) {
                que.add(new Document(String.valueOf(i), priorities[i]));
            }
        }

        private final List<Document> que;

        private int completed = 0;
        private Integer max = 0;

        public int queSize() {
            return que.size();
        }

        public int getCompleted() {
            return completed;
        }

        private int getMaxPriority(){
            max = max == 0 ? que.stream().mapToInt(Document::getPriority).max().orElseGet(() -> 0) : 0;
            return max;
        }

        public String print() {
            int max = getMaxPriority();
            Document current = que.get(0);
            while (current.getPriority() < max) {
                que.remove(current);
                que.add(current);
                current = que.get(0);
            }

            que.remove(current);
            completed++;
            this.max = 0;

            return current.getDoc();
        }

        @ToString
        public static class Document {
            private final String doc;
            private final Integer priority;

            private Document(String doc, int priority) {
                this.doc = doc;
                this.priority = priority;
            }

            public String getDoc() {
                return doc;
            }

            public Integer getPriority() {
                return priority;
            }
        }

    }


    public int solution(int[] priorities, int location) {

        //log.info("## Targets : {}", Arrays.toString(priorities));
        Printer printer = new Printer(priorities);

        String target = String.valueOf(location);

        String s = printer.print();

        //log.info("## !Printed : {}",s);
        while (!s.equals(target)) {
            s = printer.print();
            //log.info("## Printed : {}",s);

        }

////        log.info("## Printed : {}",printer.print());
////        log.info("## Printed : {}",printer.print());
//
//
//        log.info("## Rest Size : {}", printer.queSize());

        return printer.getCompleted();


    }


    @Test
    public void test() {

        int[] locations = {2, 0, 0, 4};
        int[][] arrays = {
                {2, 1, 3, 2},
                {1, 1, 9, 1, 1, 1},
                {1},
                {1, 1, 1, 1, 1, 1, 2, 1, 1, 1}

        };

        for (int i = 0; i < locations.length; i++) {
            int result = solution(arrays[i], locations[i]);
            log.info("## Result : {} ", result);
        }

    }


}
