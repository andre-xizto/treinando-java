package dev.buskopan.operacoes_basicas;

import java.util.Scanner;

public class OperacoesBasicas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Número 1:");
        int number1 = sc.nextInt();
        System.out.println("Operação matemática");
        sc.nextLine();
        String operation = sc.nextLine();
        System.out.println("Número 2:");
        int number2 = sc.nextInt();

        switch (operation) {
            case "+":
                System.out.println(number1+number2);
                break;
            case "-":
                System.out.println(number1-number2);
                break;
            case "*":
                System.out.println(number1*number2);
                break;
            case "/":
                if ((number2 > 0)) {
                    System.out.println(number1 / number2);
                } else {
                    System.out.println("Divisão por zero é inválida");
                }
                break;
            default:
                System.out.println("Use: '+','-','*','/' como operadores");
        }
        main(args);
    }
}
