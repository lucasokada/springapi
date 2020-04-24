package com.springapi.api.controller;

import com.springapi.api.controller.domain.model.Cliente;
import com.springapi.api.controller.domain.repository.ClienteRepository;
import com.springapi.api.controller.domain.service.CadastroClienteService;
import com.springapi.api.exceptionhandler.ExceptionNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.lang.reflect.Executable;
import java.util.List;
import java.util.Optional;

@RestController //controlador rest
@RequestMapping("/clientes")
public class ClientController {

    //@PersistenceContext
    //private EntityManager manager;

    @Autowired //injeção de dependência. instancia de clienterepository nesse local
    private ClienteRepository clienteRepository;

    @Autowired
    private CadastroClienteService cadastroClienteService;

    @GetMapping() /*("/clientes")   versao1*/
    public List<Cliente> listar() {
         /*return manager.createQuery("select c from Cliente as c", Cliente.class) // versao-1
                .getResultList();*/
         return clienteRepository.findByNomeContaining("lu"); //versao-2
    }

    @GetMapping("/{clienteId}") //{path}       /*("/clientes/{clienteId}")  vresao 1*/
    public ResponseEntity<Cliente> buscar(@PathVariable Integer clienteId) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);

        //versao-2
        if(cliente.isPresent()) { //se existir alguma coisa dentro de cliente
            return ResponseEntity.ok(cliente.get()); //retorna codigo 200
        }

        return ResponseEntity.notFound().build();

        //return cliente.orElse(null); //extrai oque tem dentro de optional. se nao tiver nada, retorna null //versao-1
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) { //transforma o corpo da requisiçao em um objeto cliente
        //return clienteRepository.save(cliente); versao 1

        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());

        if(clienteExistente != null && !clienteExistente.equals(cliente)) {
            throw new ExceptionNegocio("Esse email ja existe");
        }

        return cadastroClienteService.salvar(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Integer clienteId, @RequestBody Cliente cliente) {
        if(!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }

        cliente.setId(clienteId);
        //cliente = clienteRepository.save(cliente); versao 1
        cliente = cadastroClienteService.salvar(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> delete(@PathVariable Integer clienteId) {
        if(!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }

        //clienteRepository.deleteById(clienteId); versao 1
        cadastroClienteService.excluir(clienteId);

        return ResponseEntity.noContent().build(); //nao retorna corpo
    }
}
//content negociation: cliente negocia com o servidor o formato da informaçao(json, xml ...)