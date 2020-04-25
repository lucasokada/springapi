package com.springapi.api.controller.domain;

import com.springapi.api.controller.domain.service.OrdemServicoService;
import com.springapi.api.model.ComentarioInput;
import com.springapi.api.model.ComentarioModel;
import com.springapi.api.model.Comentarios;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ordem-servico/{ordemServicoId}/comentarios")
public class ComentarioController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComentarioModel adicionar(@PathVariable Integer ordemServicoId, @RequestBody @Valid ComentarioInput comentarioInput) {
        Comentarios comentario = ordemServicoService.addComentario(ordemServicoId, comentarioInput.getDescricao());

        return toModel(comentario);
    }

    private ComentarioModel toModel(Comentarios comentario) {
        return modelMapper.map(comentario, ComentarioModel.class);
    }
}
