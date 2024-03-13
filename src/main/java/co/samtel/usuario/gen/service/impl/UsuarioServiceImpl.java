package co.samtel.usuario.gen.service.impl;

import co.samtel.usuario.gen.controller.UsuarioController;
import co.samtel.usuario.gen.dao.UsuarioDao;
import co.samtel.usuario.gen.entity.Usuario;
import co.samtel.usuario.gen.service.contract.IUsuarioService;
import co.samtel.usuario.gen.type.UsuarioTypeInput;
import co.samtel.usuario.gen.utils.ApplicationExeption;
import co.samtel.usuario.gen.utils.UsuarioMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static co.samtel.usuario.gen.constant.Constant.ERROR_SERVICIO;
import static io.quarkus.arc.ComponentsProvider.LOG;

@ApplicationScoped
public class UsuarioServiceImpl {

    private static final Logger Log = LoggerFactory.getLogger(UsuarioController.class);

    @Inject
    UsuarioMapper usuarioMapper;

    @Inject
    UsuarioDao usuarioDao;

    public UsuarioTypeInput crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia CrearUsuarioImpl");

        Usuario usuario = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
        usuarioDao.persist(usuario);
        //iusuarioService.persist( usuario);
        LOG.info("Persis usuario");


        try {


        } catch (ApplicationExeption e) {
            throw new ApplicationExeption(ERROR_SERVICIO + e.getMessage());
        }

        return null;

    }
}



