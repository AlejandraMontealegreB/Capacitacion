package co.samtel.usuario.gen.controller;


import co.samtel.usuario.gen.contract.V1UsuarioApi;
import co.samtel.usuario.gen.service.impl.UsuarioServiceImpl;
import co.samtel.usuario.gen.type.UsuarioTypeInput;
import co.samtel.usuario.gen.type.UsuarioTypeResponse;
import co.samtel.usuario.gen.utils.ApplicationExeption;
import jakarta.inject.Inject;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;


import static co.samtel.usuario.gen.constant.Constant.ERROR_SERVICIO;


public class UsuarioController implements V1UsuarioApi {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);
    @Inject
    UsuarioServiceImpl usuarioServiceImpl;


    @Override
    public List<UsuarioTypeResponse> crearUsuario(UsuarioTypeInput usuarioTypeInput){
        List<UsuarioTypeResponse> result;
        LOG.info("Inicia CrearUsuarioController");
        try {
            Object usuariolType = usuarioServiceImpl.
                    crearUsuario(usuarioTypeInput);
            LOG.info("Termina Crearusuario");
            result = (List<UsuarioTypeResponse>) usuariolType;

        } catch (ApplicationExeption e){
            LOG.error("Se identifica error al crear el usuario" + e.getMessage());
            throw new ArithmeticException(ERROR_SERVICIO + e.getMessage());
        }
        return result;
    }

    @Override
    public List<UsuarioTypeResponse> listarUsuario(Integer id_user) {
        return usuarioServiceImpl.listarUsuario(id_user);
    }

    @Override
    public List<UsuarioTypeResponse> listarUsuario(Integer id_user) {
        List<UsuarioTypeResponse> result;
        LOG.info("Inicia CrearUsuarioController");
        try {
            Object usuariolType = usuarioServiceImpl.
                    crearUsuario(usuarioTypeInput);
            LOG.info("Termina Crearusuario");
            result = (List<UsuarioTypeResponse>) usuariolType;

        } catch (ApplicationExeption e){
            LOG.error("Se identifica error al crear el usuario" + e.getMessage());
            throw new ArithmeticException(ERROR_SERVICIO + e.getMessage());
        }
        return result;
    }

}
