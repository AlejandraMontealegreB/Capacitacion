package co.samtel.usuario.gen.dao;

import co.samtel.usuario.gen.entity.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class UsuarioDao implements PanacheRepository<Usuario> {


}
