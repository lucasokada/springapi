package com.springapi.api.controller.domain.service;

import com.springapi.api.controller.domain.model.OrdemServico;
import com.springapi.api.controller.domain.model.StatusOrdemServico;
import com.springapi.api.controller.domain.repository.ComentarioRepository;
import com.springapi.api.controller.domain.repository.OrdemServicoRepository;
import com.springapi.api.exceptionhandler.ExceptionNegocio;
import com.springapi.api.model.Comentarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public OrdemServico criar(OrdemServico ordemServico) {

        ordemServico.setStatusOrdemServico(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());

        return ordemServicoRepository.save(ordemServico);
    }

    public void finalizar(Integer ordemServicoId) {
        OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoId)
                .orElseThrow(() -> new ExceptionNegocio("ordem de servico nao encotrada"));

        if(!StatusOrdemServico.ABERTA.equals(ordemServico.getStatusOrdemServico())) {
            throw new ExceptionNegocio("Ordem de servico nao pode ser finalizada");
        }

        ordemServico.setStatusOrdemServico(StatusOrdemServico.FINALIZADA);
        ordemServico.setDataFinalizacao(LocalDateTime.now());
    }

    public Comentarios addComentario(Integer ordemServicoId, String descricao) {

        OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoId)
                .orElseThrow(() -> new ExceptionNegocio("ordem de servico nao encotrada"));

        Comentarios comentario = new Comentarios();
        comentario.setDaraEnvio(LocalDateTime.now());
        comentario.setDescricao(descricao);
        comentario.setOrdemServico(ordemServico);

        return comentarioRepository.save(comentario);
    }

}
