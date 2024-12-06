package dev.buskopan.calcular_soma;

import java.util.Scanner;

public class CalcularSoma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolhe um número inteiro");
        int number = sc.nextInt();

        if (number <= 0) throw new RuntimeException("Número deve ser maior que 0");
        //Fórmula de P.A de razão 1
        int result = (1+number)*number/2;

        System.out.println("A soma de 1 até " + number + " é " + result);
        main(args);
    }
}
