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
public class Sala {

    private int id;
    private String nome;
    private int lotacaomax;

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

    public int getLotacaomax() {
        return lotacaomax;
    }

    public void setLotacaomax(int lotacaomax) {
        this.lotacaomax = lotacaomax;
    }

    @Override
    public String toString() {
        return this.nome + " - Lotação: " + Integer.toString(this.lotacaomax);
    }

}
