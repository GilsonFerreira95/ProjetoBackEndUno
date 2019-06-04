/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.UsuarioModel;

/**
 *
 * @author gilso
 */
public interface InterfaceUsuario {
    public abstract void inserir(UsuarioModel entidade);
    public abstract void editar(UsuarioModel entidade);
    public List<UsuarioModel> listarUsuario();
    public abstract void deletar(int idusuario);
    
    
    
}
