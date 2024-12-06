package dev.buskopan.fizz_buzz;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira um número inteiro");
        int number = sc.nextInt();

        for (int i = 1; i <= number; i++) {
            boolean dividableBy3 = i % 3 == 0;
            boolean dividableBy5 = i % 5 == 0;
            StringBuilder result = new StringBuilder();

            if (dividableBy3) {
                result.append("Fizz");
            }
            if (dividableBy5) {
                result.append("Buzz");
            }
            if (result.isEmpty()) continue;
            System.out.println(result + " :" + i);
        }
        main(args);
    }
}
