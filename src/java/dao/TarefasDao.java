/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.TarefasModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.TarefasModel;
import interfaces.InterfaceTarefas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author gilso
 */
public class TarefasDao implements InterfaceTarefas {
    
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    @Override
    public void cadastrar(TarefasModel entidade) {
        this.con = connection.ConnectionFactory.getConnection();
        String sql = "INSERT INTO Tarefas (Descricao, TempoEstimado, Categoria, "
                + "Situacao, idUsuario) VALUES (?, ?, ?, ?, ?)";
        
        try{
            this.stmt = this.con.prepareStatement(sql);
            this.stmt.setString(1, entidade.getDescricao());
            this.stmt.setString(2, entidade.getTempoEstimado());
            this.stmt.setString(3, entidade.getCategoria());
            this.stmt.setString(4, entidade.getSituacao());
            this.stmt.setInt(5, entidade.getUsuarioId().getId());
            
            this.stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(TarefasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            connection.ConnectionFactory.closeConnection(con, stmt);
        }
    }

    @Override
    public void editar(TarefasModel entidade) {
        this.con = connection.ConnectionFactory.getConnection();
        String sql = "UPDATE Tarefas set Descricao = ?, TempoEstimado = ?, Categoria = ?, Situacao = ?, IdUsuario = ?";
        
        try{
            this.stmt = this.con.prepareStatement(sql);
            this.stmt.setString(1, entidade.getDescricao());
            this.stmt.setString(2, entidade.getTempoEstimado());
            this.stmt.setString(3, entidade.getCategoria());
            this.stmt.setString(4, entidade.getSituacao());
            this.stmt.setInt(5, entidade.getUsuarioId().getId());
        } catch (SQLException ex) {
            Logger.getLogger(TarefasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            connection.ConnectionFactory.closeConnection(con, stmt);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<TarefasModel> listarTarefas() {
       ArrayList<TarefasModel> tarefas = new ArrayList<>();
       try{
           this.con = connection.ConnectionFactory.getConnection();
           String sql = "SELECT * FROM TAREFAS";
           this.stmt = this.con.prepareStatement(sql);
           this.rs = this.stmt.executeQuery();
           
           while (this.rs.next()){
               TarefasModel tarefa = new TarefasModel();
               tarefa.setDescricao(rs.getString("Descricao"));
               tarefa.setTempoEstimado(rs.getString("TempoEstimado"));
               tarefa.setCategoria(rs.getString("Categoria"));
               tarefa.setSituacao(rs.getString("Situacao"));
               tarefa.getUsuarioId().setId(rs.getInt("IdUsuario"));
               tarefas.add(tarefa);
           }
           
       } catch (SQLException ex) {
            Logger.getLogger(TarefasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       finally{
           connection.ConnectionFactory.closeConnection(con);
       }
       return tarefas;
    }

    @Override
    public void deletar(int idTarefa) {
        this.con = connection.ConnectionFactory.getConnection();
        String sql = "DELETE FROM Tarefas WHERE Id = ?";
        try{
            this.stmt = con.prepareStatement(sql);
            this.stmt.setInt(1, idTarefa);
            
            this.stmt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TarefasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            connection.ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<TarefasModel> listarPorId(int idTarefa){
        ArrayList<TarefasModel> tarefas = new ArrayList<>();
        this.con = connection.ConnectionFactory.getConnection();
        String sql = "SELECT descricao, tempoestimado, categoria, situacao, nome FROM Tarefas, Usuario WHERE  idUsuario = Usuario.Id AND Tarefas.Id = ?";
        try{
            this.stmt = con.prepareStatement(sql);
            this.stmt.setInt(1, idTarefa);
            this.rs = stmt.executeQuery();
            
            while(rs.next()){
                TarefasModel tarefa = new TarefasModel();
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setTempoEstimado(rs.getString("tempoestimado"));
                tarefa.setCategoria(rs.getString("categoria"));
                tarefa.setSituacao(rs.getString("situacao"));
                tarefa.getUsuarioId().setNome("nome");
                
                tarefas.add(tarefa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TarefasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            connection.ConnectionFactory.closeConnection(con, stmt);
        }
        
        return tarefas;
    }
    
    

}
