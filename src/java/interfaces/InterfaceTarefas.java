package interfaces;

import java.util.List;
import model.TarefasModel;
/**
 *
 * @author gilso
 */
public interface InterfaceTarefas {
    public abstract void cadastrar(TarefasModel entidade);
    public abstract void editar(TarefasModel entidade, int idTarefa);
    public abstract List<TarefasModel> listarTarefas();
    public abstract void deletar(int idTarefa);
}
