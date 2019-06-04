/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.UsuarioDao;
import model.UsuarioModel;
import interfaces.InterfaceUsuario;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author gilso
 */
public class UsuarioController implements InterfaceUsuario{
    private UsuarioDao dao;
        
    public UsuarioController(){
        this.dao = new UsuarioDao();
    }
    
    @Override
    public void inserir(UsuarioModel entidade) {
        dao.inserir(entidade);
    }

    @Override
    public void editar(UsuarioModel entidade) {
        dao.editar(entidade);
    }

    @Override
    public List<UsuarioModel> listarUsuario() {
        List<UsuarioModel> usuarios = new ArrayList<>();
        usuarios = dao.listarUsuario();
        return usuarios;
        
    }

    @Override
    public void deletar(int idusuario) {
        dao.deletar(idusuario);
    }
    
    public List<UsuarioModel> listarPorId(int idUsuario){
        List<UsuarioModel> usuarios = new ArrayList<>();
        usuarios = dao.listarPorId(idUsuario);
        return usuarios;
    }
    
}
