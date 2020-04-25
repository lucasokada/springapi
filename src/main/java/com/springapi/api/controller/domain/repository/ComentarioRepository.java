package com.springapi.api.controller.domain.repository;

import com.springapi.api.model.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentarios, Integer> {
}
