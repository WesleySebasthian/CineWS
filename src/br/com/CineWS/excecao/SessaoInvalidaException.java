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
public class SessaoInvalidaException extends Exception {

    /**
     * Creates a new instance of <code>SessaoInvalidaException</code> without
     * detail message.
     */
    public SessaoInvalidaException() {
    }

    /**
     * Constructs an instance of <code>SessaoInvalidaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SessaoInvalidaException(String msg) {
        super(msg);
    }
}
