/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.negocio;

import br.com.CineWS.entidade.Filme;
import br.com.CineWS.excecao.CampoInvalidoException;
import br.com.CineWS.persistencia.FilmeDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Wesley
 */
public class FilmeBO {

    private FilmeDAO filmeDAO;

    public FilmeBO() {
        filmeDAO = new FilmeDAO();
    }

    public void cadastrar(Filme filme) throws CampoInvalidoException, SQLException {
        if (filme.getNome().isEmpty() || filme.getAnolancamento() <= 0) {
            throw new CampoInvalidoException();
        }
        this.filmeDAO.criar(filme);;
    }

    public void editar(Filme filme) throws CampoInvalidoException, SQLException {
        if (filme.getNome().isEmpty() || filme.getAnolancamento() <= 0) {
            throw new CampoInvalidoException();
        }
        this.filmeDAO.alterar(filme);
    }

    public void deletar(Filme filme) throws SQLException {
        this.filmeDAO.deletar(filme);
    }

    public List<Filme> buscarTodos() throws SQLException {
        return this.filmeDAO.buscarTodos();
    }
}
