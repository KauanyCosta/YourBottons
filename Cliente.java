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
public class Cliente extends Usuario implements Serializable {

    private static final long serialVersionUID = 123456789L;

    public Cliente(int codUsuario, String nomeusuario, String login, String senha, String email, int tipo) {
        super(codUsuario, nomeusuario, login, senha, email, tipo);
    }

    public Cliente(int codUsuario, String nomeusuario, String login, String senha, String email, String cpf, int tipo) {
        super(codUsuario, nomeusuario, login, senha, email, cpf, tipo);
    }

    public Cliente(int codUsuario, String nomeusuario) {
        super(codUsuario, nomeusuario);
    }

    public Cliente(int codUsuario) {
        super(codUsuario);
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() +"Cliente" ;
    }

}
