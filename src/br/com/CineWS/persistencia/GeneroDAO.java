/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.persistencia;

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
public class GeneroDAO {

    private static final String SQL_INSERT = "INSERT INTO GENERO(NOME) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE GENERO SET NOME=? WHERE ID=?";
    private static final String SQL_DELETE = "DELETE FROM GENERO WHERE ID=?";
    private static final String SQL_BUSCA_TODOS = "SELECT * FROM GENERO ORDER BY NOME";

    public void criar(Genero genero) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT);
            comando.setString(1, genero.getNome());

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

    public void alterar(Genero genero) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_UPDATE);
            comando.setString(1, genero.getNome());
            comando.setInt(2, genero.getId());

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

    public void deletar(Genero genero) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_DELETE);
            comando.setInt(1, genero.getId());

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

    public List<Genero> buscarTodos() throws SQLException {
        List<Genero> generos = new ArrayList<>();
        Genero genero = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_BUSCA_TODOS);
            resultado = comando.executeQuery();
            while (resultado.next()) {
                genero = new Genero();
                genero.setId(resultado.getInt(1));
                genero.setNome(resultado.getString(2));
                generos.add(genero);
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
        return generos;
    }
}
