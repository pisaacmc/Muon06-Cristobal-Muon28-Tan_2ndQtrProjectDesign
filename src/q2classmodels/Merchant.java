/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2classmodels;
import java.util.*;
import q2classmodels.Exceptions.*;
/**
 *
 * @author MUON
 */
public class Merchant {
    private ArrayList<Item> inventory = new ArrayList();
    public Merchant (Ship player){
            inventory.add(new Relic("jingo",0,0,player));
            inventory.add(new Weapon("horse",0,0,player,1));
    }
    public void buyItem(Item item, Ship player){
        inventory.add(item);
        player.removeItem(item);
        player.setGold(player.getGold()+item.getWorth());
        
    }
    public void sellItem(Item item, Ship player){
        inventory.remove(item);
        player.addItem(item);
        player.setGold(player.getGold()+item.getWorth());        
    }
    public void addItem(Item item){
        inventory.add(item);
    }
    public void removeItem(Item item){
        inventory.remove(item);
    }
    public ArrayList<Item> getInventory(){
        return inventory;
    }
}
