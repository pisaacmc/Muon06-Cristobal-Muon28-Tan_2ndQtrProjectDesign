/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2classmodels;
import java.util.*;
/**
 *
 * @author MUON
 */
public class Island extends Location implements Interactable{
    private String[] choices = {"Merchant","Hire","Encounter","Leave"};
    private ArrayList<Lieutenant> hiringPool = new ArrayList();
    private Merchant merchant;
    private Encounter encounter;
    public Island(){
        super("a","b","island");
    }
    public Island(String name, String background, Encounter encounter, Player player){
        super(name, background, "island");
        
    }
    
    public void interact(Player player){
        System.out.println(name);
        System.out.println("---");
        System.out.println(background);
        while (true){
            for (int i = 0; i<choices.length;i++){
                System.out.println("choice "+(i+1)+": "+choices[i]);
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("Player Choice: ");
            String choice = sc.nextLine();
            sc = null;
            System.gc();
            if (choice.equalsIgnoreCase("merchant")){
                
                continue;
            }
            else if (choice.equalsIgnoreCase("hire")){
                player.hire();
                continue;
            }
            else if (choice.equalsIgnoreCase("encounter")){
                encounter.interact(player);
                continue;
            }
            else if (choice.equalsIgnoreCase("leave")){
                
                break;
            }
            else {
                System.out.println("Choice does not exist!");
                System.out.println("---");
            }
        }
    }
}
    

