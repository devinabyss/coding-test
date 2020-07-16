package pattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class Singleton {

    private Singleton() {
    }

    public static Singleton singleton;

    public static Singleton getInstanceWithoutConcurrencyAvoid() {
        singleton = Optional.ofNullable(singleton).orElseGet(Singleton::new);
        return singleton;
    }

    public static Singleton getInstanceWithConcurrencyNestedSyncrhronizedCheck() {
//        if (singleton == null) {
//
//            synchronized (Singleton.class) {
//                if (singleton == null)
//                    singleton = new Singleton();
//            }
//        }
        singleton = Optional.ofNullable(singleton).orElseGet(
                () -> {
                    synchronized (Singleton.class) {
                        return Optional.ofNullable(singleton).orElseGet(Singleton::new);
                    }
                });
        return singleton;
    }

    public static synchronized Singleton getInstanceWithConcurrencyAvoidWholeSynchronized() {
        singleton = Optional.ofNullable(singleton).orElseGet(Singleton::new);
//        if (singleton == null)
//            singleton = new Singleton();
        return singleton;
    }


    @Slf4j
    @Execution(ExecutionMode.CONCURRENT)
    public static class SingletonTest {
        private static final int POOL = 100;
        private static final int CURRENCY_COUNT = 100000;

        @BeforeEach
        public void beforeEachMethod() {
            Singleton.singleton = null;
        }

        @Test
        public void testWithoutConcurrencyAvoid() throws InterruptedException {
            ExecutorService service = Executors.newFixedThreadPool(POOL);

            AtomicReference<Set<String>> atomicSet = new AtomicReference<>(new HashSet<>());


            long start = System.currentTimeMillis();

            for (int i = 0; i < CURRENCY_COUNT; i++) {
                service.submit(() -> {
                    Singleton singleton = Singleton.getInstanceWithoutConcurrencyAvoid();
                    Set<String> set = atomicSet.getAndUpdate(current -> {
                        Set<String> newSet = new HashSet<>(current);
                        newSet.add(singleton.toString());
                        return newSet;
                    });
                });
            }
            service.shutdown();
            service.awaitTermination(10, TimeUnit.SECONDS);
            long end = System.currentTimeMillis();
            log.info("## ExecutionTime : {}, atomicSet : {}, {}", end - start, atomicSet.get().size(), atomicSet.get());
            Assert.assertTrue(atomicSet.get().size() > 1);
        }

        @RepeatedTest(100)
        public void testWithConcurrencyNestedSynchronizedCheck() throws InterruptedException {
            ExecutorService service = Executors.newFixedThreadPool(POOL);

            AtomicReference<Set<String>> atomicSet = new AtomicReference<>(new HashSet<>());

            long start = System.currentTimeMillis();


            for (int i = 0; i < CURRENCY_COUNT; i++) {
                service.submit(() -> {
                    Singleton singleton = Singleton.getInstanceWithConcurrencyNestedSyncrhronizedCheck();
                    atomicSet.getAndUpdate(current -> {
                        Set<String> newSet = new HashSet<>(current);
                        newSet.add(singleton.toString());
                        return newSet;
                    });
                });
            }

            service.shutdown();
            service.awaitTermination(10, TimeUnit.SECONDS);
            long end = System.currentTimeMillis();
            log.info("## ExecutionTime : {}, atomicSet : {}, {}", end - start, atomicSet.get().size(), atomicSet.get());
            Assert.assertEquals(1, atomicSet.get().size());
        }

        @RepeatedTest(100)
        public void testWithConcurrencyAvoidWholeSynchronized() throws InterruptedException {
            ExecutorService service = Executors.newFixedThreadPool(POOL);

            AtomicReference<Set<String>> atomicSet = new AtomicReference<>(new HashSet<>());

            long start = System.currentTimeMillis();

            for (int i = 0; i < CURRENCY_COUNT; i++) {
                service.submit(() -> {
                    Singleton singleton = Singleton.getInstanceWithConcurrencyAvoidWholeSynchronized();
                    atomicSet.getAndUpdate(current -> {
                        Set<String> newSet = new HashSet<>(current);
                        newSet.add(singleton.toString());
                        return newSet;
                    });
                });
            }

            service.shutdown();
            service.awaitTermination(1000, TimeUnit.MILLISECONDS);
            long end = System.currentTimeMillis();
            log.info("## ExecutionTime : {}, atomicSet : {}, {}", end - start, atomicSet.get().size(), atomicSet.get());
            Assert.assertEquals(1, atomicSet.get().size());
        }

    }
}
