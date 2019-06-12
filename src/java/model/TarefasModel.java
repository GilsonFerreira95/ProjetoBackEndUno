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
    private String nomeUsuario;
    private int idUsuario;

    public TarefasModel(int id, String descricao, String tempoEstimado, String categoria, String situacao, String nomeUsuario) {
        this.id = id;
        this.descricao = descricao;
        this.tempoEstimado = tempoEstimado;
        this.categoria = categoria;
        this.situacao = situacao;
        this.nomeUsuario = nomeUsuario;
    }

    public TarefasModel() {
    }

    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }
    
    public int getIdUsuario(){
        return idUsuario;
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
    
    public void setNomeUsuario(String nomeUsuario){
        this.nomeUsuario = nomeUsuario;
    }
    
    public String getNomeUsuario(){
        return nomeUsuario;
    }   
}
