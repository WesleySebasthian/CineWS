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
public class CampoInvalidoException extends Exception {

    /**
     * Creates a new instance of <code>CampoInvalidoException</code> without
     * detail message.
     */
    public CampoInvalidoException() {
    }

    /**
     * Constructs an instance of <code>CampoInvalidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CampoInvalidoException(String msg) {
        super(msg);
    }
}
