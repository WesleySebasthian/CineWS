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
public class VendaInvalidaException extends Exception {

    /**
     * Creates a new instance of <code>VendaInvalidaException</code> without
     * detail message.
     */
    public VendaInvalidaException() {
    }

    /**
     * Constructs an instance of <code>VendaInvalidaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public VendaInvalidaException(String msg) {
        super(msg);
    }
}
