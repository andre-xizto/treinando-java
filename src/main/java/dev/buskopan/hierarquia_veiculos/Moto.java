package dev.buskopan.hierarquia_vericulos;

public class Moto extends Veiculo{
    private final boolean temCarenagem;

    public Moto(String marca, int ano, boolean temCarenagem) {
        super(marca, ano);
        this.temCarenagem = temCarenagem;
    }

    @Override
    protected String exibirDetalhes() {
        return "Marca: "+marca+",Ano: "+ano+",Tem carenagem? "+temCarenagem;
    }
}
