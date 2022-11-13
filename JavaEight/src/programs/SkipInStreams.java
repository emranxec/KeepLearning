package programs;

import java.util.stream.IntStream;

public class SkipInStreams {
    public static void main(String[] args) {
        System.out.println(  IntStream.range(0,10)
                .skip(5)
                .skip(1)
                .distinct()
                .asDoubleStream()
                .parallel()
                .reduce(0, Double::max));
    }
}
