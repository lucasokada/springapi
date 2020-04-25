package com.springapi.api.controller.domain.model;

public enum StatusOrdemServico {

    ABERTA(1),
    FINALIZADA(2),
    CANCELADA(3);

    private int valor;

    StatusOrdemServico(int i) {
        valor = i;
    }
}
