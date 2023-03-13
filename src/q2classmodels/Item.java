/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2classmodels;

/**
 *
 * @author MUON
 */
abstract class Item {
    protected String name,type;
    protected int worth, price, upgradeCost, staminaCost, tier;
    protected Player owner;
    protected Item (String name, String type, int price, int worth, Player owner){
        this.name = name;
        this.type = type;
        this.tier = 0;
        this.price = price;
        this.worth = worth;
        this.owner = owner;
    }
    
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public int getPrice(){
        return price;
    }
    public int getWorth(){
        return worth;
    }
    public int getStaminaCost(){
        return staminaCost;
    }
    
}
