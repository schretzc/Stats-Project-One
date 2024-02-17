import java.util.ArrayList;

public interface Attackable {
    void attackOne(Pokemon target, ArrayList<Energy> energyPile);
    void attackTwo(Pokemon target, ArrayList<Energy> energyPile);
}
