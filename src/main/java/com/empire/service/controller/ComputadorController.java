package com.empire.service.controller;


import com.empire.service.model.dto.ComputadorDTO;
import com.empire.service.model.entity.ComputadorEntity;
import com.empire.service.model.entity.LaboratorioEntity;
import com.empire.service.repository.ComputadorRepository;
import com.empire.service.repository.LaboratorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/computadores")
@RequiredArgsConstructor
public class ComputadorController {
    private final ComputadorRepository repository;
    private final LaboratorioRepository laboratorioRepository;

    @GetMapping
    @Cacheable(value = "listaComputadores")
    public List<ComputadorDTO> listar(@RequestParam(required = false) Integer idLaboratorio){
        if(idLaboratorio == null){
            List<ComputadorEntity> computadores = repository.findAll((Sort.by(Sort.Direction.ASC,"laboratorio")));
            return ComputadorDTO.converter(computadores);
        }else{
            List<ComputadorEntity> computadores = repository.findByLaboratorioId(idLaboratorio);
            return ComputadorDTO.converter(computadores);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CacheEvict(value = "listaComputadores", allEntries = true)
    public ComputadorEntity save(@RequestBody ComputadorDTO dto){

        Integer idLab = dto.getIdLaboratorio();
        LaboratorioEntity laboratorio = laboratorioRepository
                .findById(idLab)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST,"Lab não encontrado"));

        ComputadorEntity computer = new ComputadorEntity();
        computer.setId(dto.getId());
        computer.setDescricao(dto.getDescricao());
        computer.setLaboratorio(laboratorio);
        return repository.save(computer);
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = "listaComputadores", allEntries = true)
    public void excluir(@PathVariable Integer id){
        repository.deleteById(id);
    }


}
