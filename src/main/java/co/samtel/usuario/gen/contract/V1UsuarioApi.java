package co.samtel.usuario.gen.contract;

import co.samtel.usuario.gen.type.UsuarioTypeInput;
import co.samtel.usuario.gen.type.UsuarioTypeResponse;
import co.samtel.usuario.gen.type.UsuarioTypeUpdate;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;




import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


@Path("/v1/es")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-19T16:52:29.338484500-05:00[America/Bogota]")
public interface V1UsuarioApi {

    @POST
    @Path("/crearUsuario")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    List<UsuarioTypeResponse> crearUsuario(@Valid UsuarioTypeInput usuarioTypeInput);

    @GET
    @Path("/listUsuario/{id_user}")
    @Produces({ "application/json" })
    List<UsuarioTypeResponse> listarUsuario(@PathParam("idtbl_user") @Min(1) Integer idtblUser);

    @PUT
    @Path("/updateUsuario/{id_user}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    List<UsuarioTypeResponse> updateUsuario(@Valid UsuarioTypeUpdate body);
}
