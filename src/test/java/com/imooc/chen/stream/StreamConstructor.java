package com.imooc.chen.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamConstructor {

    @Test
    public void streamFromValue() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        integerStream.forEach(System.out::println);
    }

    @Test
    public void streamFromArray() {
        int[] numbers = {1, 2, 3, 4, 5};

        IntStream stream = Arrays.stream(numbers);

        stream.forEach(System.out::println);
    }

    @Test
    public void streamFromFile() throws IOException {
        Stream<String> lines = Files.lines(
                Paths.get("/Users/liuchen/MyDev/imooc/996/src/test/java/com/imooc/chen/stream/StreamOperator.java")
        );

        lines.forEach(System.out::println);
    }

    @Test
    public void streamFromFunction() {
//        Stream stream = Stream.iterate(0, n -> n + 2);

        Stream<Double> stream = Stream.generate(Math::random);

        stream.limit(100).forEach(System.out::println);
    }

}
