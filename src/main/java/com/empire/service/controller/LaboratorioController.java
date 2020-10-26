package com.empire.service.controller;


import com.empire.service.model.entity.LaboratorioEntity;
import com.empire.service.repository.LaboratorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laboratorios")
@CrossOrigin("*")
@RequiredArgsConstructor
public class LaboratorioController {
    private final LaboratorioRepository laboratorioRepository;

    @GetMapping
    public List<LaboratorioEntity> listarTodos(){
        return laboratorioRepository.findAll();
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Integer id){
        laboratorioRepository.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LaboratorioEntity salvar(@RequestBody LaboratorioEntity laboratorio){
        return laboratorioRepository.save(laboratorio);
    }

}
