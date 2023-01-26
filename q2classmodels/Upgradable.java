/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2classmodels;
import q2classmodels.Exceptions.*;
/**
 *
 * @author MUON
 */
public interface Upgradable {
    void upgrade() throws BrokeException, AlreadyMaximumException;
}
