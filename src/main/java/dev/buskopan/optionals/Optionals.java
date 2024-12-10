package dev.buskopan.optionals;

import java.util.Optional;
import java.util.Random;

public class Optionals {
    public static void main(String[] args) {

        String s = "Minha string!";
        Optional<Integer> numero = converterEmNumero(s);
        System.out.println(numero.orElse(0));

        String cpf = "12345678909";
        Optional<Integer> cpfEmNumero = converterEmNumero(cpf);
        cpfEmNumero.ifPresentOrElse(System.out::println, () ->
                System.out.println("Erro ao transformar em número"));

        String cep = "12345678";
        Optional<Integer> cepEmNumero = converterEmNumero(cep);
        System.out.println(cpfEmNumero.orElseGet(() -> new Random().nextInt(10)));

        String rg = "325346425";
        Optional<Integer> rgEmNumero = converterEmNumero(rg);
        System.out.println(cpfEmNumero.orElseThrow(() -> new RuntimeException("deu ruim")));
    }

    private static Optional<Integer> converterEmNumero(String s) {
        try {
            int i = Integer.parseInt(s);
            return Optional.of(i);
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}
