import java.util.ArrayList;
/**
 * Mewtwo is a pokemon
 * attacks are Super Psy Bolt and Transfer Break
 */
public class Mewtwo extends Pokemon 
{
private String attackOne;
private String attackTwo;
private String cardName;
public Mewtwo(){
this.setHp(120);
this.attackOne = "Super Psy Bolt";
this.attackTwo = "Transfer Break";
}

//Super Psy Bolt
public void attackOne(Pokemon target, ArrayList<Energy> energyPile){
if (energyPile.size() < 1){
System.out.println("Not enough energy to perform this attack");
}
else{ 
    int currentHp = target.getHp();
    int resultingHp = currentHp - 50;
    target.setHp(resultingHp);
    System.out.println("Mewtwo used Super Psy Bolt on " + target.getName() + " dealing 50 damage!");
}
}

//Transfer Break
public void attackTwo(Pokemon target, ArrayList<Energy> energyPile){
if (energyPile.size() < 1){
System.out.println("Not enough energy to perform this attack");
}
else{ 
    int currentHp = target.getHp();
    int resultingHp = currentHp - 160;
    target.setHp(resultingHp);
    System.out.println("Mewtwo used Transfer Break on " + target.getName() + " dealing 160 damage!");
}
}

@Override
public String getName(){
return "Mewtwo";
}
}
