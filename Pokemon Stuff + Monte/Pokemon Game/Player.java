import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
    //stores all pokemon in an arraylist and randomly returns one.
    public Pokemon randomPokemon(){
        Random rand = new Random();
        pokeDex.add(new Pikachu());
        pokeDex.add(new Bulbasaur());
        pokeDex.add(new Squirtle());
        return pokeDex.get(rand.nextInt(pokeDex.size()));
    }

    //stores all pokemon in an arraylist and randomly returns one.
    public Trainer randomTrainer(){
        Random rand = new Random();
        trainerDex.add(new ProfessorsResearch());
        trainerDex.add(new NestBall());
        return trainerDex.get(rand.nextInt(trainerDex.size()));
    }

    
    
    //draws card randomly from deck and puts it in hand. 
     public void drawCard() { 
        Random rng = new Random();
        //System.out.println(deck.size());
        int cardIndex = rng.nextInt(deck.size() ); //find random card
        Card drawnCard = deck.get(cardIndex);
        deck.remove(cardIndex);
        hand.add(drawnCard);
    }

    //draw the seven card for the prize pile
    public void drawPrizePile(){
        Random rng = new Random();
        //System.out.println(deck.size());
        for(int i = 0; i < 6; i++) { //counting to 7       
            int cardIndex = rng.nextInt(deck.size() ); //find random card
            Card drawnCard = deck.get(cardIndex); 
            deck.remove(cardIndex);
            prizePile.add(drawnCard);
        }
    }

    //Draw hand of seven cards
    public void drawHand(){
        for(int i = 0; i < 7; i++) { //counting to 7       
            drawCard();
        }
    }

    //discards card from hand and adds it to discard pile
    public void discardCard(int cardIndex){
        discardPile.add(hand.get(cardIndex));
        hand.remove(cardIndex);
    }

    //evaluates hand to see if there is a pokemon card.
    //returns true if so
    public void printHand(){
        for(int i = 0; i < hand.size(); i++){
            System.out.println(i+1 + ": " + hand.get(i).getName() + " ");
        }
    }

    //adds card to bench pile if bench pile is not full
    public void addToBench(int cardNumber){
        if (benchPile.size() < 5){
            benchPile.add(hand.get(cardNumber));
            hand.remove(cardNumber);
        }
        else{
            System.out.println("Bench is full");
        }
    }

    //adds card to the active pile if the pile is empty
    public void addToActive(int cardNumber){
        if (activePile.size() < 1){
            activePile.add(hand.get(cardNumber));
            hand.remove(cardNumber);
        }
        else {
            System.out.println("Active is full");
        }
    }

    //removes prize card from prize pile and adds it to hand
    public void removePrizeCard(int cardNumber){
        hand.add(prizePile.get(cardNumber));
        prizePile.remove(cardNumber);
    }

    public void turn(Player player) {
        drawCard();
        printHand();
    
        // Prompt the player to choose a card to play
        System.out.println("Pick a card to play: ");
        int cardNum = scan.nextInt();
        playCard(cardNum, player);
    
        // Prompt the player to choose the attack
        System.out.println("Pick an attack:");
        System.out.println("1: Attack One");
        System.out.println("2: Attack Two");
    
        int attackNumber = scan.nextInt();
        scan.nextLine(); // Consume newline character
    
        if (attackNumber == 1 || attackNumber == 2) {
            Attack(attackNumber, player);
        } else {
            System.out.println("Invalid attack number! Choose 1 or 2.");
        }
        //play card
        //play pokemon
        //play energy
        //play trainer
        //attack w/ pokemon
        //attack w/ pokemon and end turn
    }
    public void playCard(int cardNumber, Player player){
        if (hand.get(cardNumber) instanceof Pokemon){
            addToBench(cardNumber);
        }
        else if (hand.get(cardNumber) instanceof Energy){
            attachEnergy(cardNumber);
        }

        else if (hand.get(cardNumber) instanceof Trainer){
            //play trainer card
            playTrainer(cardNumber, player);
        }
    }
    public void attachEnergy(int cardNumber) {
        if (activePile.isEmpty() || !(activePile.get(0) instanceof Pokemon)) {
            System.out.println("No active Pokemon to attach energy to.");
            return;
        }
    }

    public void playTrainer(int cardNumber, Player player){
        if (hand.get(cardNumber) instanceof Trainer){
            Trainer trainerCard = (Trainer) hand.get(cardNumber);
            trainerCard.playable(player);
            discardCard(cardNumber);
        }
    
        Pokemon activePokemon = (Pokemon) activePile.get(0);
        Energy energyCard = (Energy) hand.get(cardNumber);
    
        // Call the Pokemon's method to attach energy
        activePokemon.attachEnergy(energyCard);
    
        // Move energy card from hand to discard pile
        discardCard(cardNumber);
    }

    public void Attack(int attackNumber, Player targetPlayer) {
        if (activePile.isEmpty() || !(activePile.get(0) instanceof Pokemon)) {
            System.out.println("No active Pokemon to attack with.");
            return;
        }
    
        // Retrieve the active Pokemon
        Pokemon activePokemon = (Pokemon) activePile.get(0);

        ArrayList<Card> opponentActivePile = targetPlayer.getActivePile();

        Pokemon opponentPokemon = (Pokemon) opponentActivePile.get(0);
    
        // Check the chosen attack and perform the corresponding action
        switch (attackNumber) {
            case 1:
                activePokemon.attackOne(opponentPokemon);
                break;
            case 2:
                activePokemon.attackTwo(opponentPokemon);
                break;
            default:
                System.out.println("Invalid attack number. Please choose 1 or 2.");
                break;
        }
    }
    

    public ArrayList<Card> getDeck(){
        return deck;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public ArrayList<Card> getPrizePile(){
        return prizePile;
    }

    public ArrayList<Card> getDiscardPile(){
        return discardPile;
    }

    public ArrayList<Card> getBenchPile(){
        return benchPile;
    }

    public ArrayList<Card> getActivePile(){
        return activePile;
    }

    public String getName(){
        return name;
    }
     
}
