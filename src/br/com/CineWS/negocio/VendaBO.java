/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.negocio;

import br.com.CineWS.entidade.Venda;
import br.com.CineWS.excecao.CampoInvalidoException;
import br.com.CineWS.excecao.VendaInvalidaException;
import br.com.CineWS.persistencia.VendaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wesley
 */
public class VendaBO {

    private VendaDAO vendaDAO;

    public VendaBO() {
        vendaDAO = new VendaDAO();
    }

    public void cadastrar(Venda venda) throws SQLException, VendaInvalidaException {
        List<Venda> vendas = new ArrayList<>();
        vendas = this.vendaDAO.buscarSessao(venda);
        if (vendas.size() == venda.getSessao().getSala().getLotacaomax()) {
            throw new VendaInvalidaException();
        }
        this.vendaDAO.criar(venda);
    }

    public void deletar(Venda venda) throws SQLException {
        this.vendaDAO.deletar(venda);
    }

    public List<Venda> buscarTodos() throws SQLException {
        return this.vendaDAO.buscarTodos();
    }
}
