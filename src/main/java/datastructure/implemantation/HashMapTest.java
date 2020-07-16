package datastructure.implemantation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class HashMapTest {


    @Test
    public void test() {

        EqualsTrueHashNotEqual testCase1A = new EqualsTrueHashNotEqual("A", "B");
        EqualsTrueHashNotEqual testCase1B = new EqualsTrueHashNotEqual("B", "B");
        Map<EqualsTrueHashNotEqual, String> map1 = new HashMap<>();
        map1.put(testCase1A, "AAA");
        map1.put(testCase1B, "BBB");

        log.info("##");
        log.info("## Hash != , Equals == ##");
        log.info("## TestCase1A : {}, TestCase1B : {}", testCase1A, testCase1B);
        log.info("## Map : Size : {}, {}", map1.size(), map1);

        EqualsTrueHashEqual testCase2A = new EqualsTrueHashEqual("A", "B");
        EqualsTrueHashEqual testCase2B = new EqualsTrueHashEqual("A", "B");
        Map<EqualsTrueHashEqual, String> map2 = new HashMap<>();
        map2.put(testCase2A, "AAA");
        map2.put(testCase2B, "BBB");

        log.info("##");
        log.info("## Hash == , Equals == ##");
        log.info("## TestCase2A : {}, TestCase2B : {}", testCase2A, testCase2B);
        log.info("## Map : Size : {}, {}", map2.size(), map2);

        EqualsFalseHashEqual testCase3A = new EqualsFalseHashEqual("A", "B");
        EqualsFalseHashEqual testCase3B = new EqualsFalseHashEqual("A", "B");

        Map<EqualsFalseHashEqual, String> map3 = new HashMap<>();
        map3.put(testCase3A, "AAA");
        map3.put(testCase3B, "BBB");

        log.info("##");
        log.info("## Hash == , Equals != ##");
        log.info("## TestCase3A : {}, TestCase3B : {}", testCase3A, testCase3B);
        log.info("## Map : Size : {}, {}", map3.size(), map3);


    }


    @AllArgsConstructor
    @Getter
    @ToString
    public static class EqualsTrueHashNotEqual {
        private final String propA;
        private final String propB;

        @Override
        public int hashCode() {
            return Objects.hash(propA, propB);
        }

        @Override
        public boolean equals(Object a) {
            return true;
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName() + "::propA=" + propA + "::propB=" + propB + "::hashCode=" + hashCode();
        }
    }

    @AllArgsConstructor
    @Getter
    @ToString
    public static class EqualsTrueHashEqual {
        private final String propA;
        private final String propB;

        @Override
        public int hashCode() {
            return Objects.hash(propA, propB);
        }

        @Override
        public boolean equals(Object a) {
            return true;
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName() + "::propA=" + propA + "::propB=" + propB + "::hashCode=" + hashCode();
        }
    }

    @AllArgsConstructor
    @Getter
    @ToString
    public static class EqualsFalseHashEqual {
        private final String propA;
        private final String propB;

        @Override
        public int hashCode() {
            return 11;
        }

        @Override
        public boolean equals(Object a) {
            return false;
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName() + "::propA=" + propA + "::propB=" + propB + "::hashCode=" + hashCode();
        }
    }
}
