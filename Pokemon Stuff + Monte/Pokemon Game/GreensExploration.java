import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * search deck for 2 trainer cards and put them into hand
 * for this case, we are going to make it draw a random card from the array of trainer cards
 */
public class GreensExploration extends Trainer{

    public void playable(Player player){
        ArrayList<Card> deck = player.getDeck();
        ArrayList<Card> hand = player.getHand();

        //find all trainer cards
        ArrayList<Card> tempTrainer = new ArrayList<Card>();
        
        for(int i = 0; i < deck.size(); i++){
            if(deck.get(i) instanceof Trainer){
                tempTrainer.add(deck.get(i));
                deck.remove(i);
            }
        }

        Random rng = new Random();
        int saveRandomNumber = rng.nextInt(tempTrainer.size());
        hand.add(tempTrainer.get(saveRandomNumber));
        tempTrainer.remove(saveRandomNumber);
        hand.add(tempTrainer.get(saveRandomNumber));
        tempTrainer.remove(saveRandomNumber);

        for (int j = 0; j < tempTrainer.size(); j++){
            deck.add(tempTrainer.get(j));
        }

        System.out.println("Greens Exploration has been played");
        System.out.println(player.getName() + " has searched their deck for 2 trainer cards");
        System.out.println(player.getName() + " has added 2 trainer cards to their hand.");


    }

   
   
    @Override
    public String getName(){
        return "Green's Exploration";
    }
    
}
