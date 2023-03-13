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
public class Ship {
    private String name;
    private int hp, hull, healing, flatDamage, stamina, maxHp, maxStamina,
                maxWeapon, strength, poison, weakness;
    private Lieutenant activeLieutenant;
    private Relic[] activeRelics = {null, null};
    private Player player;
    private ArrayList<Weapon> weaponsList = new ArrayList();
    
    public Ship(Player captain, String name, int maxHp, int hull){
        player = captain;
        this.name = name;
        this.maxHp = maxHp;
        this.hull = hull;
        this.healing = (int)Math.floor(maxHp*0.5);
        this.stamina = 3;
        this.maxWeapon = 2;
        this.hp = maxHp;
        this.flatDamage = 0;
        this.strength = 0;
        this.poison = 0;
        this.weakness = 0;
        weaponsList.add(new Weapon("cannon",5,10,1,captain,5,3));
    }
    //getters
    
    public String getName(){
        return name;
    }
    public int getMaxHp(){
        return maxHp;
    }
    public int getHp(){
        return hp;
    }
    public int getHull(){
        return hull;
    }
    public int getHealing(){
        return healing;
    }
    public int getMaxStamina(){
        return maxStamina;
    }
    public int getStamina(){
        return stamina;
    }
    public int getMaxWeapon(){
        return maxWeapon;
    }
    public int getFlatDamage(){
        return flatDamage;
    }
    public ArrayList<Weapon> getWeaponsList(){
        return weaponsList;
    }
    public Lieutenant getLieutenant(){
        return activeLieutenant;
    }
    public int getStrength(){
        return strength;
    }
    public int getPoison(){
        return poison;
    }
    public int getWeakness(){
        return weakness;
    }

    //setters
    public void setMaxHp(int newValue){
        maxHp = newValue;
    }
    public void setLieutenant(Lieutenant lieutenant){
        activeLieutenant = lieutenant;
    }
    public void setHp(int newValue){
        hp = newValue;
    }
    public void setHull(int newValue){
        hull = newValue;
    }
    public void setHealing(int newValue){
        healing = newValue;
    }
    public void setMaxStamina(int newValue){
        maxStamina = newValue;
    }
    public void setMaxWeapon(int newValue){
        maxWeapon = newValue;
    }
    public void setFlatDamage(int newValue){
        flatDamage = newValue;
    }
    public void setStrength(int newValue){
        strength = newValue;
    }
    public void setPoison(int newValue){
        poison = newValue;
    }
    public void setWeakness(int newValue){
        weakness = newValue;
    }
    public void shipInfo(){
        System.out.printf("Name: %s%nHp: %d/%d%nHull%d%nHealing: %d%n Flat Damage: %d%nPosion: %d%n Weakness: %d%n: Strength: %d%n", name,hp,maxHp,hull,healing,flatDamage,poison,weakness,strength);
    }
    public Weapon getWeapon(int index){
        if (index<maxWeapon){
            return weaponsList.get(index);
        }
        System.out.println("Out of range! Returning farthest index");
        return weaponsList.get(maxWeapon-1);
    }
    public void fireWeapon(Enemy enemy, String weaponName) throws ItemNotFoundException, NotEnoughStaminaException, NullPointerException{
        Weapon weapon = null;
        for (int i=0; i<maxWeapon;i++){
            if (weaponsList.get(i).getName().equalsIgnoreCase(weaponName)){
                weapon = weaponsList.get(i);
                break;
            }
            if(i==maxWeapon-1){
                throw new ItemNotFoundException("Weapon is not currently active!");
            }
       
        }
        if (weapon == null){
            throw new NullPointerException("Weapon does not Exist!");
        } 
        if(stamina-weapon.getStaminaCost()>0){
            throw new NotEnoughStaminaException("You dont have enough stamina for that!");
        }
        int damage = (int)(weapon.getBaseDamage()*1+(strength/10));
        if (enemy.getWeakAgainst().equalsIgnoreCase(weapon.getDamageType())){
            damage*=2;
        }

        enemy.setHp(enemy.getHp()-damage);
        
        //apply relic buffs
        for(int i=0; i<activeRelics.length;i++){
            
            if(activeRelics[i].getActive()){
                for (int c = 0; c<4;c++){                
                    switch(c){
                        case 0:
                            enemy.setPoison(enemy.getPoison()+activeRelics[i].getBuffs()[0]);
                            break;
                        case 1:
                            enemy.setPoison(enemy.getPoison()+activeRelics[i].getBuffs()[1]);
                            break;                            
                        case 2:
                            enemy.setPoison(enemy.getPoison()+activeRelics[i].getBuffs()[2]);
                            break; 
                        case 3:
                            enemy.setHp(enemy.getHp()-activeRelics[i].getBuffs()[3]);
                            hp+=activeRelics[i].getBuffs()[3];
                            if(hp>maxHp){
                                hp=maxHp;
                            }
                            break;                                  
                        default:
                            
                    }
                }
            }
            activeRelics[i].deactivate();
        }
        
    }
    /*
    public void fireWeapon(Sea battlefield, Enemy enemy, String weaponName) throws ItemNotFoundException, NotEnoughStaminaException, NullPointerException{
        Weapon weapon = null;
        for (int i=0; i<maxWeapon;i++){
            if (weaponsList.get(i).getName().equalsIgnoreCase(weaponName)){
                weapon = weaponsList.get(i);
                break;
            }
            if(i==3){
                throw new ItemNotFoundException("Weapon is not currently active!");
            }
       
        }
        if (weapon == null){
            throw new NullPointerException("Weapon does not Exist!");
        } 
        if(stamina-weapon.getStaminaCost()>0){
            throw new NotEnoughStaminaException("You dont have enough stamina for that!");
        }
        int damage = (int)(weapon.getBaseDamage()*1+(strength/10));
        if (enemy.getWeakAgainst().equalsIgnoreCase(weapon.getDamageType())){
            damage*=2;
        }

        enemy.setHp(enemy.getHp()-damage);
        //apply relic buffs
        for(int i=0; i<activeRelics.length;i++){
            
            if(activeRelics[i].getActive()){
                for (int c = 0; c<4;c++){                
                    switch(c){
                        case 0:
                            enemy.setPoison(enemy.getPoison()+activeRelics[i].getBuffs()[0]);
                            break;
                        case 1:
                            enemy.setPoison(enemy.getPoison()+activeRelics[i].getBuffs()[0]);
                            break;                            
                        case 2:
                            enemy.setPoison(enemy.getPoison()+activeRelics[i].getBuffs()[0]);
                            break;                            
                        default:
                            
                    }
                }
            }
            activeRelics[i].deactivate();
        }
        
    }  */  
    public void addWeapon(Weapon weapon) throws AlreadyMaximumException, ItemNotFoundException{
        if(weaponsList.size()==maxWeapon){
            throw new AlreadyMaximumException("Not enough space for that!");
        }
        if(player.getInventory().contains(weapon)){
            weaponsList.add(weapon);
        }
        else{
            throw new ItemNotFoundException("Item does not exist!");
        }
    }
    public void removeWeapon(Weapon weapon) throws ItemNotFoundException{
        if(weaponsList.contains(weapon)){
            weaponsList.remove(weapon);
        }
        else{
            throw new ItemNotFoundException("Item does not exist!");
        }
    }
    public void ReplaceWeapon(){
        
    }
    public void addRelic(){
        
    }
    public void removeRelic(){
        
    }
}
