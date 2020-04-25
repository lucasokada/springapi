package com.springapi.api.model;

import com.springapi.api.controller.domain.model.StatusOrdemServico;

import java.time.LocalDateTime;

public class OrdemServicoModel {
    private Integer id;
    private ClienteResumoModel clienteResumoModel;
    private String descricao;
    private Double preco;
    private StatusOrdemServico statusOrdemServico;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteResumoModel getClienteResumoModel() {
        return clienteResumoModel;
    }

    public void setClienteResumoModel(ClienteResumoModel clienteResumoModel) {
        this.clienteResumoModel = clienteResumoModel;
    }

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

    public StatusOrdemServico getStatusOrdemServico() {
        return statusOrdemServico;
    }

    public void setStatusOrdemServico(StatusOrdemServico statusOrdemServico) {
        this.statusOrdemServico = statusOrdemServico;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }
}
