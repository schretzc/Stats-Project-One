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
private ArrayList<Card> prizePile;

/**
 * This constructs the deck and hand
 * we start the deck with one pokemon 
 */
public  MonteCarloSimulation(){
this.deck = new ArrayList<Card>();
this.hand = new ArrayList<Card>();
this.prizePile = new ArrayList<Card>();

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
     * adds specificied amount of rare candy to deck
     * clears deck and hand
     * adds 15 pokemon and energy to deck
     * fills rest with trainer cards
     * @param rareCandyCount amount of rare candy to add to deck
     */
    private void rareCandyAmountAndReset(int rareCandyCount){
        deck.clear();
        hand.clear();
        for(int i = 0; i<rareCandyCount ; i++){
            deck.add(new RareCandy());
        }
        for(int i = 0; i < 15; i++){
            deck.add(new Pokemon());
        }
        for(int i = 0; i < 15; i++){
            deck.add(new Energy());
        }
        int cardCount = 60 - rareCandyCount - 15 - 15;
        for(int i = 0; i < cardCount; i++){
            deck.add(new Trainer());
        }
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

    public double evaluatePrizePile(){
        double candyCount = 0;
        for(int i = 0; i < prizePile.size(); i++){
            Card currentCard = prizePile.get(i);
            if (currentCard instanceof RareCandy){
                candyCount++;
            }
        }
        return candyCount;
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

    public void runMonteToo(){
        /**
         * Use Existing Pokemon Deck
         * Rare Candy Card skips middle evolution to go to final evolution
         * Monte Carlo chance of failure
         * Charziard deck needs to find rare candy to have a winning chance
         * what if rare candy wasnt in deck? it was in prize pile
         * Write monte Carlo simulation adding 1+2+3+4 rare candy trainer cards into deck
         * Implementing not required
         * find the odds given that a pokemon was in the opening hand, 
         * what are the odds that your deck is "bricked" (no win condition left)
         * what is the probability that your rare candy is in prize pile
         * 15 pokemon , 15 energy, rest trainer (4 rare candy)
         * find odds if a pokemon is in hand what are the odds that deck is bricked
         * once program runs and works, solve it using math and conditional probability
         * only if hand has pokemon
         * live inside monte carlo
         *
         * make trainer rare candy
         */
        for (int i = 0; i < 4; i++){
            //iniying count to zero for 
            double pCount = 0;
            double tCount  = 0;
            rareCandyAmountAndReset(i+1);
            drawPrizePile();
            for (int j = 0; j < 1000000; j++){
                hand.clear();
                prizePile.clear();
                drawPrizePile();
                drawHand();
                if (evaluateOpeningHand() == true){
                    pCount++;
                    if (evaluatePrizePile() == i+1){
                        tCount++;
                    }
                }
                rareCandyAmountAndReset(i+1);
            }

            System.out.println("The probability of getting a pokemon in hand is: " + pCount / 10000.000 + "%");
            System.out.println("The probability of all rare candy cards in prize pile given there is a pokemon in hand is: " + tCount / 10000.000 + "%");
            System.out.println();


            //tCount is p(A and B) and pCount is p(B).
            //p(A|B) = p(A and B) / p(A)
        }





    }













    
}