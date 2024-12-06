package dev.buskopan.hierarquia_veiculos;

public abstract class Veiculo {
    protected String marca;
    protected int ano;

    public Veiculo(String marca, int ano) {
        this.marca = marca;
        this.ano = ano;
    }

    protected abstract String exibirDetalhes();
    }
