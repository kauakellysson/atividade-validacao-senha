package br.com.atividade;

import java.util.ArrayList;
import java.util.List;

public final class ValidadorSenha {
    private ValidadorSenha() {
    }

    public static ResultadoValidacao validar(String senha) {
        List<String> erros = new ArrayList<>();

        if (senha == null || senha.length() < 8) {
            erros.add("A senha deve ter pelo menos 8 caracteres");
        }

        long quantidadeDeDigitos = senha == null
                ? 0
                : senha.chars().filter(Character::isDigit).count();
        if (quantidadeDeDigitos < 2) {
            erros.add("A senha deve conter pelo menos 2 dígitos");
        }

        boolean temLetraMaiuscula = senha != null
                && senha.chars().anyMatch(Character::isUpperCase);
        if (!temLetraMaiuscula) {
            erros.add("A senha deve conter pelo menos uma letra maiúscula");
        }

        boolean temCaractereEspecial = senha != null
                && senha.chars().anyMatch(caractere ->
                        !Character.isLetterOrDigit(caractere)
                                && !Character.isWhitespace(caractere));
        if (!temCaractereEspecial) {
            erros.add("A senha deve conter pelo menos um caractere especial");
        }

        return new ResultadoValidacao(erros.isEmpty(), erros);
    }
}
