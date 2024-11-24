package com.sementesdobrasil.util;

import com.sementesdobrasil.model.Segurado;

public class SessaoUsuario {
    private static Segurado usuarioLogado;

    // Impede a criação de instâncias
    private SessaoUsuario() {}

    // Recupera o usuário logado
    public static Segurado getUsuarioLogado() {
        return usuarioLogado;
    }

    // Define o usuário logado
    public static void setUsuarioLogado(Segurado segurado) {
        usuarioLogado = segurado;
    }

    // Limpa a sessão (desfaz o login)
    public static void limparSessao() {
        usuarioLogado = null;
    }
}
