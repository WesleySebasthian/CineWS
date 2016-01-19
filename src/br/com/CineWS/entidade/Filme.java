/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.entidade;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Wesley
 */
public class Filme {

    private int id;
    private String nome;
    private Genero genero;
    private int anolancamento;
    private String resumo;
    private Time duracao;
    private Date iniciocartaz;
    private Date fimcartaz;

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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getAnolancamento() {
        return anolancamento;
    }

    public void setAnolancamento(int anolancamento) {
        this.anolancamento = anolancamento;
    }

    public Time getDuracao() {
        return duracao;
    }

    public void setDuracao(Time duracao) {
        this.duracao = duracao;
    }

    public Date getIniciocartaz() {
        return iniciocartaz;
    }

    public void setIniciocartaz(Date iniciocartaz) {
        this.iniciocartaz = iniciocartaz;
    }

    public Date getFimcartaz() {
        return fimcartaz;
    }

    public void setFimcartaz(Date fimcartaz) {
        this.fimcartaz = fimcartaz;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    
}
