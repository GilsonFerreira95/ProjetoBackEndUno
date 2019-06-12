package interfaces;

import java.util.List;
import model.UsuarioModel;
/**
 *
 * @author gilso
 */
public interface InterfaceUsuario {
    public abstract void inserir(UsuarioModel entidade);
    public abstract void editar(UsuarioModel entidade, int idUsuario);
    public List<UsuarioModel> listarUsuario();
    public abstract void deletar(int idusuario);
}
