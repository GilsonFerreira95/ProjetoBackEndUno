/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TarefasDao;
import interfaces.InterfaceTarefas;
import java.util.List;
import model.TarefasModel;
import java.util.ArrayList;

/**
 *
 * @author gilso
 */
public class TarefaController implements InterfaceTarefas{
    private TarefasDao dao;
    
    public TarefaController(){
        this.dao = new TarefasDao();
    }

    @Override
    public void cadastrar(TarefasModel entidade) {
        dao.cadastrar(entidade);
    }

    @Override
    public void editar(TarefasModel entidade) {
        dao.editar(entidade);
    }

    @Override
    public List<TarefasModel> listarTarefas() {
       List tarefas = new ArrayList();
        tarefas =  dao.listarTarefas();
        return tarefas;
    }

    @Override
    public void deletar(int idTarefa) {
        dao.deletar(idTarefa);
    }

    public List<TarefasModel> listarPorId(int idTarefas) {
       List tarefas = new ArrayList();
        tarefas =  dao.listarPorId(idTarefas);
        return tarefas;
    }
  
    
}
