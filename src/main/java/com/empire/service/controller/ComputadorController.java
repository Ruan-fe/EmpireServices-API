package com.empire.service.controller;


import com.empire.service.model.dto.ComputadorDTO;
import com.empire.service.model.entity.ComputadorEntity;
import com.empire.service.model.entity.LaboratorioEntity;
import com.empire.service.repository.ComputadorRepository;
import com.empire.service.repository.LaboratorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/computadores")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ComputadorController {
    private final ComputadorRepository repository;
    private final LaboratorioRepository laboratorioRepository;

    @GetMapping
    public List<ComputadorDTO> listar(){
        List<ComputadorEntity> computadores = repository.findAll();
        return ComputadorDTO.converter(computadores);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComputadorEntity save(@RequestBody ComputadorDTO dto){
        Integer idLab = dto.getIdLaboratorio();

        LaboratorioEntity laboratorio = laboratorioRepository
                .findById(idLab)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST,"Lab não encontrada"));
        ComputadorEntity computer = new ComputadorEntity();
        computer.setId(dto.getId());
        computer.setDescricao(dto.getDescricao());
        computer.setLaboratorio(laboratorio);
        return repository.save(computer);
    }

    @DeleteMapping("{id}")
    public void excluir(@PathVariable Integer id){
        repository.deleteById(id);
    }


}
