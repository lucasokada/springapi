package com.springapi.api.controller.domain.repository;

import com.springapi.api.controller.domain.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer> {

}
