/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package q2classmodels.Exceptions;

/**
 *
 * @author Isaac
 */
public class EmptyArmoryException extends Exception{

    /**
     * Creates a new instance of <code>NotEnoughSlotException</code> without
     * detail message.
     */
    public EmptyArmoryException() {
    }

    /**
     * Constructs an instance of <code>NotEnoughSlotException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EmptyArmoryException(String msg) {
        super(msg);
    }
}
