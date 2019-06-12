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
    public TarefasWs() {
    }

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
    public void insereTarefa(TarefasModel tarefa){
        controle.cadastrar(tarefa);
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("tarefas/{id}")
    public void atualizaUsuario(@PathParam("id") int idTarefa ,TarefasModel tarefa){
        controle.editar(tarefa,idTarefa);
        System.out.println("Editando Tarefa" + tarefa.getDescricao());
    }
}
