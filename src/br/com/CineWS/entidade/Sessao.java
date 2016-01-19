/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.entidade;

import java.sql.Time;

/**
 *
 * @author Wesley
 */
public class Sessao {

    private int id;
    private Time horario;
    private Filme filme;
    private Sala sala;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Horário: " + this.horario + " - " + this.filme.getNome() + " - " + this.sala.getNome();
    }

}
