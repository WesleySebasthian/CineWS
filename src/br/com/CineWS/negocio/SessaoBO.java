/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.negocio;

import br.com.CineWS.entidade.Sessao;
import br.com.CineWS.excecao.SessaoInvalidaException;
import br.com.CineWS.persistencia.SessaoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Wesley
 */
public class SessaoBO {

    private SessaoDAO sessaoDAO;

    public SessaoBO() {
        sessaoDAO = new SessaoDAO();
    }

    public void cadastrar(Sessao sessao) throws SQLException, SessaoInvalidaException {
        if (!sessaoDAO.BuscaPorHorarioSala(sessao)) {
            throw new SessaoInvalidaException();
        }
        this.sessaoDAO.criar(sessao);
    }

    public void editar(Sessao sessao) throws SQLException, SessaoInvalidaException {
        if (!sessaoDAO.BuscaPorHorarioSalaEditar(sessao)) {
            throw new SessaoInvalidaException();
        }
        this.sessaoDAO.alterar(sessao);
    }

    public void deletar(Sessao sessao) throws SQLException {
        this.sessaoDAO.deletar(sessao);
    }

    public List<Sessao> buscarTodos() throws SQLException {
        return this.sessaoDAO.buscarTodos();
    }
}
