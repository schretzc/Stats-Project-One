import java.util.ArrayList;
public class ProfessorsResearch extends Trainer {
    public ProfessorsResearch(){
    }
    @Override
    public void playable(Player player){
        ArrayList<Card> deck = player.getDeck();
        ArrayList<Card> hand = player.getHand();
        ArrayList<Card> discard = player.getDiscardPile();;
        for(int i = 0; i < hand.size(); i++){
            discard.add(hand.get(0));
            hand.remove(0);
        }
        for(int i = 0; i < 7; i++){
            hand.add(deck.get(0));
            deck.remove(0);
        }
        System.out.println("Professor's Research has been played");
        System.out.println(player.getName() + " has discarded their hand and drawn 7 cards from their deck.");
       
    }

    @Override
    public String getName(){
        return "Professor's Research";
    }


    
}
