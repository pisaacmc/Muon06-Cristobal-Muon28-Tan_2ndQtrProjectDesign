/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2classmodels;

import java.util.HashSet;
import q2classmodels.Exceptions.AlreadyMaximumException;
import q2classmodels.Exceptions.BrokeException;

/**
 *
 * @author MUON
 */
public class Lieutenant extends Item implements Upgradable{
    private boolean cleanse;
    private Ship ship;
    private int[] actionStats ={0,0,0,0,0}; //damage, healing, poison, weakness strength
    private int upgradeCost,tier,staminaCost;
    public Lieutenant(String name, String dialogue, int price, int worth,int damage, int healing, int poison, int weakness, int strength, boolean cleanse, int staminaCost, Ship player){
        super(name, "lieutenant", price, worth, player);
        actionStats[0] = damage;
        actionStats[1] = healing;
        actionStats[2] = poison;
        actionStats[3] = weakness;
        actionStats[4] = strength;
        
    }
    public void setCaptain(Ship captain){
        this.ship = captain;
    }
    public void upgrade() throws BrokeException, AlreadyMaximumException{
        if (ship.getGold()-(upgradeCost*(1+((ship.getInfluence()+tier)/10)))<0){
            throw new BrokeException("you dont have enough money for that!");            
        }
        if (tier ==3){
            throw new AlreadyMaximumException("This lieutenant is already maxxed out!");
        }
        ship.setGold(ship.getGold()-(upgradeCost*(1+((ship.getInfluence()+tier)/10))));
        for(int i=0; i<actionStats.length;i++){
            if(actionStats[i]>0){
                actionStats[i]++;
            }
        }
        tier+=1;
    }
    public void specialMove(Enemy enemy){
        enemy.setHp(enemy.getHp()-actionStats[0]);
        enemy.setPoison(enemy.getPoison()-actionStats[2]);
        enemy.setWeakness(enemy.getWeakness()-actionStats[3]);
        ship.setHp(ship.getHp()+actionStats[1]);
        if(ship.getHp() == ship.getMaxHp()){
            ship.setHp(ship.getMaxHp());
        }
        if (cleanse){
            ship.setPoison(0);
            ship.setWeakness(0);
            
        }
    }

    
}
