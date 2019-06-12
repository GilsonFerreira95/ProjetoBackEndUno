package dao;

import interfaces.InterfaceUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UsuarioModel;
/**
 *
 * @author gilso
 */
public class UsuarioDao implements InterfaceUsuario {

    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    @Override
    public void inserir(UsuarioModel entidade) {
        this.con = connection.ConnectionFactory.getConnection();
        String sql = "INSERT INTO Usuario (Nome, Foto, Endereco, "
                + "Cargo, HorariosTrabalho) VALUES (?, ?, ?, ?, ?)";

        try {
            this.stmt = this.con.prepareStatement(sql);
            this.stmt.setString(1, entidade.getNome());
            this.stmt.setBytes(2, entidade.getFoto());
            this.stmt.setString(3, entidade.getEndereco());
            this.stmt.setString(4, entidade.getCargo());
            this.stmt.setString(5, entidade.getHorariosDeTrabalho());
            this.stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TarefasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.ConnectionFactory.closeConnection(con, stmt);
        }
    }

    @Override
    public void editar(UsuarioModel entidade, int idUsuario) {
        this.con = connection.ConnectionFactory.getConnection();
        String sql = "UPDATE Usuario set Nome = ?, Foto= ?, Endereco = ?, Cargo= ?, HorariosTrabalho= ? WHERE id = ?";

        try {
            this.stmt = this.con.prepareStatement(sql);
            this.stmt.setString(1, entidade.getNome());
            this.stmt.setBytes(2, entidade.getFoto());
            this.stmt.setString(3, entidade.getEndereco());
            this.stmt.setString(4, entidade.getCargo());
            this.stmt.setString(5, entidade.getHorariosDeTrabalho());
            this.stmt.setInt(6, idUsuario);
            this.stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TarefasDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.ConnectionFactory.closeConnection(con, stmt);
        }
    }

    @Override
    public List<UsuarioModel> listarUsuario() {
        List<UsuarioModel> usuarios;
        usuarios = new ArrayList<>();
       try{
           this.con = connection.ConnectionFactory.getConnection();
           String sql = "SELECT * FROM Usuario";
           this.stmt = this.con.prepareStatement(sql);
           this.rs = this.stmt.executeQuery();
           while (this.rs.next()){
               UsuarioModel usuario = new UsuarioModel();
               usuario.setNome(rs.getString("Nome"));
               usuario.setFoto(rs.getBytes("Foto"));
               usuario.setEndereco(rs.getString("Endereco"));
               usuario.setCargo(rs.getString("Cargo"));
               usuario.setHorariosDeTrabalho(rs.getString("HorariosTrabalho"));
               usuarios.add(usuario);
           }
       } catch (SQLException ex) {
            Logger.getLogger(TarefasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       finally{
           connection.ConnectionFactory.closeConnection(con, stmt);
       }
       return usuarios;
    }
    

    @Override
    public void deletar(int idusuario) {
        this.con = connection.ConnectionFactory.getConnection();
        String sql = "DELETE FROM Usuario WHERE Id = ?";
        try{
            this.stmt = this.con.prepareStatement(sql);
            this.stmt.setInt(1, idusuario);
            this.stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(TarefasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            connection.ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<UsuarioModel> listarPorId(int idUsuario){
        List<UsuarioModel> usuarios;
        usuarios = new ArrayList<>();
           this.con = connection.ConnectionFactory.getConnection();
           String sql = "SELECT * FROM Usuario WHERE ID = ?";
           try{
           this.stmt = con.prepareStatement(sql);
           this.stmt.setInt(1, idUsuario);
           this.rs = this.stmt.executeQuery();
           while (this.rs.next()){
               UsuarioModel usuario = new UsuarioModel();
               usuario.setNome(rs.getString("Nome"));
               usuario.setFoto(rs.getBytes("Foto"));
               usuario.setEndereco(rs.getString("Endereco"));
               usuario.setCargo(rs.getString("Cargo"));
               usuario.setHorariosDeTrabalho(rs.getString("HorariosTrabalho"));
               usuarios.add(usuario);
           }
           
       } catch (SQLException ex) {
            Logger.getLogger(TarefasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       finally{
           connection.ConnectionFactory.closeConnection(con, stmt);
       }
       return usuarios;
    }
}
