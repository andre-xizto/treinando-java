package dev.buskopan.streams;

import java.util.Arrays;
import java.util.List;

public class Streams_1 {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,2,1,3,4,5,610);

        lista.stream()
                .skip(1)
                .limit(5)
                .distinct()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .forEach(System.out::println);
    }
}
