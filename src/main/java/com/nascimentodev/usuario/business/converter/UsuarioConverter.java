package com.nascimentodev.usuario.business.converter;

import com.nascimentodev.usuario.business.dto.EnderecoDTO;
import com.nascimentodev.usuario.business.dto.TelefoneDTO;
import com.nascimentodev.usuario.business.dto.UsuarioDTO;
import com.nascimentodev.usuario.infrastructure.entity.Endereco;
import com.nascimentodev.usuario.infrastructure.entity.Telefone;
import com.nascimentodev.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO) {
        /* Sem o builder. Com o builder fica mais limpo
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        return usuario;
         */
        return  Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .endereco(paraListaEndereco(usuarioDTO.getEnderecos()))
                .telefone(paraListaTelefone(usuarioDTO.getTelefones()))
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTO) {
        return enderecoDTO.stream().map(this::paraEndereco).toList();
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .cep(enderecoDTO.getCep())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .estado(enderecoDTO.getEstado())
                .numero(enderecoDTO.getNumero())
                .build();
    }

    public List<Telefone> paraListaTelefone(List<TelefoneDTO> telefoneDTO) {
        return telefoneDTO.stream().map(this::paraTelefone).toList();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO) {
        return Telefone.builder()
                .telefone(telefoneDTO.getTelefone())
                .ddd(telefoneDTO.getDdd())
                .build();
    }


    // ######

    public UsuarioDTO paraUsuarioDTO(Usuario usuarioDTO) {
        return  UsuarioDTO.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEnderecoDTO(usuarioDTO.getEndereco()))
                .telefones(paraListaTelefoneDTO(usuarioDTO.getTelefone()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecoDTO) {
        return enderecoDTO.stream().map(this::paraEnderecoDTO).toList();
    }

    public EnderecoDTO paraEnderecoDTO(Endereco endereco) {
        return EnderecoDTO.builder()
                .id(endereco.getId())
                .rua(endereco.getRua())
                .cep(endereco.getCep())
                .cidade(endereco.getCidade())
                .complemento(endereco.getComplemento())
                .estado(endereco.getEstado())
                .numero(endereco.getNumero())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefoneDTO) {
        return telefoneDTO.stream().map(this::paraTelefoneDTO).toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefone) {
        return TelefoneDTO.builder()
                .id(telefone.getId())
                .telefone(telefone.getTelefone())
                .ddd(telefone.getDdd())
                .build();
    }

    public Usuario updateUsuario(UsuarioDTO usuarioDTO, Usuario entity) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome() != null ? usuarioDTO.getNome() : entity.getNome())
                .id(entity.getId())
                .senha(usuarioDTO.getSenha() != null ? usuarioDTO.getSenha() : entity.getSenha())
                .email(usuarioDTO.getEmail() != null ? usuarioDTO.getEmail() : entity.getEmail())
                .endereco(entity.getEndereco())
                .telefone(entity.getTelefone())
                .build();
    }

    public Endereco updateEndereco(EnderecoDTO enderecoDTO, Endereco entity) {
        return Endereco.builder()
                .id(entity.getId())
                .rua(enderecoDTO.getRua() != null ? enderecoDTO.getRua() : entity.getRua())
                .cep(enderecoDTO.getCep() != null ? enderecoDTO.getCep() : entity.getCep())
                .cidade(enderecoDTO.getCidade() != null ? enderecoDTO.getCidade(): entity.getCidade())
                .estado(enderecoDTO.getEstado() != null ? enderecoDTO.getEstado() : entity.getEstado())
                .complemento(enderecoDTO.getComplemento() != null ? enderecoDTO.getComplemento() : entity.getComplemento())
                .numero(enderecoDTO.getNumero() != null ? enderecoDTO.getNumero() : entity.getNumero())
                .build();
    }

    public Telefone updateTelefone(TelefoneDTO telefoneDTO, Telefone entity) {
        return Telefone.builder()
                .id(entity.getId())
                .telefone(telefoneDTO.getTelefone() != null ? telefoneDTO.getTelefone() : entity.getTelefone())
                .ddd(telefoneDTO.getDdd() != null ? telefoneDTO.getDdd() : entity.getDdd())
                .build();
    }
}
