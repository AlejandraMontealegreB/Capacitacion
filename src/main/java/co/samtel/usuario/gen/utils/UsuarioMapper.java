package co.samtel.usuario.gen.utils;


import co.samtel.usuario.gen.entity.Usuario;
import co.samtel.usuario.gen.type.UsuarioTypeInput;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class UsuarioMapper {

    public Usuario usuarioTypeToEntity(UsuarioTypeInput usuarioType){
        return new ModelMapper().map(usuarioType, Usuario.class);
    }
}
