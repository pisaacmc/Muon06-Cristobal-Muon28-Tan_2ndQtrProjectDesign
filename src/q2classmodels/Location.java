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
abstract class Location{
    protected String name, background, type;
    
    public Location(String name, String background, String type){
        this.name = name;
        this.background = background;
        this.type = type;
    }
    public String getType(){
        return type;
    }
    void interact(Player player) {
        System.out.println(background);
    }
}
