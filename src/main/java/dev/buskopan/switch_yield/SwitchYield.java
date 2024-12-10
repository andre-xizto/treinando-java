package dev.buskopan.switch_yield;

import dev.buskopan.arvore_binaria_busca.No;

import java.util.Optional;

public class SwitchYield {
    public static void main(String[] args) {
        Optional<UserRole> OProle = getRole();
        UserRole role = OProle.orElse(UserRole.NORMAL);

        String result = switch (role) {
            case ADMIN -> {
                System.out.println("Processando...");
                yield "User é admin";
            }
            case NORMAL -> {
                System.out.println("Processando...");
                yield "User é normal";
            }
        };

        System.out.println(result);
    }

    public static Optional<UserRole> getRole() {
        int random = (int) Math.floor(Math.random() * 10);
        return random > 5 ? Optional.of(UserRole.ADMIN) : Optional.of(UserRole.NORMAL);
    }
}

enum UserRole {
    ADMIN,
    NORMAL
}
