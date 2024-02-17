import java.util.ArrayList;
public class Squirtle extends Pokemon {
    
    private String attackOne;
    private String attackTwo;
    private ArrayList<Energy> energyPile;
    public Squirtle(){
        setHp(70);
        this.attackOne = "Tackle";
        this.attackTwo = "Rain Splash";
         energyPile = new ArrayList<Energy>();
    }
     
    //Tackle
    public void attackOne(Pokemon target, ArrayList<Energy> energyPile){
      if (energyPile.size() < 1){
            System.out.println("Not enough energy to perform this attack");
            return;
        }
        else{
        //deal 10 damage
        int currentHp = target.getHp();
        int resultingHp = currentHp - 10;
        target.setHp(resultingHp);
        System.out.println("Squirtle used Tackle on " + target.getName() + " dealing 10 damage!");
        }
     }
     //Rain Splash
        public void attackTwo(Pokemon target, ArrayList<Energy> energyPile){
      if (energyPile.size() < 1){
            System.out.println("Not enough energy to perform this attack");
            return;
        }
        else{
        //deal 20 damage
        int currentHp = target.getHp();
        int resultingHp = currentHp - 20;
        target.setHp(resultingHp);
        System.out.println("Squirtle used Rain Splash on " + target.getName() + " dealing 20 damage!");
     }
   }

     @Override
     public String getName(){
        return "Squirtle";
     }

     public void setEnergyPile(Energy energyCard) {
      energyPile.add(energyCard);
  }
}
