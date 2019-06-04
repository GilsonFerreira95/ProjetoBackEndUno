/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import model.UsuarioModel;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import controller.UsuarioController;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author gilso
 */
@Path("/usuarios")
public class UsuarioWs {

    Gson gson = new Gson();
    UsuarioModel u = new UsuarioModel();
    UsuarioController controle = new UsuarioController();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public UsuarioWs() {
    }

    /**
     * Retrieves representation of an instance of ws.UsuarioWs
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("usuario")
    public List<UsuarioModel> listaTodos() {
        System.out.println("listaTodos");
        return controle.listarUsuario();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("usuario/{id}")
    public List<UsuarioModel> listaUsuariosId(@PathParam("id") String id) {
        System.out.println("listarPorId" + id);
        return controle.listarPorId(Integer.parseInt(id));
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void remove(@PathParam("id") int id) {
        controle.deletar(id);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void inserir(UsuarioModel usuario) {
        System.out.println("Criando Usuario");
        controle.inserir(usuario);

    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void editar(UsuarioModel usuario) {
        System.out.println("Editando Usuario" + usuario.getNome());
        controle.editar(usuario);

    }

    /**
     * PUT method for updating or creating an instance of UsuarioWs
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
