import java.util.ArrayList;
import java.util.Random;

public class Player {
    private ArrayList<Card> deck;  //this is the constructors job= new Card[];
    private ArrayList<Card> hand;
    private ArrayList<Card> prizePile;
    private ArrayList<Card> discardPile;
    private ArrayList<Card> benchPile;
    private ArrayList<Card> activePile;
    private ArrayList<Pokemon> pokeDex;
    private ArrayList<Energy> energyDex;
    private ArrayList<Trainer> trainerDex;
    private String name;

    public Player(String name){
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
        prizePile = new ArrayList<Card>();
        discardPile = new ArrayList<Card>();
        benchPile = new ArrayList<Card>();
        activePile = new ArrayList<Card>();
        pokeDex = new ArrayList<Pokemon>();
        energyDex = new ArrayList<Energy>();
        trainerDex = new ArrayList<Trainer>();
        this.name = name;

        //fill deck with 20 of each type
        for(int i = 0; i < 20; i++){
            deck.add(randomEnergy());
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
    //stores all energy type cards in an arraylist and randomly returns one
    public Energy randomEnergy(){
        Random rand = new Random();
        energyDex.add(new LeafEnergy());
        energyDex.add(new ElectricEnergy());
        energyDex.add(new WaterEnergy());
        return energyDex.get(rand.nextInt(energyDex.size()));
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

    public void turn(){
        drawCard();
        //play pokemon
        //play energy
        //play trainer
        //attack w/ pokemon
        //attack w/ pokemon and end turn
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
