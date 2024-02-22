import java.util.ArrayList;

/**
 * interface for pokemon called attackable
 * ensures each pokemon has two attacks
 */
public interface Attackable {
    void attackOne(Pokemon target, ArrayList<Energy> energyPile);
    void attackTwo(Pokemon target, ArrayList<Energy> energyPile);
}
