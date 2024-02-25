//Christopher Schretzmann
import java.util.ArrayList;
import java.util.Scanner;
/**
 * A pokemon game consists of two players
 * each player has a name of course
 * this runs the pokemon game
 */
public class PokemonCardGame {
    //deck of cards
    private Player playerOne;
    private Player playerTwo;
    private Scanner scan = new Scanner(System.in);
    private String name1;
    private String name2;
   
    /**
     * constructs a game
     * inputs two players into the game and sets the game up
     */
    public PokemonCardGame(){
        System.out.println("Player One,  enter your name: ");
        name1 = scan.nextLine();

        System.out.println("Player Two,  enter your name: ");
        name2 = scan.nextLine();
        playerOne = new Player(name1);
        playerTwo = new Player(name2);
        setupGame();
    }

    /**
     * 
     * @param player player who has current turn
     * @return returns deck of player
     */
    public ArrayList<Card> getDeck(Player player){
        return player.getDeck();
    }

    /**
     * prints current player's deck with each card numbered
     * @param player player with current turn
     */
    public void printHand(Player player){
        System.out.println(player.getName() + "'s Current Hand:");
        for (int i = 0; i < player.getHand().size(); i++){
            System.out.println(player.getHand().get(i).getName());
        }
        System.out.println();
    }

    /**
     * prints the entire field with the current player's info first
     * @param player current player with turn
     * @param target opponents player of turn
     */
    public void printField(Player player, Player target){
        System.out.println(player.getName() + "'s Field ");
        for (int i = 0; i < player.getActivePile().size(); i++){
            System.out.println(i+1 + ": " + player.getActivePile().get(i).getName());
        }
        System.out.println(player.getName() + "'s Bench");
        player.printBench();
        System.out.println();
        System.out.println(target.getName() + "'s Field");
        for (int i = 0; i < target.getActivePile().size(); i++){
            System.out.println(i+1 + ": " + target.getActivePile().get(i).getName());
        }
        System.out.println(target.getName() + "'s Bench");
        target.printBench();
        System.out.println();
        System.out.println(player.getName() + "'s Prize Pile Size: " + player.getPrizePile().size());
        System.out.println(target.getName() + "'s Prize Pile Size: " + target.getPrizePile().size());
        System.out.println();
    
    }

    /**
     * prints the prize pile of current player
     * @param player player with current turn
     */
    public void printPrizePile(Player player){
        System.out.println(player.getName() + "'s Field: ");
        for (int i = 0; i < player.getActivePile().size(); i++){
            System.out.println(player.getActivePile().get(i).getName());
        }
        System.out.println();
    }

    /**
     * prints the card stats of current player
     * @param player player with current turn
     */
    public void printCardStats(Player player){
    }

    /**
     * checks the prize pile of both players. if zero the game wins
     * @return returns if there is a winner or not
     */
    public boolean checkWinner(){
        if (playerOne.getPrizePile().size() == 0){
            System.out.println(playerTwo.getName() + " has won the game!!!");
            return true;
        }
        if(playerTwo.getPrizePile().size() == 0){
            System.out.println(playerOne.getName() + " has won the game!!!");
            return true;
        }
        return false;
    }

    /**
     * sets the game up
     * draws hands for both players
     * draws prize piles for both players
     */
    public void setupGame(){
        playerOne.drawHand();
        playerTwo.drawHand();
        playerOne.drawPrizePile();
        playerTwo.drawPrizePile();
    }

    /**
     * runs the game
     * while the players prize piles are greater than zero, loop both players turns
     * each player turn consists the turn method from player class
     * and checks the winning conditions to break loop and crown the winner
     */
    public void runGame(){
        while (playerOne.getPrizePile().size() > 0 || playerTwo.getPrizePile().size() > 0){
            System.out.println("Player One's Turn");
            printField(playerOne, playerTwo);
            playerOne.printHand();
            playerOne.turn(playerOne, playerTwo);
            //checkWinner();
            if (checkWinner() == true){
                break;
            }

            System.out.println("Player Two's Turn");
            printField(playerTwo, playerOne);
            playerTwo.printHand();
            playerTwo.turn(playerTwo, playerOne);
            //checkWinner();
            if (checkWinner() == true){
                break;
            }
            
    }
}

}
