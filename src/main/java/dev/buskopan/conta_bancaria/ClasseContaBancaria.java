package dev.buskopan.conta_bancaria;

import java.math.BigDecimal;

public class ClasseContaBancaria {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria("André", BigDecimal.valueOf(1000));
        ContaBancaria conta2 = new ContaBancaria("João", BigDecimal.valueOf(1000));

        System.out.println("Depositando, saldo atual: R$"+conta1.depositar(BigDecimal.valueOf(100)));
        System.out.println("Sacando, saldo atual: R$"+conta1.sacar(BigDecimal.valueOf(50)));
        System.out.println("Tranferindo para conta2, saldo restante: R$"+conta1.transferencia(conta2,BigDecimal.valueOf(100)));

        System.out.println("Saldo conta1: R$" + conta1.getSaldo());
        System.out.println("Saldo conta2: R$" + conta2.getSaldo());
    }
}
