
import java.util.ArrayList;
/**
 * Bulbasaur is a pokemon
 * extends pokemon
 * attacks are leechseed and vine whip
 */
public class Bulbasaur extends Pokemon{
    private String attackOne;
    private String attackTwo;
    private ArrayList<Energy> energyPile;
    public Bulbasaur(){
        setHp(70);
        this.attackOne = "Leech Seed";
        this.attackTwo = "Vine Whip";
        energyPile = new ArrayList<Energy>();
    }

    //leechseed
    public void attackOne(Pokemon target, ArrayList<Energy> energyPile){
        //deal 20 damage heal 20
        if (energyPile.size() < 1){
            System.out.println("Not enough energy to perform this attack");
            return;
        }
        else{
        int currentHp = target.getHp();
        int resultingHp = currentHp - 20;
        
        int thisCurrentHp = this.getHp();
        this.setHp(thisCurrentHp + 20);

        target.setHp(resultingHp);
        System.out.println("Bulbasaur used Leech Seed on " + target.getName() + " dealing 20 damage");
        System.out.println("Bulbasaur healed 20 hp");
    }
    }
    //vine whip
    public void attackTwo(Pokemon target, ArrayList<Energy> energyPile){
        if (energyPile.size() < 1){
            System.out.println("Not enough energy to perform this attack");
            return;
        }
        else{
        //deal 45 damage
        int currentHp = target.getHp();
        int resultingHp = currentHp - 45;
        target.setHp(resultingHp);
        System.out.println("Bulbasaur used Vine Whip on " + target.getName() + " dealing 45 damage");
    }
     }

    @Override
    public String getName(){
        return "Bulbasaur";
    }

    public void setEnergyPile(Energy energyCard) {
        energyPile.add(energyCard);
    }


}
