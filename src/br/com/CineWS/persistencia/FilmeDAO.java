/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.persistencia;

import br.com.CineWS.entidade.Filme;
import br.com.CineWS.entidade.Genero;
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
public class FilmeDAO {

    private static final String SQL_INSERT = "INSERT INTO FILME(NOME,GENERO,ANOLANCAMENTO,RESUMO,DURACAO,INICIOCARTAZ,FIMCARTAZ) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE FILME SET NOME=?, GENERO=?, ANOLANCAMENTO=?, RESUMO=?, DURACAO=?, INICIOCARTAZ=?, FIMCARTAZ=? WHERE ID=?";
    private static final String SQL_DELETE = "DELETE FROM FILME WHERE ID=?";
    private static final String SQL_BUSCA_TODOS = "SELECT * FROM FILME ORDER BY FIMCARTAZ";

    public void criar(Filme filme) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT);
            comando.setString(1, filme.getNome());
            comando.setInt(2, filme.getGenero().getId());
            comando.setInt(3, filme.getAnolancamento());
            comando.setString(4, filme.getResumo());
            comando.setTime(5, filme.getDuracao());
            comando.setDate(6, filme.getIniciocartaz());
            comando.setDate(7, filme.getIniciocartaz());

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

    public void alterar(Filme filme) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_UPDATE);
            comando.setString(1, filme.getNome());
            comando.setInt(2, filme.getGenero().getId());
            comando.setInt(3, filme.getAnolancamento());
            comando.setString(4, filme.getResumo());
            comando.setTime(5, filme.getDuracao());
            comando.setDate(6, filme.getIniciocartaz());
            comando.setDate(7, filme.getIniciocartaz());
            comando.setInt(8, filme.getId());

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

    public void deletar(Filme filme) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_DELETE);
            comando.setInt(1, filme.getId());

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

    public List<Filme> buscarTodos() throws SQLException {
        List<Filme> filmes = new ArrayList<>();
        Filme filme = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        GeneroDAO generoDAO = new GeneroDAO();
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_BUSCA_TODOS);
            resultado = comando.executeQuery();
            while (resultado.next()) {
                filme = new Filme();

                filme.setId(resultado.getInt(1));
                filme.setNome(resultado.getString(2));

                for (Genero genero : generoDAO.buscarTodos()) {
                    if (genero.getId() == resultado.getInt(3)) {
                        filme.setGenero(genero);
                    }
                }
                filme.setAnolancamento(resultado.getInt(4));
                filme.setResumo(resultado.getString(5));
                filme.setDuracao(resultado.getTime(6));
                filme.setIniciocartaz(resultado.getDate(7));
                filme.setFimcartaz(resultado.getDate(7));
                filmes.add(filme);
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
        return filmes;
    }
}
