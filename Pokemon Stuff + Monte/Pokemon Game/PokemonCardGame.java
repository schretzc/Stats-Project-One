//Christopher Schretzmann
import java.util.ArrayList;
import java.util.Scanner;
public class PokemonCardGame {
    //deck of cards
    private Player playerOne;
    private Player playerTwo;
    private Scanner scan = new Scanner(System.in);
    private String name1;
    private String name2;
   
    public PokemonCardGame(){
        System.out.println("Player One,  enter your name: ");
        name1 = scan.nextLine();

        System.out.println("Player Two,  enter your name: ");
        name2 = scan.nextLine();
        playerOne = new Player(name1);
        playerTwo = new Player(name2);
        setupGame();
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

    public void printField(Player player, Player target){
        System.out.println(player.getName() + "'s Field ");
        for (int i = 0; i < player.getActivePile().size(); i++){
            System.out.println(player.getActivePile().get(i).getName());
        }
        System.out.println(player.getName() + "'s Bench");
        player.printBench();
        System.out.println();
        System.out.println(target.getName() + "'s Field");
        for (int i = 0; i < target.getActivePile().size(); i++){
            System.out.println(i+1 + target.getActivePile().get(i).getName());
        }
        System.out.println(target.getName() + "'s Bench");
        target.printBench();
        System.out.println();
        System.out.println(player.getName() + "'s Prize Pile Size: " + player.getPrizePile().size());
        System.out.println(target.getName() + "'s Prize Pile Size: " + target.getPrizePile().size());
        System.out.println();
    
    }
    public void printPrizePile(Player player){
        System.out.println(player.getName() + "'s Field: ");
        for (int i = 0; i < player.getActivePile().size(); i++){
            System.out.println(player.getActivePile().get(i).getName());
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
        playerOne.drawHand();
        playerTwo.drawHand();
        playerOne.drawPrizePile();
        playerTwo.drawPrizePile();
    }

    public void runGame(){
        while (playerOne.getPrizePile().size() > 0 || playerTwo.getPrizePile().size() > 0){
            System.out.println("Player One's Turn");
            printField(playerOne, playerTwo);
            playerOne.turn(playerOne, playerTwo);
            checkWinner();
            if (playerOne.getPrizePile().size() == 0){
                break;
            }

            System.out.println("Player Two's Turn");
            printField(playerTwo, playerOne);
            playerTwo.turn(playerTwo, playerOne);
            checkWinner();
            
    }
}

       // public void runGame(){
       //     playerOne.drawHand();
        //    playerTwo.drawHand();
        //    playerOne.drawPrizePile();
        //    playerTwo.drawPrizePile();
        //    printHand(playerOne);
        //    printHand(playerTwo);
         //   printPrizePile(playerOne);
         //   printPrizePile(playerTwo);
         //   }

}
