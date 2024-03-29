import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Player class that plays pokemon game.
 * @Author Christopher Schretzmann
 * 
 */
public class Player {
    private ArrayList<Card> deck;  //this is the constructors job= new Card[];
    private ArrayList<Card> hand;
    private ArrayList<Card> prizePile;
    private ArrayList<Card> discardPile;
    private ArrayList<Card> benchPile;
    private ArrayList<Card> activePile;
    private ArrayList<Pokemon> pokeDex;
    private ArrayList<Trainer> trainerDex;
    private String name;
    private Scanner scan = new Scanner(System.in);


    /**
     * Contructs a player and initializes deck or cards, hand of cards, prizePile of cards, discardPile of cards, benchPile
     * of cards and ActivePile of cards.
     * The pokeDex and trainerDex variables hold all of the types of each type to have an array of all cards of that type.
     * Constructs initial deck
     * @param name is the name of the 
     */
    public Player(String name){
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
        prizePile = new ArrayList<Card>();
        discardPile = new ArrayList<Card>();
        benchPile = new ArrayList<Card>();
        activePile = new ArrayList<Card>();
        pokeDex = new ArrayList<Pokemon>();
        trainerDex = new ArrayList<Trainer>();
        this.name = name;

        //fill deck with 20 of each type
        for(int i = 0; i < 20; i++){
            deck.add(new Energy());
            deck.add(randomTrainer());
            deck.add(randomPokemon());
        } 
        //fill prize pile with 6 pokemon
        //for(int i = 0; i < 6; i++){
         //   prizePile.add(new Pokemon());
       // }  
    }
    
    /**
     * randomly selects a pokemon from pokedex
     * @return returns random pokemon from array of all pokemon types in the game.
     */
    public Pokemon randomPokemon(){
        Random rand = new Random();
        pokeDex.add(new Pikachu());
        pokeDex.add(new Bulbasaur());
        pokeDex.add(new Squirtle());
        pokeDex.add(new Mewtwo());
        return pokeDex.get(rand.nextInt(pokeDex.size()));
    }

    /**
     * randomly selects from all trainers in the game stored in trainerdex.
     * @return returns a random trainer card
     */
    public Trainer randomTrainer(){
        Random rand = new Random();
        trainerDex.add(new ProfessorsResearch());
        trainerDex.add(new NestBall());
        trainerDex.add(new GreensExploration());
        return trainerDex.get(rand.nextInt(trainerDex.size()));
    }

    
    
    
     /**
     * Randomly draws a card from the deck
     * removes the card from deck and adds it to hand
     */
    public void drawCard() { 
        Random rng = new Random();
        //System.out.println(deck.size());
        int cardIndex = rng.nextInt(deck.size() ); //find random card
        Card drawnCard = deck.get(cardIndex);
        deck.remove(cardIndex);
        hand.add(drawnCard);
    }

    
    /**
     * Draws the prize pile for the player
     * Uses loop to draw the 6 cards
     */
    public void drawPrizePile(){
        Random rng = new Random();
        //System.out.println(deck.size());
        for(int i = 0; i < 6; i++) { //counting to 7       
            int cardIndex = rng.nextInt(deck.size()); //find random card
            Card drawnCard = deck.get(cardIndex); 
            deck.remove(cardIndex);
            prizePile.add(drawnCard);
        }
    }

    
    /**
     * Draws a hand of 7 cards using  loop and drawCard() method
     */
    public void drawHand(){
        for(int i = 0; i < 7; i++) { //counting to 7       
            drawCard();
        }
    }

    
    /**
     * Removes card from hand and adds to discard pile
     * @param cardIndex index of card to remove
     */
    public void discardCard(int cardIndex){
        discardPile.add(hand.get(cardIndex));
        hand.remove(cardIndex);
    }

    
    /**
     * Prints the hand with index
     */
    public void printHand(){
        for(int i = 0; i < hand.size(); i++){
            System.out.println(i+1 + ": " + hand.get(i).getName() + " ");
        }
    }

    /**
     * Prints the bench pile
     */
    public void printBench(){
        for(int i = 0; i < benchPile.size(); i++){
            System.out.println(i+1 + ": " + benchPile.get(i).getName());
        }
    }

    /**
     * Prints entire field
     * this includes hand, bench, and active pile
     */
   // public void printField(){
     //   System.out.println("Hand: ");
     //   printHand();
     //   System.out.println("Bench: ");
     //   printBench();
     //   System.out.println("Active: ");
     //   System.out.println(activePile.get(0).getName());}


    /**
     * adds card from hand to bench pile if the prize pile
     * If the bench pile is greater than 5, print bench is full
     * @param cardNumber number of card from hand
     */
    public void addToBench(int cardNumber){
        if (benchPile.size() < 5){
            benchPile.add(hand.get(cardNumber));
            hand.remove(cardNumber);
        }
        else{
            System.out.println("Bench is full");
        }
    }

    /**
     * Adds selected card from hand to active if it is less than 1
     * if the active pile is full, print active is full
     * @param cardNumber number of card in hand
     */
    public void addToActive(int cardNumber){
        if (activePile.size() < 1){
            activePile.add(hand.get(cardNumber));
            hand.remove(cardNumber);
        }
        else {
            System.out.println("Active is full");
        }
    }

    
    /**
     * removes selected card from prize pile
     * @param cardNumber index of card to remove
     */
    public void removePrizeCard(int cardNumber){
        hand.add(prizePile.get(cardNumber));
        prizePile.remove(cardNumber);
    }

    /**
     * in a turn a card is drawn
     * next the playerAction is carried out
     * println just for spacing
     * @param player current player that is taking the turn
     * @param targetPlayer opponent player that is taking the turn
     */
    public void turn(Player player, Player targetPlayer) {
        drawCard();
        //print hand
        //System.out.println();
        playerAction(player, targetPlayer);
        System.out.println();
        // Prompt the player to choose a card to play cardSelection method
        //cardSelection(player);
    
        // Prompt the player to choose the attack
        //attackPhase(player, targetPlayer);
        //play card
        //play pokemon
        //play energy
        //play trainer
        //attack w/ pokemon
        //attack w/ pokemon and end turn
    }
    /**
     * plays the card selected 
     * depending of the instance of card, method carries out specific rules for each card
     * @param cardNumber index of card number to be played for trainer card purposes
     * @param player player that is playing the card
     */
    public void playCard(int cardNumber, Player player){
        //if its a pokemon card, add to bench since thats the only place it can go
        if (hand.get(cardNumber) instanceof Pokemon){
            addToBench(cardNumber);
            System.out.println("Added to bench");
            System.out.println();
        }
        //if its an energy card, call attatchenergy
        else if (hand.get(cardNumber) instanceof Energy){
            addEnergy(cardNumber);
            System.out.println("Added to active");
            System.out.println(name);
        }
        //if its a trainer, call playtrainer
        else if (hand.get(cardNumber) instanceof Trainer){
            //play trainer card
            playTrainer(cardNumber, player);
            //System.out.println("Played trainer card");
            System.out.println();
        }
    }
    
    /**
     * checks if the card chosen is energy
     * if the active pile is empty, there is no pokemon to attach the energy to
     * if the card chosen is not an instance of energy, it isnt an energy card
     * adds energy to pokemon in active pile
     * @param cardNumber number of card to add
     */
    public void addEnergy(int cardNumber) {
        //if hand is instance of energy error case
        if (activePile.isEmpty()){
            System.out.println("No active Pokemon to attach energy to.");
            return;
        }

        if(hand.get(cardNumber) instanceof Energy == false){
            System.out.println("Not an energy card");
            return;
        }

        Pokemon activePokemon = (Pokemon) activePile.get(0);
        Energy energyCard = (Energy) hand.get(cardNumber);

        activePokemon.addEnergy(energyCard);

        //remove energy card from hand
        discardCard(cardNumber);
        System.out.println("Energy added to active Pokemon");
    }


    /**
     * plays trainer card
     * checks if the card is a trainer
     * @param cardNumber inded of card in hand
     * @param player player playing the card for trainer effects
     */
    public void playTrainer(int cardNumber, Player player){
        //if it is a trainer card, play it
        if (hand.get(cardNumber) instanceof Trainer){
            Trainer trainerCard = (Trainer) hand.get(cardNumber);
            trainerCard.playable(player);
            discardCard(cardNumber);
        }
    }

    /**
     * takes
     * @param attackNumber number of attack. interface requires two attacks
     * @param currentPlayer player who is attacking
     * @param targetPlayer player who is getting attacked
     */
    public void Attack(int attackNumber, Player currentPlayer, Player targetPlayer) {
        //if active pile is empty error case
        if (activePile.isEmpty() || !(activePile.get(0) instanceof Pokemon)) {
            System.out.println("No active Pokemon to attack with.");
            System.out.println("Your turn is over fam.");
            return;
        }
    
        // Retrieve the active Pokemon
        Pokemon activePokemon = (Pokemon) activePile.get(0);
        

        ArrayList<Card> opponentActivePile = targetPlayer.getActivePile();
        //ArrayList<Card> opponentBenchPile = targetPlayer.getBenchPile();
        if (opponentActivePile.isEmpty()) {
            System.out.println("Opponent has no active Pokemon!");
            return;
        }
        ArrayList<Card> opponentDiscardPile = targetPlayer.getDiscardPile();
        
       // ArrayList<Card> currentPrizePile = currentPlayer.getPrizePile();
        ArrayList<Card> currentActivePile = currentPlayer.getActivePile();

        //since active pile is card, we need to cast it to pokemon
        Pokemon opponentPokemon = (Pokemon) opponentActivePile.get(0);
        Pokemon currentPokemon = (Pokemon) currentActivePile.get(0);
    
        // Check the chosen attack and perform the selected attack
        switch (attackNumber) {
            case 1:
                activePokemon.attackOne(opponentPokemon, currentPokemon.getEnergyPile());
                System.out.println("opponent hp: " + opponentPokemon.getHp() + " current hp: " + currentPokemon.getHp());
                break;
            case 2:
                activePokemon.attackTwo(opponentPokemon, currentPokemon.getEnergyPile());
                System.out.println("opponent hp: " + opponentPokemon.getHp() + " current hp: " + currentPokemon.getHp());
                break;
            default:
                System.out.println("Invalid attack number. Please choose 1 or 2.");
                break;
        }
        //checks fainted pokemon
        if (opponentPokemon.getHp() <= 0) {
            System.out.println("Opponent's Pokemon fainted!");
            opponentDiscardPile.add(opponentActivePile.get(0));
            opponentActivePile.remove(0);
            
            //allows current player to grab a new cardv from prize pile if knockout
            
            //currentPlayer.printPrizePile();
            //int prizePokemon = scan.nextInt() - 1;
            currentPlayer.hand.add(currentPlayer.prizePile.get(0));
            System.out.println(currentPlayer.prizePile.get(0).getName() + " added to hand");
            currentPlayer.prizePile.remove(0);
            
        }
    }
    

    /**
     * prompts player to choose card to play
     * @param player player that is selecting the card
     */
    public void cardSelection(Player player){
         // Prompt the player to choose a card to play
         System.out.println("Pick a card to play: ");
         int cardNum = scan.nextInt() - 1;
         playCard(cardNum, player);
         player.printHand();

    }

    /**
     * Since there is an interface for the pokemon to have two attack, this method
     * picks an attack from the two to use using scanner.
     * @param player player who has a turn
     * @param targetPlayer player who is the opponent
     */
    public void attackPhase(Player player, Player targetPlayer){
          // Prompt the player to choose the attack
          System.out.println("Pick an attack:");
          System.out.println("1: Attack One");
          System.out.println("2: Attack Two");
      
          int attackNumber = scan.nextInt();
          scan.nextLine(); // Consume newline character
      
          if (attackNumber == 1 || attackNumber == 2) {
              Attack(attackNumber, player, targetPlayer);
          } else {
              System.out.println("Invalid attack number! Choose 1 or 2.");
          }
        }

        /**
         * chooses card from the bench to add to active
         * if the active pile is full, print active is full
         * @param cardNumber number from the bench 
         */
        public void benchToActive(int cardNumber){
            if (activePile.size() < 1){
                activePile.add(benchPile.get(cardNumber));
                benchPile.remove(cardNumber);
            }
            else{
                //swaps active and bench pokemon
                Card temp = activePile.get(0);
                activePile.remove(0);
                activePile.add(benchPile.get(cardNumber));
                benchPile.remove(cardNumber);
                benchPile.add(temp);
                System.out.println("You swapped active pokemon with bench pokemon");
                System.out.println();
            }
        }

        /**
         * while continue turn is true or until the player ends turn
         * allows current player to choose from an action
         * turn continues until player inputs 4 to end turn
         * @param player player who has current turn
         * @param targetPlayer opponent player for that turn
         */
        public void playerAction(Player player, Player targetPlayer){
            //while the continueTurn keep playing turn
            //if the player ends turn, condition turns false causing turn loop to end.
            boolean continueTurn = true;
            while(continueTurn == true){
            // ask the player to choose an action number
            //player.printHand();
            System.out.println();
            System.out.println("Choose an action:");
            System.out.println("1: Play a card");
            System.out.println("2: Move a Pokemon from bench to active");
            System.out.println("3: Attack");
            System.out.println("4: End turn");
            System.out.println();
        
            int actionChoice = scan.nextInt();
            scan.nextLine();
        
            if (actionChoice == 1) {
                cardSelection(player);
            } else if (actionChoice == 2) {
                if (benchPile.size() == 0){
                    System.out.println("No Pokemon in bench to move to active.");
                }
                else{
                System.out.println("Choose a Pokemon to move from bench to active:");
                player.printBench();
                int benchPokemon = scan.nextInt() - 1;
                benchToActive(benchPokemon);}
            }else if (actionChoice == 3) {
                attackPhase(player, targetPlayer);
                System.out.println("Turn ended.");
                continueTurn = false;
            } else if (actionChoice == 4) {
                System.out.println("Turn ended.");
                System.out.println();
                continueTurn = false;
            } else {
                System.out.println("Invalid action number! Choose 1, 2, or 3.");
            }
        }
    }

    /**
     * @return returns deck
     */
    public ArrayList<Card> getDeck(){
        return deck;
    }

    /**
     * @return returns hand
     */
    public ArrayList<Card> getHand(){
        return hand;
    }

    /**
     * @return returns prizepile
     */
    public ArrayList<Card> getPrizePile(){
        return prizePile;
    }

    /**
     * @return returns discard pile for whatever reason
     */
    public ArrayList<Card> getDiscardPile(){
        return discardPile;
    }

    /**
     * @return returns bench pile
     */
    public ArrayList<Card> getBenchPile(){
        return benchPile;
    }

    /**
     * @return returns active pile
     */
    public ArrayList<Card> getActivePile(){
        return activePile;
    }

    /**
     * @return returns name of player
     */
    public String getName(){
        return name;
    }
}
