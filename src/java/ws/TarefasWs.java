/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import model.TarefasModel;
import com.google.gson.Gson;
import controller.TarefaController;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author gilso
 */
@Path("tarefas")
public class TarefasWs {
    TarefaController controle = new TarefaController();
    TarefasModel tarefas = new TarefasModel();
    Gson gson  = new Gson();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public TarefasWs() {
    }

    /**
     * Retrieves representation of an instance of ws.TarefasWs
     * @return an instance of java.lang.String
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    
    @Path("tarefas")
    public String getJson() {
        
        String resultado = gson.toJson(controle.listarTarefas());
        return resultado;
        
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
   
    @Path("tarefas/{id}")
    public String getTarefasId(@PathParam("id") int id){
        
        String resultado = gson.toJson(controle.listarPorId(id));
        return resultado;
    }
    
    @DELETE
    @Path("tarefas/{id}")
    public void deletaTarefa(@PathParam("id") int id ){
        
        controle.deletar(id);
 }  
    
    @POST
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("tarefas/inserir")
    public void insereUsuario(String tarefa){
        gson.fromJson(tarefa, TarefasModel.class );
        controle.cadastrar(tarefas);
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("tarefas/atualizar/{id}")
    public void atualizaUsuario(String tarefa){
        gson.fromJson(tarefa, TarefasModel.class);
        controle.editar(tarefas);
        
        
    }
    

    /**
     * PUT method for updating or creating an instance of TarefasWs
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
