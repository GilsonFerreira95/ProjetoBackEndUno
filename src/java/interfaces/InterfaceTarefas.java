/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import java.util.List;
import model.TarefasModel;

/**
 *
 * @author gilso
 */
public interface InterfaceTarefas {
    public abstract void cadastrar(TarefasModel entidade);
    public abstract void editar(TarefasModel entidade);
    public abstract List<TarefasModel> listarTarefas();
    public abstract void deletar(int idTarefa);
    
    
    
}
