package com.springapi.api.controller.domain.repository;


import com.springapi.api.controller.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //indica que a interface é um componente do spring
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    //operações básicas já disponíveis por causa do spring-jpa

    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome);
    Cliente findByEmail(String email);
}
