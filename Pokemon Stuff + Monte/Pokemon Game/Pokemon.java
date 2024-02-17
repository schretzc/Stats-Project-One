import java.util.ArrayList;

public class Pokemon extends Card implements Attackable{
    
    private int hp;
    private ArrayList<Energy> energyPile;

    public Pokemon(){
        this.hp = 70;
        energyPile = new ArrayList<Energy>();
        
    }

    public ArrayList<Energy> getEnergyPile(){
        return energyPile;
    }

    public void addEnergy(Energy energy){
        energyPile.add(energy);
    }

    public void attackOne(Pokemon target, ArrayList<Energy> energyPile){
        
    }
    public void attackTwo(Pokemon target, ArrayList<Energy> energyPile){
    }
    
    public int getHp(){
        return hp;
    }

    public void setHp(int userInputHp){
        this.hp = userInputHp;
    } 

    
}
