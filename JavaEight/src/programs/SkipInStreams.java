package programs;

import java.util.Comparator;
import java.util.stream.IntStream;

public class SkipInStreams {
    public static void main(String[] args) {
        System.out.println(  IntStream.range(0,10)
                .skip(2)
                .distinct()
                .asDoubleStream()
                        .findFirst().getAsDouble());
    }
}
