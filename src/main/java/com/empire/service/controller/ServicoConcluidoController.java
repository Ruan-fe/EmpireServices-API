package com.empire.service.controller;

import com.empire.service.model.entity.ServicoConcluidoEntity;
import com.empire.service.model.entity.ServicoEntity;
import com.empire.service.repository.ServicoConcluidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos-concluidos")
@RequiredArgsConstructor
public class ServicoConcluidoController {
    private final ServicoConcluidoRepository servicoConcluidoRepository;

    /*@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoConcluidoEntity salvar(@RequestBody ServicoConcluidoEntity servicoConcluido){
        return servicoConcluidoRepository.save(servicoConcluido);
    }*/

    @GetMapping
    public Long buscarCount(@RequestParam(required = false) Character status){
            return servicoConcluidoRepository.countByStatus(status);
    }


}
