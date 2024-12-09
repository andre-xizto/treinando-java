package dev.buskopan.streams;

import dev.buskopan.arvore_binaria_busca.No;

import java.util.*;
import java.util.stream.Collectors;

public class Streams_2 {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,2,1,3,4,5,610);

        Optional<Integer> min = lista.stream()
                .filter(e -> e % 2 == 0)
                .min(Comparator.naturalOrder());

        //noinspection OptionalGetWithoutIsPresent
        System.out.println(min.get());

        List<Integer> novaLista = lista.stream()
                .map(e -> e * 2)
                .collect(Collectors.toList());

        System.out.println(novaLista);

        Map<Boolean, List<Integer>> mapa = lista.stream()
                .collect(Collectors.groupingBy(e -> e % 2 == 0));

        System.out.println(mapa);
    }
}
