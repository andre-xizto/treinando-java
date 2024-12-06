package dev.buskopan.par_impar;

import java.util.Scanner;

public class ParImpar {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe um número inteiro");
        int number = sc.nextInt();

        String result = number % 2 == 0 ? "par" : "ímpar";

        System.out.println("O número " + number + " é " + result);
        main(args);
    }
}
