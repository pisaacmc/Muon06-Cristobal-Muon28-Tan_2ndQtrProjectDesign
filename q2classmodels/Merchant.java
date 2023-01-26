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
public class Merchant extends NPC{
    private ArrayList<Item> inventory = new ArrayList();
    public Merchant (String name, String dialogue, int gold, Player player){
        super(name, dialogue, gold);
        for (int i = 0; i<=player.getInfluence();i++){
            inventory.add(new Relic("PLACEHOLDER_RELIC",0,0,player));
            inventory.add(new Weapon("PLACEHOLDER_WEAPON",0,0,player,1));
        }
    }
    public void buyItem(Item item, Player player){
        inventory.add(item);
        player.removeItem(item);
        player.setGold(player.getGold()+item.getWorth());
        
    }
    public void sellItem(Item item, Player player){
        inventory.remove(item);
        player.addItem(item);
        player.setGold(player.getGold()+item.getWorth());        
    }
}
