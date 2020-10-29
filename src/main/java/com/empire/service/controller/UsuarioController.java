package com.empire.service.controller;

import com.empire.service.model.entity.UsuarioEntity;
import com.empire.service.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    @GetMapping
    public List<UsuarioEntity> listarTodos(){ return usuarioRepository.findAll(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody UsuarioEntity usuario){
        usuarioRepository.save(usuario);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {usuarioRepository.deleteById(id);}
}
