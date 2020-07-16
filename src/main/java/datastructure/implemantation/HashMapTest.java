package datastructure.implemantation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

@Slf4j
public class HashMapTest {


    @Test
    public void test() {
        Data a = new Data("A", "B");
        Data b = new Data("A", "B");

        Set<Data> set = new HashSet<>();
        set.add(a);
        set.add(b);

        log.info("## Set : {}", set);


        Map<Data, String> map = new HashMap<>();
        map.put(a, "AAA");
        map.put(b, "BBB");

        log.info("## Map : {}", map);
    }


    @AllArgsConstructor
    @Getter
    @ToString
    public static class Data {
        private final String propA;
        private final String propB;

        @Override
        public int hashCode() {
            return Objects.hash(propA, propB);
        }

        @Override
        public boolean equals(Object a) {
            return false;
        }
    }
}
