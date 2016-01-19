/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.persistencia;

import br.com.CineWS.entidade.Sessao;
import br.com.CineWS.entidade.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wesley
 */
public class VendaDAO {

    private static final String SQL_INSERT = "INSERT INTO VENDA(TIPO_INGRESSO,SESSAO) VALUES(?,?)";
    private static final String SQL_DELETE = "DELETE FROM VENDA WHERE ID=?";
    private static final String SQL_BUSCA_TODOS = "SELECT * FROM VENDA ORDER BY ID DESC";
    private static final String SQL_BUSCA_SESSAO_SALA = "SELECT * FROM VENDA WHERE SESSAO=?";

    public void criar(Venda venda) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT);
            comando.setString(1, venda.getTipo_ingresso());
            comando.setInt(2, venda.getSessao().getId());

            comando.execute();
            conexao.commit();
        } catch (SQLException e) {
            if (conexao != null) {
//                conexao.rollback();
            }
//            throw new RuntimeException();
        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public void deletar(Venda venda) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_DELETE);
            comando.setInt(1, venda.getId());

            comando.execute();
            conexao.commit();
        } catch (SQLException e) {
            if (conexao != null) {
//                conexao.rollback();
            }
//            throw new RuntimeException();
        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public List<Venda> buscarTodos() throws SQLException {
        List<Venda> vendas = new ArrayList<>();
        Venda venda = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        SessaoDAO sessaoDAO = new SessaoDAO();
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_BUSCA_TODOS);
            resultado = comando.executeQuery();
            while (resultado.next()) {
                venda = new Venda();
                venda.setId(resultado.getInt(1));
                venda.setTipo_ingresso(resultado.getString(2));
                for (Sessao sessao : sessaoDAO.buscarTodos()) {
                    if (sessao.getId() == resultado.getInt(3)) {
                        venda.setSessao(sessao);
                    }
                }
                vendas.add(venda);
            }

        } catch (Exception e) {
            if (conexao != null) {
//                conexao.rollback();
            }
//            throw new RuntimeException();
        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return vendas;
    }

    public List<Venda> buscarSessao(Venda vendaA) throws SQLException {
        List<Venda> vendas = new ArrayList<>();
        Venda venda = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        SessaoDAO sessaoDAO = new SessaoDAO();
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_BUSCA_SESSAO_SALA);
            comando.setInt(1, vendaA.getSessao().getId());
            resultado = comando.executeQuery();
            while (resultado.next()) {
                venda = new Venda();
                venda.setId(resultado.getInt(1));
                venda.setTipo_ingresso(resultado.getString(2));
                for (Sessao sessao : sessaoDAO.buscarTodos()) {
                    if (sessao.getId() == resultado.getInt(3)) {
                        venda.setSessao(sessao);
                    }
                }
                vendas.add(venda);
            }

        } catch (Exception e) {
            if (conexao != null) {
//                conexao.rollback();
            }
//            throw new RuntimeException();
        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return vendas;
    }
}
