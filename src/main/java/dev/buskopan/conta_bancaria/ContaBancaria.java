package dev.buskopan.conta_bancaria;

import java.math.BigDecimal;

public class ContaBancaria {
    private final String titular;
    private BigDecimal saldo;

    public ContaBancaria(String titular, BigDecimal saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public BigDecimal depositar(BigDecimal valor) {
        setSaldo(getSaldo().add(valor));
        return getSaldo();
    }

    public BigDecimal sacar(BigDecimal valor) {
        setSaldo(getSaldo().subtract(valor));
        return getSaldo();
    }

    public BigDecimal transferencia(ContaBancaria destinatario, BigDecimal valor) {
        this.sacar(valor);
        destinatario.depositar(valor);
        return getSaldo();
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
