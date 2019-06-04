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
public class TarefasModel {
    private int id;
    private String descricao;
    private String tempoEstimado;
    private String categoria;
    private String situacao;
    private UsuarioModel usuarioId;

    public TarefasModel(int id, String descricao, String tempoEstimado, String categoria, String situacao, UsuarioModel usuarioId) {
        this.id = id;
        this.descricao = descricao;
        this.tempoEstimado = tempoEstimado;
        this.categoria = categoria;
        this.situacao = situacao;
        this.usuarioId = usuarioId;
    }

    public TarefasModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(String tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public UsuarioModel getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UsuarioModel usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    
    
}
