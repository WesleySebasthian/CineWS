/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.CineWS.excecao;

/**
 *
 * @author Wesley
 */
public class LoginInvalidoException extends Exception {

    /**
     * Creates a new instance of <code>LoginInvalidoException</code> without
     * detail message.
     */
    public LoginInvalidoException() {
    }

    /**
     * Constructs an instance of <code>LoginInvalidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public LoginInvalidoException(String msg) {
        super(msg);
    }
}
