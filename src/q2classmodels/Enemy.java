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
public class Enemy{
    private int hp, healing, atk, challenge;
    private int gold;
    private int poison, weakness;
    private int[] debuffs = {0,0}; //poison, weakness
    private String name, weakAgainst, strongAgainst, damageType;
    private Item loot;
    public Enemy(Ship player){
        name = "bonzo";
        int difficultyModifier = player.getInfluence();
        this.hp = (int)Math.floor(((Math.random()*((10-5)+1)+5))*(1+difficultyModifier/5));
        healing = (int)Math.floor((Math.random()*2+2)*(1+difficultyModifier/5));
        atk = (int)(Math.floor(Math.random()*(3)+1)*(1+difficultyModifier/5));
        int powers = difficultyModifier-5;
        challenge = (int)(atk+hp/2);
        while (powers>0){
            int buffLevel = (int)Math.floor(Math.random()*(powers+1));
            debuffs[(int)Math.floor(Math.random()*(4))]+=buffLevel;
            powers-=buffLevel;
        }
        if(Math.floor(Math.random()*2)==1){
            loot = new Relic("smiting stone",challenge,(int)(challenge*1.5),player);
        }
        else{
            System.out.println(Math.floor(Math.random()*2));
            loot = new Weapon("Cannon",challenge,(int)(challenge*1.5),player,challenge%3);
        }
        String[] weaknesses = {"physical","explosive","magical"};
        weakAgainst = weaknesses[(int)Math.floor(Math.random()*3)];
    }
    public int getHp(){
        return hp;
    }
    public int getPoison(){
        return poison;
    }
    public int getWeakness(){
        return weakness;
    }
    public void setPoison(int newValue){
        poison = newValue;
    }
    public void setWeakness(int newValue){
        weakness = newValue;
    }

    public void setHp(int newValue){
        hp = newValue;
    }
        public String getWeakAgainst(){
        return weakAgainst;
    }
    public void interact(Ship ship){
        System.out.print(name);
        int damageDealt = (int)Math.round(atk*(1-(ship.getHull()/10)));
        ship.setHp(ship.getHp()-damageDealt);
        System.out.println(name+" attacked "+ship.getName()+" for "+damageDealt+"damage!");
        
    }
    public void dropLoot(Ship target){
        target.addItem(loot);
        target.setInfluence(target.getInfluence()+1);
    }
}
