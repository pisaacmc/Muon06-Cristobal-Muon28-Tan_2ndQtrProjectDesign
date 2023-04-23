/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2classmodels;
//NOTE: NOT CURRENTLY BEING USED
/**
 *
 * @author MUON
 */
abstract class NPC implements Interactable{
    protected String name, dialogue;
    protected int gold;
    protected NPC(String name, String dialogue, int gold){
        this.name = name;
        this.dialogue = dialogue;
        this.gold = gold;
    }
    public void interact(Ship ship){
        System.out.print(dialogue);
    }
    
}
