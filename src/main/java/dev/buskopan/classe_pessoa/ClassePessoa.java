package dev.buskopan.classe_pessoa;

public class ClassePessoa {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("André", 20);
        System.out.println("Nome: "+p1.getNome());
        System.out.println("Idade: "+p1.getIdade());

        p1.setNome("Dedé");
        p1.setIdade(18);

        System.out.println("Nome alterado para: " + p1.getNome());
        System.out.println("Idade alterada para: " + p1.getIdade());
    }
}

