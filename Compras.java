/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author Stefany
 */
public class Compras extends Usuario implements Serializable {

    private static final long serialVersionUID = 123456789L;

    private int codcompra;
    private float valorcompra;
    int quantidade;
    private Bottons bottons;

    public Compras(int codcompra, float valorcompra, int quantidade, Bottons bottons, int codUsuario) {
        super(codUsuario);
        this.codcompra = codcompra;
        this.valorcompra = valorcompra;
        this.quantidade = quantidade;
        this.bottons = bottons;
    }

    public Compras(float valorcompra, int quantidade, Bottons bottons, int codUsuario) {
        super(codUsuario);
        this.valorcompra = valorcompra;
        this.quantidade = quantidade;
        this.bottons = bottons;
    }

    public void atualizaEstoque() {
        // atualizando a quantidade de itens do botton
        this.getBottons().setQuantEstoque(this.getBottons().getQuantEstoque() - quantidade);
    }

    public Compras(int codUsuario) {
        super(codUsuario);
    }

    public int getCodcompra() {
        return codcompra;
    }

    public void setCodcompra(int codcompra) {
        this.codcompra = codcompra;
    }

    public float getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(float valorcompra) {
        this.valorcompra = valorcompra;
    }

    public Bottons getBottons() {
        return bottons;
    }

    public void setBottons(Bottons bottons) {
        this.bottons = bottons;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getPrecoString(){
        String padrao = "#,##0.00";
        DecimalFormat dcf = new DecimalFormat(padrao);
        return dcf.format(valorcompra);
    }

}
