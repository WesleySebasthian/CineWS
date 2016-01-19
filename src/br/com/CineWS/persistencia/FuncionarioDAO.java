/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.persistencia;

import br.com.CineWS.entidade.Funcionario;
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
public class FuncionarioDAO {

    private static final String SQL_INSERT = "INSERT INTO FUNCIONARIO(NOME,CPF,TELEFONE,LOGIN,SENHA) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE FUNCIONARIO SET NOME=?, CPF=?, TELEFONE=?, LOGIN=?, SENHA=? WHERE ID=?";
    private static final String SQL_DELETE = "DELETE FROM FUNCIONARIO WHERE ID=?";
    private static final String SQL_BUSCA_TODOS = "SELECT * FROM FUNCIONARIO ORDER BY NOME";
    private static final String SQL_LOGIN = "SELECT * FROM FUNCIONARIO WHERE LOGIN=? AND SENHA=?";

    public void criar(Funcionario funcionario) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT);
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getCpf());
            comando.setString(3, funcionario.getTelefone());
            comando.setString(4, funcionario.getLogin());
            comando.setString(5, funcionario.getSenha());

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

    public void alterar(Funcionario funcionario) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_UPDATE);
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getCpf());
            comando.setString(3, funcionario.getTelefone());
            comando.setString(4, funcionario.getLogin());
            comando.setString(5, funcionario.getSenha());
            comando.setInt(6, funcionario.getId());

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

    public void deletar(Funcionario funcionario) throws SQLException {
        PreparedStatement comando = null;
        Connection conexao = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_DELETE);
            comando.setInt(1, funcionario.getId());

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

    public List<Funcionario> buscarTodos() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        Funcionario funcionario = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_BUSCA_TODOS);
            resultado = comando.executeQuery();
            while (resultado.next()) {
                funcionario = new Funcionario();
                funcionario.setId(resultado.getInt(1));
                funcionario.setNome(resultado.getString(2));
                funcionario.setCpf(resultado.getString(3));
                funcionario.setTelefone(resultado.getString(4));
                funcionario.setLogin(resultado.getString(5));
                funcionario.setSenha(resultado.getString(6));
                funcionarios.add(funcionario);
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
        return funcionarios;
    }

    public boolean login(Funcionario funcionario) {
        PreparedStatement comando = null;
        Connection conexao = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_LOGIN);

            comando.setString(1, funcionario.getLogin());
            comando.setString(2, funcionario.getSenha());
            resultado = comando.executeQuery();
            if (resultado.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
