package co.samtel.usuario.gen.service.impl;

import co.samtel.usuario.gen.controller.UsuarioController;
import co.samtel.usuario.gen.dao.UsuarioDao;
import co.samtel.usuario.gen.entity.Usuario;
import co.samtel.usuario.gen.type.UsuarioTypeInput;
import co.samtel.usuario.gen.type.UsuarioTypeResponse;
import co.samtel.usuario.gen.utils.ApplicationExeption;
import co.samtel.usuario.gen.utils.UsuarioMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Collections;
import java.util.List;

import static co.samtel.usuario.gen.constant.Constant.ERROR_SERVICIO;
import static io.quarkus.arc.ComponentsProvider.LOG;

@ApplicationScoped
public class UsuarioServiceImpl {

    private static final Logger Log = LoggerFactory.getLogger(UsuarioController.class);

    @Inject
    UsuarioMapper usuarioMapper;
    
    @Inject
    UsuarioDao usuarioDao;
    
    @Transactional
    public UsuarioTypeInput crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia CrearUsuarioImpl");
        UsuarioTypeInput usuarioTypeResponses;

        try {
            Usuario usuario = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
            usuarioDao.persist(usuario);
            usuarioTypeResponses = usuarioMapper.clienteEntityToType(usuario);
            usuarioDao.persist(usuario);
            LOG.info("Finaliza crear usuario");

        } catch (ApplicationExeption e) {
            LOG.error("se presento erro al listar usuario por ID");
            throw new ApplicationExeption(ERROR_SERVICIO + e.getMessage());
        }
        return usuarioTypeResponses;
    }

    public List<UsuarioTypeResponse> listarUsuario(Integer id_user){
        LOG.info("Inicia Listarusuario");
        try{
            Long id = Long.valueOf(id_user);
            Usuario user = usuarioDao.findById(id);
            UsuarioTypeResponse response = usuarioMapper.usuarioEntityToTypeResponse(user);
            LOG.info("finaliza listar usuario id");
            return Collections.singletonList(response);
        }catch (ApplicationExeption e){
            LOG.error("se presento erro al listar usuario por ID");
            throw new ApplicationExeption(ERROR_SERVICIO + e.getMessage());
        }
    }

    @Transactional
    public UsuarioTypeInput updateUsuario(Integer id_user, UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia actualizarUsuario");
        try {
            Long id = Long.valueOf(id_user);
            Usuario user = usuarioDao.findById(id);
            UsuarioTypeResponse response = usuarioMapper.usuarioEntityToTypeResponse(user);
            LOG.info("finaliza listar usuario id");
            }catch (ApplicationExeption e){
                LOG.error("se presento erro al actualizar usuario por ID");
             throw new ApplicationExeption(ERROR_SERVICIO + e.getMessage());
            }
        return usuarioTypeInput;
    }

}



