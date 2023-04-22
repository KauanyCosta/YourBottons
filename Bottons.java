/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Stefany
 */
public class Bottons implements Serializable {

    private static final long serialVersionUID = 123456789L;

    private int codBottom;
    private String nome;
    private float valor;
    private String descricao;
    private int quantEstoque;
    private Date datalancamento;
    private byte[] imagem;

    public Bottons(int codBottom, String nome, float valor, String descricao, int quantEstoque, Date datalancamento, byte[] imagem) {
        this.codBottom = codBottom;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.quantEstoque = quantEstoque;
        this.datalancamento = datalancamento;
        this.imagem = imagem;
    }

    public Bottons(int codBottom, String nome) {
        this.codBottom = codBottom;
        this.nome = nome;
    }

    public Bottons(int codBottom, String nome, byte[] imagem) {
        this.codBottom = codBottom;
        this.nome = nome;
        this.imagem = imagem;
    }


    public Bottons(int codBottom, int quantEstoque) {
        this.codBottom = codBottom;
        this.quantEstoque = quantEstoque;
    }

    public Bottons(String nome, float valor, String descricao, int quantEstoque, Date datalancamento, byte[] imagem) {
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.quantEstoque = quantEstoque;
        this.datalancamento = datalancamento;
        this.imagem = imagem;
    }


    public Bottons(int codBottom) {
        this.codBottom = codBottom;
    }

    public int getCodBottom() {
        return codBottom;
    }

    public void setCodBottom(int codBottom) {
        this.codBottom = codBottom;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quatEstoque) {
        this.quantEstoque = quatEstoque;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Date getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
    }

    @Override
    public String toString() {
        return "Bottom" + "codBottom=" + codBottom + ", nome=" + nome + ", valor=" + valor + ", quantestoque=" + quantEstoque + ", datalancamento=" + datalancamento +", descricao= " +descricao+ " imagem= "+imagem;
    }

    public String getPrecoString(){
        String padrao = "#,##0.00";
        DecimalFormat dcf = new DecimalFormat(padrao);
        return dcf.format(valor);
    }

    public String getDataLancamentoString(){
        String padrao = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(padrao);
        return sdf.format(datalancamento);
    }
}
