package com.nascimentodev.usuario.business;

import com.nascimentodev.usuario.business.converter.UsuarioConverter;
import com.nascimentodev.usuario.business.dto.UsuarioDTO;
import com.nascimentodev.usuario.infrastructure.entity.Usuario;
import com.nascimentodev.usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new UsuarioConverter().paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
    }

}
