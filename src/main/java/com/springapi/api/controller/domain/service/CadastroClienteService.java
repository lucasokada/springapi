package com.springapi.api.controller.domain.service;

import com.springapi.api.controller.domain.model.Cliente;
import com.springapi.api.controller.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //indica que a classe e um serviço
public class CadastroClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente); //o metodo nao tem regras de negocio por enquanto, contudo o metodo ja esta aqui
                                                    //nao precisa mexer em muita coisa quando precisar
    }

    public void excluir(Integer clienteId) {
        clienteRepository.deleteById(clienteId );
    }
}
