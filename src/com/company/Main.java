package com.company;

import java.util.List;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        // Stream<Long> fab = Stream.generate(new FibSupplier());
        // fab.limit(10).forEach(System.out::println);

        // LongStream fab2 = LongStream.generate(new FibSupplier2());
        // fab2.limit(10).forEach(System.out::println);

        final Stream<Long> generate = Stream.generate(new FibSupplier());
        final List<Long> collect = generate.limit(10).collect(Collectors.toList());
        System.out.println(collect);
        // final List<Long> collect = generate.limit(10).collect(Collectors.toList());
    }
}

class FibSupplier implements Supplier<Long> {
    long n1 = 0;
    long n2 = 0;
    long n3 = 1;

    public Long get() {
        n1 = n2;
        n2 = n3;
        n3 = n1 + n2;
        return n2;
    }
}
class FibSupplier2 implements LongSupplier {
    long n1 = 0;
    long n2 = 0;
    long n3 = 1;

    public long getAsLong() {
        n1 = n2;
        n2 = n3;
        n3 = n1 + n2;
        return n2;
    }
}