package com.springapi.api.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrdemServicoInput {
    @NotBlank
    private String descricao;

    @NotNull
    private Double preco;

    @Valid
    @NotNull
    private ClienteIdInput clienteId;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public ClienteIdInput getClienteId() {
        return clienteId;
    }

    public void setClienteId(ClienteIdInput clienteId) {
        this.clienteId = clienteId;
    }
}
