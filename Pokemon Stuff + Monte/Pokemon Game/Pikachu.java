import java.util.ArrayList;
public class Pikachu extends Pokemon implements Attackable{
    private String attackOne;
    private String attackTwo;
    private String cardName;
    private ArrayList<ElectricEnergy> energyPile;
    public Pikachu(){
         this.setHp(70);
         this.attackOne = "Quick Attack";
         this.attackTwo = "Electroball";
         this.cardName = "Pikachu";
         energyPile = new ArrayList<ElectricEnergy>();
    }
     
    //Quick Attack
    public void attackOne(Pokemon target){
        //deal 10 damage
        int currentHp = target.getHp();
        int resultingHp = currentHp - 10;
        target.setHp(resultingHp);
        System.out.println("Pikachu used Quick Attack on " + target.getName() + " dealing 10 damage!");
     }
     //electroball
        public void attackTwo(Pokemon target){
        //deal 60 damage
        int currentHp = target.getHp();
        int resultingHp = currentHp - 60;
        target.setHp(resultingHp);
         System.out.println("Pikachu used Electroball on " + target.getName() + " dealing 60 damage!");
     }

     @Override
     public String getName(){
        return cardName;
     }

       @Override
       public void attatchEnergy(){
         energyPile.add(new ElectricEnergy());
}
}
