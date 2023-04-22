/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;
/**
 *
 * @author Stefany
 */
public class Usuario implements Serializable {

    private static final long serialVersionUID = 123456789L;

    private int codUsuario;
    private String nomeusuario;
    private String login;
    private String senha;
    private String email;
    private String cpf;
    int tipo;

    public Usuario(int codUsuario, String nomeusuario, String login, String senha, String email, int tipo) {
        this.codUsuario = codUsuario;
        this.nomeusuario = nomeusuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
    }

    public Usuario(String nomeusuario, String login, String email, String cpf, int tipo) {
        this.nomeusuario = nomeusuario;
        this.login = login;
        this.email = email;
        this.cpf = cpf;
        this.tipo = tipo;
    }

    public Usuario(int codUsuario, String nomeusuario, String login, String senha, String cpf, String email) {
        this.codUsuario = codUsuario;
        this.nomeusuario = nomeusuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
    }

    public Usuario(int codUsuario, String nomeusuario, String login, String senha, String email) {
        this.codUsuario = codUsuario;
        this.nomeusuario = nomeusuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(int codUsuario, String nomeusuario, String login, String senha, String email, String cpf, int tipo) {
        this.codUsuario = codUsuario;
        this.nomeusuario = nomeusuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
        this.tipo = tipo;
    }

    public Usuario(int codUsuario, String nomeusuario) {
        this.codUsuario = codUsuario;
        this.nomeusuario = nomeusuario;
    }

    public Usuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Usuario(String nomeusuario, String login, String senha, String email, String cpf) {
        this.nomeusuario = nomeusuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
    }

    public Usuario(String nomeusuario, String login, String senha, String email, String cpf, int tipo){
        this.nomeusuario = nomeusuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
        this.tipo = tipo;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codUsuario = " + codUsuario + ", nomeUsuario = " + nomeusuario + ", login = " + login + ", email = " + email + ", cpf = " + cpf + ", tipo = " +tipo+'}';
    }
}