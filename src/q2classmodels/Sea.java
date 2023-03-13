/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2classmodels;
import q2classmodels.Exceptions.*;
import java.util.*;
/**
 *
 * @author MUON
 */
public class Sea extends Location{
    private ArrayList<Enemy> enemies = new ArrayList();
    public Sea (String name, String description){
        super(name, description,"sea");
    }
    public Sea (String name, String description, Player player){
        super(name, description,"sea");
        enemies.add(new Enemy(player));
    }
    public void interact(Ship ship, Player player) throws ItemNotFoundException, NotEnoughStaminaException{
        if(this.autoDuel(ship)){
            for (int i=0;i<enemies.size();i++){
                enemies.get(i).dropLoot(player);
            }
            
            player.setInfluence(player.getInfluence()+1);
        }
        else{
            player.setInfluence(0);
        }
    }
    public boolean autoDuel(Ship ship) throws ItemNotFoundException, NotEnoughStaminaException{//showcases basic combat
        do{
            Scanner sc = new Scanner(System.in);
            ship.fireWeapon(enemies.get(0), ship.getWeaponsList().get(0).getName());
            enemies.get(0).interact(ship);
        } while((ship.getHp()>0)&&(enemies.get(0).getHp()>0));
        if(ship.getHp() == 0){
            ship.setHp(ship.getMaxHp());
            System.out.println("you lose");
            return true;
            
        }
        else{
            ship.setHp(ship.getMaxHp());
            System.out.println("you win");
            return false;
            
        }
        
    }
}
