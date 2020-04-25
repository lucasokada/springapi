package com.springapi.api.controller;

import com.springapi.api.controller.domain.model.OrdemServico;
import com.springapi.api.controller.domain.repository.OrdemServicoRepository;
import com.springapi.api.controller.domain.service.OrdemServicoService;
import com.springapi.api.model.OrdemServicoInput;
import com.springapi.api.model.OrdemServicoModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServicoModel criar(@Valid @RequestBody OrdemServicoInput ordemServicoInput) {
        OrdemServico ordemServico = toEntity(ordemServicoInput);

        return toModel(ordemServicoService.criar(ordemServico));
    }

    @GetMapping
    public List<OrdemServicoModel> listar() {
        return toCollectionModel(ordemServicoRepository.findAll());
    }

    @GetMapping(path = "/{oremServicoId}")
    public ResponseEntity<OrdemServicoModel> buscar(@PathVariable Integer ordemServicoId) {

        Optional<OrdemServico>ordemServico = ordemServicoRepository.findById(ordemServicoId);

        if(ordemServico.isPresent()) {
            OrdemServicoModel ordemServicoModel = toModel(ordemServico.get());
            return ResponseEntity.ok(ordemServicoModel);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{ordemServicoId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Integer ordemServicoId) {

        ordemServicoService.finalizar(ordemServicoId);
    }

    private OrdemServicoModel toModel(OrdemServico ordemServico) {
        return modelMapper.map(ordemServico, OrdemServicoModel.class);
    }

    private List<OrdemServicoModel> toCollectionModel(List<OrdemServico> ordemServico) {
        return ordemServico.stream()
                .map(ordemServico1 -> toModel(ordemServico1))
                .collect(Collectors.toList());
    }

    private OrdemServico toEntity(OrdemServicoInput ordemServicoInput) {

        return modelMapper.map(ordemServicoInput, OrdemServico.class);
    }
}
