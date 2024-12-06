package dev.buskopan.maior_numero;

import java.util.Scanner;
import java.util.TreeSet;

public class MaiorNumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();

        System.out.println("Primeiro número:");
        set.add(sc.nextInt());
        System.out.println("Segundo número:");
        sc.nextLine();
        set.add(sc.nextInt());
        System.out.println("Terceiro número:");
        sc.nextLine();
        set.add(sc.nextInt());

        System.out.println("O maior número é:" + set.last());
        main(args);
    }
}
