//Christopher Schretzmann
import java.util.ArrayList;
public class PokemonCardGame {
    //deck of cards
    private Player playerOne;
    private Player playerTwo;
   
    public PokemonCardGame(){
        playerOne = new Player("Player One");
        playerTwo = new Player("Player Two");
    }

    public ArrayList<Card> getDeck(Player player){
        return player.getDeck();
    }

    public void printHand(Player player){
        System.out.println(player.getName() + "'s Current Hand:");
        for (int i = 0; i < player.getHand().size(); i++){
            System.out.println(player.getHand().get(i).getName());
        }
        System.out.println();
    }

    public void printField(Player player){
        System.out.println(player.getName() + "'s Current Field ");
        for (int i = 0; i < player.getActivePile().size(); i++){
            System.out.println(player.getActivePile().get(i).getName());
        }
        System.out.println();
    
    }
    public void printPrizePile(Player player){
        System.out.println(player.getName() + "'s Prize Pile: ");
        for (int i = 0; i < player.getPrizePile().size(); i++){
            System.out.println(player.getPrizePile().get(i).getName());
        }
        System.out.println();
    }

    public void printCardStats(Player player){
    }

    public void checkWinner(){
        if (playerOne.getPrizePile().size() == 0){
            System.out.println(playerTwo.getName() + " has won the game!!!");
        }
        if(playerTwo.getPrizePile().size() == 0){
            System.out.println(playerOne.getName() + " has won the game!!!");
        }
    }

    public void setupGame(){
    }

    // public void runGame(){
        // while (playerOne.getPrizePile().size() > 0 || playerTwo.getPrizePile().size() > 0){
            // playerOne.turn();
            // playerTwo.turn();
            //
    // }
    // setupGame();
// }

        public void runGame(){
            playerOne.drawHand();
            playerTwo.drawHand();
            playerOne.drawPrizePile();
            playerTwo.drawPrizePile();
            printHand(playerOne);
            printHand(playerTwo);
            printPrizePile(playerOne);
            printPrizePile(playerTwo);
            }

    
    public void runGame1(){
        Pikachu pikaMain = new Pikachu();
        Pikachu pikaTarget = new Pikachu();
        Bulbasaur newBulb = new Bulbasaur();

        newBulb.attackOne(pikaMain);
        System.out.println("Pika Main Hp: " + pikaMain.getHp() + " Bulbasaur Hp: " + newBulb.getHp());

        pikaMain.attackOne(newBulb);

        while(pikaTarget.getHp() > 0){
            pikaMain.attackOne(pikaTarget);
            //System.out.println("Pika Target Hp:" + pikaTarget.getHp());
            if (pikaTarget.getHp() == 0){
                System.out.println("Pika Target HP:" + pikaTarget.getHp());
                System.out.println("Pika Target has fainted!!!");
            }
            else{
                System.out.println("Pika Target HP:" + pikaTarget.getHp());
            }
        }
    }
}
