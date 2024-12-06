package dev.buskopan.hierarquia_vericulos;

public class HierarquiaVeiculos {
    public static void main(String[] args) {
        Veiculo corolla = new Carro("Toyota", 2024, 4);
        System.out.println(corolla.exibirDetalhes());

        Veiculo cb600 = new Moto("Honda", 2024, true);
        System.out.println(cb600.exibirDetalhes());
    }
}
