package com.empire.service.service;

import com.empire.service.model.entity.UsuarioEntity;
import com.empire.service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    public UsuarioEntity salvar(UsuarioEntity usuario){
        return usuarioRepository.save(usuario);
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuario = usuarioRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("Dados inválidos"));

        return User
                .builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .roles("USER")
                .build();
    }
}
