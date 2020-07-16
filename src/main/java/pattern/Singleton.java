package pattern;

import lombok.extern.slf4j.Slf4j;
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
        return singleton;
    }


    @Slf4j
    @Execution(ExecutionMode.CONCURRENT)
    public static class SingletonTest {
        private static final int POOL = 100;
        private static final int CURRENCY_COUNT = 100000;

        @Test
        public void testWithoutConcurrencyAvoid() {
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


            try {
                service.awaitTermination(1000, TimeUnit.MILLISECONDS);
                long end = System.currentTimeMillis();
                log.info("## ExecutionTime : {}, atomicSet : {}, {}", end - start, atomicSet.get().size(), atomicSet.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Test
        public void testWithConcurrencyNestedSynchronizedCheck() {
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


            try {
                while (!service.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                    log.info("## a :P {}", "a");
                }
                long end = System.currentTimeMillis();
                log.info("## ExecutionTime : {}, atomicSet : {}, {}", end - start, atomicSet.get().size(), atomicSet.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Test
        public void testWithConcurrencyAvoidWholeSynchronized() {
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

            try {
                service.awaitTermination(1000, TimeUnit.MILLISECONDS);
                long end = System.currentTimeMillis();
                log.info("## ExecutionTime : {}, atomicSet : {}, {}", end - start, atomicSet.get().size(), atomicSet.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
