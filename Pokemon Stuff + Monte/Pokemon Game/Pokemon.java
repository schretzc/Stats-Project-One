import java.util.ArrayList;

public class Pokemon extends Card implements Attackable{
    
    private int hp;
    private ArrayList<Energy> energyPile;

    public Pokemon(){
        this.hp = 70;
        energyPile = new ArrayList<Energy>();
        
    }

    public void attackOne(Pokemon target){
        
    }
    public void attackTwo(Pokemon target){
    }
    
    public int getHp(){
        return hp;
    }

    public void setHp(int userInputHp){
        this.hp = userInputHp;
    } 

    public void attachEnergy(Energy energyCard) {
        energyPile.add(energyCard);
    }
}
