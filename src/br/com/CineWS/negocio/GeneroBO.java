/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.negocio;

import br.com.CineWS.entidade.Genero;
import br.com.CineWS.excecao.CampoInvalidoException;
import br.com.CineWS.persistencia.GeneroDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Wesley
 */
public class GeneroBO {

    private GeneroDAO generoDAO;

    public GeneroBO() {
        generoDAO = new GeneroDAO();
    }

    public void cadastrar(Genero genero) throws CampoInvalidoException, SQLException {
        if (genero.getNome().isEmpty()) {
            throw new CampoInvalidoException();
        }
        this.generoDAO.criar(genero);;
    }

    public void editar(Genero genero) throws CampoInvalidoException, SQLException {
        if (genero.getNome().isEmpty()) {
            throw new CampoInvalidoException();
        }
        this.generoDAO.alterar(genero);
    }

    public void deletar(Genero genero) throws SQLException {
        this.generoDAO.deletar(genero);
    }

    public List<Genero> buscarTodos() throws SQLException {
        return this.generoDAO.buscarTodos();
    }
}
