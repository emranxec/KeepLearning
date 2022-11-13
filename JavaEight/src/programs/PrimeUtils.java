package programs;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeUtils {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(1);
        List<Integer> primeList = forkJoinPool.submit(() -> new PrimeUtils().collectPrimes(100)).get();
        System.out.println("primeList = " + primeList);
        System.out.println("count prime  = " + new PrimeUtils().countPrimes(100));
        forkJoinPool.shutdown();
        long t2 = System.currentTimeMillis();
    }
    private List<Integer> collectPrimes(int max) {
        return IntStream.range(1, max).parallel().filter(this::isPrime).boxed().collect(Collectors.toList());
    }
    private long countPrimes(int max) {
        return IntStream.range(1, max).parallel().filter(this::isPrime).count();
    }
    private boolean isPrime(long n) {
        return n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(divisor -> n % divisor == 0);
    }
}
