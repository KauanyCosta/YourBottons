/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;

/**
 *
 * @author Kauany
 */
public class Sugestao implements Serializable {
    
    private static final long serialVersionUID = 123456789L;
    
    private int codsugestao;
    private String descricao;
    private Usuario usuario;
    private int sugestao_aceita;

    public Sugestao(int codsugestao, String descricao, Usuario usuario, int sugestao_aceita) {
        this.codsugestao = codsugestao;
        this.descricao = descricao;
        this.usuario = usuario;
        this.sugestao_aceita = sugestao_aceita;
    }    

    public Sugestao(int codsugestao, String descricao, Usuario usuario) {
        this.codsugestao = codsugestao;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public Sugestao(int codsugestao, int sugestao_aceita) {
        this.codsugestao = codsugestao;
        this.sugestao_aceita = sugestao_aceita;
    }
    
    

    public Sugestao(String descricao, Usuario usuario) {
        this.descricao = descricao;
        this.usuario = usuario;
    } 
    
    
    public int getCodsugestao() {
        return codsugestao;
    }

    public void setCodsugestao(int codsugestao) {
        this.codsugestao = codsugestao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getSugestao_aceita() {
        return sugestao_aceita;
    }

    public void setSugestao_aceita(int sugestao_aceita) {
        this.sugestao_aceita = sugestao_aceita;
    }   
}