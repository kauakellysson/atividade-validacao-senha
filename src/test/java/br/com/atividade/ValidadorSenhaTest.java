package br.com.atividade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class ValidadorSenhaTest {

    @Test
    void senhaQueAtendeAosRequisitosDeveSerValida() {
        ResultadoValidacao resultado = ValidadorSenha.validar("Senha12!");

        assertTrue(resultado.isValida());
        assertTrue(resultado.getErros().isEmpty());
    }

    @Test
    void deveInformarQuandoSenhaTemMenosDeOitoCaracteres() {
        ResultadoValidacao resultado = ValidadorSenha.validar("A12!");

        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains(
                "A senha deve ter pelo menos 8 caracteres"));
    }

    @Test
    void deveInformarQuandoFaltamDoisDigitos() {
        ResultadoValidacao resultado = ValidadorSenha.validar("SenhaBoa!");

        assertTrue(resultado.getErros().contains(
                "A senha deve conter pelo menos 2 dígitos"));
    }

    @Test
    void deveInformarQuandoFaltaUmaLetraMaiuscula() {
        ResultadoValidacao resultado = ValidadorSenha.validar("senha12!");

        assertTrue(resultado.getErros().contains(
                "A senha deve conter pelo menos uma letra maiúscula"));
    }

    @Test
    void deveInformarQuandoFaltaUmCaractereEspecial() {
        ResultadoValidacao resultado = ValidadorSenha.validar("Senha123");

        assertTrue(resultado.getErros().contains(
                "A senha deve conter pelo menos um caractere especial"));
    }

    @Test
    void deveRetornarTodosOsErrosEncontrados() {
        ResultadoValidacao resultado = ValidadorSenha.validar("myp");

        assertEquals(List.of(
                "A senha deve ter pelo menos 8 caracteres",
                "A senha deve conter pelo menos 2 dígitos",
                "A senha deve conter pelo menos uma letra maiúscula",
                "A senha deve conter pelo menos um caractere especial"
        ), resultado.getErros());
    }
}
