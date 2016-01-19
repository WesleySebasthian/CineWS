/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.persistencia;

import br.com.CineWS.entidade.Filme;
import br.com.CineWS.entidade.Sala;
import br.com.CineWS.entidade.Sessao;
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
public class SessaoDAO {

    private static final String SQL_INSERT = "INSERT INTO SESSAO(HORARIO,FILME,SALA) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE SESSAO SET HORARIO=?, FILME=?, SALA=? WHERE ID=?";
    private static final String SQL_DELETE = "DELETE FROM SESSAO WHERE ID=?";
    private static final String SQL_BUSCA_TODOS = "SELECT * FROM SESSAO ORDER BY HORARIO DESC";
    private static final String SQL_BUSCA_HORARIO_SALA = "SELECT * FROM SESSAO WHERE HORARIO=? AND SALA=? ";
    private static final String SQL_BUSCA_HORARIO_SALA_EDITAR = "SELECT * FROM SESSAO WHERE HORARIO=? AND SALA=? AND ID!=? ";

    public void criar(Sessao sessao) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT);
            comando.setTime(1, sessao.getHorario());
            comando.setInt(2, sessao.getFilme().getId());
            comando.setInt(3, sessao.getSala().getId());

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

    public void alterar(Sessao sessao) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_UPDATE);
            comando.setTime(1, sessao.getHorario());
            comando.setInt(2, sessao.getFilme().getId());
            comando.setInt(3, sessao.getSala().getId());
            comando.setInt(4, sessao.getId());

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

    public void deletar(Sessao sessao) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_DELETE);
            comando.setInt(1, sessao.getId());

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

    public List<Sessao> buscarTodos() throws SQLException {
        List<Sessao> sessaos = new ArrayList<>();
        Sessao sessao = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        FilmeDAO filmeDAO = new FilmeDAO();
        SalaDAO salaDAO = new SalaDAO();
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_BUSCA_TODOS);
            resultado = comando.executeQuery();
            while (resultado.next()) {
                sessao = new Sessao();
                sessao.setId(resultado.getInt(1));
                sessao.setHorario(resultado.getTime(2));
                for (Filme filme : filmeDAO.buscarTodos()) {
                    if (filme.getId() == resultado.getInt(3)) {
                        sessao.setFilme(filme);
                    }
                }
                for (Sala sala : salaDAO.buscarTodos()) {
                    if (sala.getId() == resultado.getInt(4)) {
                        sessao.setSala(sala);
                    }
                }
                sessaos.add(sessao);
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
        return sessaos;
    }

    public boolean BuscaPorHorarioSalaEditar(Sessao sessao) {
        PreparedStatement comando = null;
        Connection conexao = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_BUSCA_HORARIO_SALA_EDITAR);

            comando.setTime(1, sessao.getHorario());
            comando.setInt(2, sessao.getSala().getId());
            comando.setInt(3, sessao.getId());
            resultado = comando.executeQuery();
            if (resultado.next()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return true;
        }
    }

    public boolean BuscaPorHorarioSala(Sessao sessao) {
        PreparedStatement comando = null;
        Connection conexao = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_BUSCA_HORARIO_SALA);

            comando.setTime(1, sessao.getHorario());
            comando.setInt(2, sessao.getSala().getId());
            resultado = comando.executeQuery();
            if (resultado.next()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return true;
        }
    }
}
