/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package q2classmodels.Exceptions;

/**
 *
 * @author Isaac
 */
public class AlreadyThereException extends Exception{

    /**
     * Creates a new instance of <code>NotEnoughStaminaException</code> without
     * detail message.
     */
    public AlreadyThereException() {
    }

    /**
     * Constructs an instance of <code>NotEnoughStaminaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AlreadyThereException(String msg) {
        super(msg);
    }
}
