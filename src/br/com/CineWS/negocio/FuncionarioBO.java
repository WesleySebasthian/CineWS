/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.negocio;

import br.com.CineWS.entidade.Funcionario;
import br.com.CineWS.excecao.CampoInvalidoException;
import br.com.CineWS.excecao.LoginInvalidoException;
import br.com.CineWS.persistencia.FuncionarioDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Wesley
 */
public class FuncionarioBO {

    private FuncionarioDAO funcionarioDAO;

    public FuncionarioBO() {
        funcionarioDAO = new FuncionarioDAO();
    }

    public void login(Funcionario funcionario) throws CampoInvalidoException, LoginInvalidoException {
        if (funcionario.getLogin().isEmpty() || funcionario.getSenha().isEmpty()) {
            throw new CampoInvalidoException();
        }
        if (!this.funcionarioDAO.login(funcionario)) {
            throw new LoginInvalidoException();
        }
    }

    public void cadastrar(Funcionario funcionario) throws CampoInvalidoException, SQLException {
        if (funcionario.getNome().isEmpty() || funcionario.getCpf().length() == 9 || funcionario.getTelefone().length() == 9 || funcionario.getLogin().isEmpty() || funcionario.getSenha().isEmpty()) {
            throw new CampoInvalidoException();
        }
        this.funcionarioDAO.criar(funcionario);;
    }

    public void editar(Funcionario funcionario) throws CampoInvalidoException, SQLException {
        if (funcionario.getNome().isEmpty() || funcionario.getCpf().length() == 9 || funcionario.getTelefone().length() == 9 || funcionario.getLogin().isEmpty() || funcionario.getSenha().isEmpty()) {
            throw new CampoInvalidoException();
        }
        this.funcionarioDAO.alterar(funcionario);
    }

    public void deletar(Funcionario funcionario) throws SQLException {
        this.funcionarioDAO.deletar(funcionario);
    }

    public List<Funcionario> buscarTodos() throws SQLException {
        return this.funcionarioDAO.buscarTodos();
    }
}
