/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gilso
 */
public class UsuarioModel {
    private int id;
    private String nome;
    private byte[] foto;
    private String endereco;
    private String Cargo;
    private String HorariosDeTrabalho;

    public UsuarioModel(int id, String nome, byte[] foto, String endereco, String Cargo, String HorariosDeTrabalho) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
        this.endereco = endereco;
        this.Cargo = Cargo;
        this.HorariosDeTrabalho = HorariosDeTrabalho;
    }

    public UsuarioModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getHorariosDeTrabalho() {
        return HorariosDeTrabalho;
    }

    public void setHorariosDeTrabalho(String HorariosDeTrabalho) {
        this.HorariosDeTrabalho = HorariosDeTrabalho;
    }
    
    
    
}
