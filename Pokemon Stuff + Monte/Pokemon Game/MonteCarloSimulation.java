import java.util.ArrayList;
import java.util.Random;

/**
 * This is a montecarlo simulation that uses pokemon cards as a theme
 * We are figuring out the probability of a pokemon being drawn into hand 
 * the hand of 7 is drawn from a deck of 60
 * we will increment the amount of pokemon for each number of tests
 */
public  class MonteCarloSimulation{
private ArrayList<Card> deck;  //this is the constructors job= new Card[];
private ArrayList<Card> hand;

/**
 * This constructs the deck and hand
 * we start the deck with one pokemon 
 */
public  MonteCarloSimulation(){
this.deck = new ArrayList<Card>();
this.hand = new ArrayList<Card>();

deck.add(new Pokemon());
int deckSize = 60;
for(int i = 1; i < deckSize; i++){
    deck.add(new Energy());
}
}
/**
 * draws random card from deck 
 * the drawn card is removed from the deck
 * when drawn, the random card is returned
 * @return returns a card that is drawn from the deck
 */
 public Card drawCard() { //not draw card and put in hand

        Random rng = new Random();
        //System.out.println(deck.size());
        int cardIndex = rng.nextInt(deck.size() ); //find random card
        Card drawnCard = deck.get(cardIndex);
        deck.remove(cardIndex);
        return drawnCard;
    }
    /**
     * draws a hand of 7 using drawCard method
     */
    public void drawHand(){
        for(int i = 0; i < 7; i++) { //counting to 7
            
            hand.add(drawCard());
        }
    }

/**
 * evaluates if a pokemon is in hand
 * @return returns the boolean value if a pokemon is in the hand
 */
public boolean evaluateOpeningHand(){
    boolean havePokemon = false;
    for(int i = 0; i < hand.size(); i++){
        Card currentCard = hand.get(i);
        if(currentCard instanceof Pokemon){
            havePokemon = true;
        }
    }
    return havePokemon;
}

    /**
     * clears hand and deck
     * adds specificied amount of pokemon to deck
     * subtracts amount of pokemon cards from entire deck
     * fills rest with energy cards
     * @param pokemonCount the desired amount of pokemon that will be in the deck 
     */
    private void pokemonAmountAndReset(int pokemonCount) {
        deck.clear();
        hand.clear();
        for (int i = 0; i < pokemonCount; i++) {
            deck.add(new Pokemon());
        }
        int energyCount = 60 - pokemonCount;
        for (int i = 0; i < energyCount; i++) {
            deck.add(new Energy());
        }
    }

    /**
     * engine for the program/simulation
     * constructs a deck for each pass of the loop
     * initializes count to zero
     * calls function to add amount of pokemon with i as parameter
     * for each pass of the amount of pokemon loop, it runs 1000000 times
     * clears and drawns new hand for each pass to account missing cards and odds
     * increments one count for each time a pokemon is in hand
     * turns the count to percent.
     */
    public void runMonte() {
        //contructs every amount of pokemon possible in deck
        //initializes true count to zero
        //calls function to add amount of pokemon with i as the parameter
        //First i had the index starting at zero thats why my data was off at first.
        for (int i=0; i < 60; i++) {
            int tCount = 0;
            pokemonAmountAndReset(i+1);
            //for each pass of the amount of pokemon in the deck, we clear and draw a new hand 100000 times
            //clear and draw hand every pass to account for missing cards
            for (int j = 0; j < 1000000; j++){
                hand.clear();
                drawHand();
               // int num = j+1;
              // System.out.println("Numero:" + num +  "     Has Pokemon: " + evaluateOpeningHand());
               //increment counter each time having pokemon in hand is true
                if(evaluateOpeningHand() == true){
                    tCount++;
        }
            // reset deck after pass
            pokemonAmountAndReset(i+1);
        }
        int num = i+1;
        System.out.println("Number of Pokemon in deck " + num +  " Percentage of True: " + tCount / 10000.000 + "%");
    }
    }













    
}