public class Squirtle extends Pokemon implements Attackable {
    
    private String attackOne;
    private String attackTwo;
    public Squirtle(){
        setHp(70);
        this.attackOne = "Tackle";
        this.attackTwo = "Rain Splash";
    }
     
    //Tackle
    public void attackOne(Pokemon target){
        //deal 10 damage
        int currentHp = target.getHp();
        int resultingHp = currentHp - 10;
        target.setHp(resultingHp);
        System.out.println("Squirtle used Tackle on " + target.getName() + " dealing 10 damage!");
     }
     //Rain Splash
        public void attackTwo(Pokemon target){
        //deal 20 damage
        int currentHp = target.getHp();
        int resultingHp = currentHp - 20;
        target.setHp(resultingHp);
        System.out.println("Squirtle used Rain Splash on " + target.getName() + " dealing 20 damage!");
     }

     @Override
     public String getName(){
        return "Squirtle";
     }
}
