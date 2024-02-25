import java.util.ArrayList;
import java.util.Random;

/**
 * nestball is a trainser card that searches deck for pokemon and randomly chooses from the pokemon in deck
 * this pokemon is added to bench
 */
public class NestBall extends Trainer {
    
    @Override
    public void playable(Player player){
        ArrayList<Card> deck = player.getDeck();
        ArrayList<Card> bench = player.getBenchPile();
        
        //find all pokemon
        ArrayList<Card> tempPokemon = new ArrayList<Card>();
        //boolean done = false
        int i = 0;
        while (i < deck.size()){
            if (deck.get(i) instanceof Pokemon){
                tempPokemon.add(deck.get(i));
                deck.remove(i);
            } else {
                i++;
            }
        }

        Random rng = new Random();
        int saveRandomNumber = rng.nextInt(tempPokemon.size());
        bench.add(tempPokemon.get(saveRandomNumber));
        tempPokemon.remove(saveRandomNumber);

        for(int j = 0; j< tempPokemon.size(); j++){
            deck.add(tempPokemon.get(j));
        }
        System.out.println("Nest Ball has been played");
        System.out.println(player.getName() + " has searched their deck for a pokemon");
        System.out.println(player.getName() + " has added a random pokemon to their bench.");
    }

    @Override
    public String getName(){
        return "Nest Ball";
    }
    
}
