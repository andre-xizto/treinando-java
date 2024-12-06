package dev.buskopan.hierarquia_vericulos;

public class Carro extends Veiculo{
    private final int numeroPortas;
    public Carro(String marca, int ano, int numeroPortas) {
        super(marca, ano);
        this.numeroPortas = numeroPortas;
    }

    @Override
    protected String exibirDetalhes() {
        return "Marca: "+marca+",Ano: "+ano+",Número de portas: "+numeroPortas;
    }
}
