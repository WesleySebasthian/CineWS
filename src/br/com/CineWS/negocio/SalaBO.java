/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.negocio;

import br.com.CineWS.entidade.Sala;
import br.com.CineWS.excecao.CampoInvalidoException;
import br.com.CineWS.persistencia.SalaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Wesley
 */
public class SalaBO {

    private SalaDAO salaDAO;

    public SalaBO() {
        salaDAO = new SalaDAO();
    }

    public void cadastrar(Sala sala) throws CampoInvalidoException, SQLException {
        if (sala.getNome().isEmpty() || sala.getLotacaomax() < 0) {
            throw new CampoInvalidoException();
        }
        this.salaDAO.criar(sala);;
    }

    public void editar(Sala sala) throws CampoInvalidoException, SQLException {
        if (sala.getNome().isEmpty() || sala.getLotacaomax() < 0) {
            throw new CampoInvalidoException();
        }
        this.salaDAO.alterar(sala);
    }

    public void deletar(Sala sala) throws SQLException {
        this.salaDAO.deletar(sala);
    }

    public List<Sala> buscarTodos() throws SQLException {
        return this.salaDAO.buscarTodos();
    }
}
