/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Kauany
 */
public class Administrador extends Usuario implements Serializable {
    private static final long serialVersionUID = 123456789L;

    public Administrador(int codUsuario, String nomeusuario, String login, String senha, String email, String cpf, int tipo) {
        super(codUsuario, nomeusuario, login, senha, email, cpf, tipo);
    }

    public Administrador(String nomeusuario, String login, String senha, String email, String cpf, int tipo) {
        super(nomeusuario, login, senha, email, cpf, tipo);
    }
    

    public Administrador(int codUsuario) {
        super(codUsuario);
    }

    public Administrador(String nomeusuario, String login, String senha, String email, String cpf) {
        super(nomeusuario, login, senha, email, cpf);
    }

    public Administrador(int codUsuario, String nomeusuario, String login, String senha, String cpf, String email) {
        super(codUsuario, nomeusuario, login, senha, cpf, email);
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() +"Administrador{" + '}';
    }    
}
