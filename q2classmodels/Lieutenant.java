/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2classmodels;

import q2classmodels.Exceptions.AlreadyMaximumException;
import q2classmodels.Exceptions.BrokeException;

/**
 *
 * @author MUON
 */
public class Lieutenant extends NPC implements Upgradable{
    private boolean cleanse, retribution;
    private Player captain;
    private int[] actionStats ={0,0,0,0,0,0}; //damage, healing, poison, weakness, gold
    private int upgradeCost,tier;
    public Lieutenant(String name, String dialogue, int gold){
        super(name, dialogue, 10);
        
    }
    public void upgrade() throws BrokeException, AlreadyMaximumException{
        if (captain.getGold()-(upgradeCost*(1+(captain.getInfluence()+tier/10)))<0){
            throw new BrokeException("you dont have enough money for that!");            
        }
        if (tier ==3){
            throw new AlreadyMaximumException("This weapon is already maxxed out!");
        }
        captain.setGold(captain.getGold()-(upgradeCost*(captain.getInfluence()+tier/10)));
        tier+=1;
    }
    public void specialMove(){
        
    }
}
