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
public class Q2Classmodels {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player player = new Player("jim","alcor",0,10);
        Relic test = new Relic("cjatorak",1,2,player);
        Encounter encounter = new Encounter("Banan","jopay","aoa","oao",1,1,2,2);
        Enemy enemy = new Enemy(player);
        System.out.println("thing");
    }
    
}
