package co.samtel.usuario.gen.utils;


import co.samtel.usuario.gen.entity.Usuario;
import co.samtel.usuario.gen.type.UsuarioTypeInput;
import co.samtel.usuario.gen.type.UsuarioTypeResponse;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioMapper {

    public Usuario usuarioTypeToEntity(UsuarioTypeInput usuarioType){
        return new ModelMapper().map(usuarioType, Usuario.class);
    }

    public UsuarioTypeInput clienteEntityToType(Usuario usuario) {
        return new ModelMapper().map(usuario, UsuarioTypeInput.class);
    }

    public UsuarioTypeResponse usuarioEntityToTypeResponse(Usuario usuario){
        return new ModelMapper().map(usuario, UsuarioTypeResponse.class);
    }

    public List<Usuario> usuarioTypeListToEntity(
            List<UsuarioTypeInput> usuarioTypeList){
        return usuarioTypeList.stream().map(usuario -> usuarioTypeToEntity(usuario))
                .collect(Collectors.toList());
    }
}
