import java.util.ArrayList;
import java.util.Random;

public  class MonteCarloSimulation{
private ArrayList<Card> deck;  //this is the constructors job= new Card[];
private ArrayList<Card> hand;
public  MonteCarloSimulation(){
this.deck = new ArrayList<Card>();
this.hand = new ArrayList<Card>();

deck.add(new Pokemon());
int deckSize = 60;
for(int i = 1; i < deckSize; i++){
    deck.add(new Energy());
}
}

 public Card drawCard() { //not draw card and put in hand

        Random rng = new Random();
        //System.out.println(deck.size());
        int cardIndex = rng.nextInt(deck.size() ); //find random card
        Card drawnCard = deck.get(cardIndex);
        deck.remove(cardIndex);
        return drawnCard;
    }

    public void drawHand(){
        for(int i = 0; i < 7; i++) { //counting to 7
            
            hand.add(drawCard());
        }
    }

//Draw hand and check if pokemon is in hand
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

//clears hand and clears deck for each function call
    //creates new deck depending on how many pokemon you want in the deck
    //adds input amount of pokemon in the deck
    //subctracts the amount of pokemon cards from entire deck
    //fills the rest of the deck with energy cards
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

    //make engine for program
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