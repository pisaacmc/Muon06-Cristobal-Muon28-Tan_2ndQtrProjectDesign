/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2classmodels;
import java.util.Scanner;
/**
 *
 * @author MUON
 */
public class Encounter implements Interactable{
    public String decision1,decision2,name,description;
    public int[] reward1 = {0,0}, reward2 = {0,0}; //money, influence
    public Encounter (String name, String description, String decision1, String decision2, int gold1, int influence1, int gold2, int influence2){
        this.name = name;
        this.description = description;
        this.decision1 = decision1;
        this.decision2 = decision2;
        reward1[0] = gold1;
        reward1[1] = influence1;
        reward2[0] = gold2;
        reward2[1] = influence2;
        
    }
    public void interact(Player player){
        Scanner sc = new Scanner(System.in);
        System.out.printf("%s%n%n%s%n%nChoice 1: %s [%+d gold,%+d influence]%n%nChoice 2: %s [%+d gold,%+d influence]%n", name, description, decision1, reward1[0], reward1[1], decision2, reward2[0], reward2[1]);
        boolean choicemade = false;
        while(!choicemade){
            System.out.println("Make Your Choice: ");
            String choice = sc.nextLine();
                if (choice.equalsIgnoreCase(decision1)){
                    player.setGold(player.getGold()+reward1[0]);
                    player.setInfluence(player.getInfluence()+reward1[1]);
                    choicemade = true;
                }
                else if (choice.equalsIgnoreCase(decision2)){
                    player.setGold(player.getGold()+reward1[0]);
                    player.setInfluence(player.getInfluence()+reward1[1]);
                    choicemade = true;
                }
                else{
                    System.out.println("choice invalid!");
                }
        
        }
    }
}
