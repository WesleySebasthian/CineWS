/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.entidade;

/**
 *
 * @author Wesley
 */
public class Venda {

    private int id;
    private String tipo_ingresso;
    private Sessao sessao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_ingresso() {
        return tipo_ingresso;
    }

    public void setTipo_ingresso(String tipo_ingresso) {
        this.tipo_ingresso = tipo_ingresso;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

}
