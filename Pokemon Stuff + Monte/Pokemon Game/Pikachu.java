import java.util.ArrayList;
/**
 * pikachu is a pokemon
 * attacks are quick attack and electroball
 */
public class Pikachu extends Pokemon{
    private String attackOne;
    private String attackTwo;
    private String cardName;
    public Pikachu(){
         this.setHp(70);
         this.attackOne = "Quick Attack";
         this.attackTwo = "Electroball";
         this.cardName = "Pikachu";
         
    }
     
    //Quick Attack
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
        System.out.println("Pikachu used Quick Attack on " + target.getName() + " dealing 10 damage!");
         }
     }
     //electroball
        public void attackTwo(Pokemon target, ArrayList<Energy> energyPile){
         if (energyPile.size() < 1){
             System.out.println("Not enough energy to perform this attack");
             return;
         }
         else{
        //deal 60 damage
        int currentHp = target.getHp();
        int resultingHp = currentHp - 60;
        target.setHp(resultingHp);
         System.out.println("Pikachu used Electroball on " + target.getName() + " dealing 60 damage!");
         }
     }

     @Override
     public String getName(){
        return cardName;
     }
}
