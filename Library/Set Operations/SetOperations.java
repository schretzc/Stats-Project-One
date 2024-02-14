
import java.util.ArrayList;
/*
 * Christopher Schretzmann
 * Pick data type... generics reccomended
 * can use days of the week as example
 * 
 * Write method that unions two arraylists
 * Write method that intersects two arraylists
 * write method that returns complement of an arraylist
 *    Write method that accepts 2 parameters( Araaylist and subset arraylist)
 * Dont use the class called set
 */
public class SetOperations <T>{
   
    public SetOperations(){
       
    }
    //method that returns the union of two sets as arraylist of type T
    public ArrayList<T> union(ArrayList<T> set, ArrayList<T> subset){
        //new arraylist to store the union of both sets
        ArrayList<T> union = new ArrayList<>();
        //add all elements of the first set to union
        for(int i = 0; i < set.size(); i++){
            union.add(set.get(i));
        }
        //add all elements of the second set to union 
        for(int i = 0; i < subset.size(); i++){
            union.add(subset.get(i));
        }
        //return arraylist of contents of both sets which is union.
        return union;
    }

    //method that returns interection of two sets as arraylist
    public ArrayList<T> intersect(ArrayList<T>set, ArrayList<T>subset){
        //create new arraylist to store the intersection of both sets
        ArrayList<T> intersect = new ArrayList<>();
        //loop through both sets as nested for loop
        for(int i = 0; i < set.size(); i++){
            for(int j = 0; j < subset.size(); j++){
                //if the element of the set is equal to the element of the subset, add to the interection arraylist
                if (set.get(i).equals(subset.get(j))) {
                    intersect.add(subset.get(j));
                }
            }
        }
        //return the arraylist of the intersection
        return intersect;
    }

    //method that returns complement of an arraylist
    public ArrayList<T> complement(ArrayList<T>set, ArrayList<T> subset){
        //create new arraylist to store the complement of both sets     
        ArrayList<T> complement = new ArrayList<>();
        complement = set;
        //nested for loop to compare both sets
        for(int i = 0; i < set.size(); i++){
            for(int j = 0; j < subset.size(); j++){
                //if the element of set equals the element of subset, remove elemnt from the subset.
                if (set.get(i).equals(subset.get(j))) {
                    complement.remove(subset.get(j));
                }
            }
        }
        //returns the arraylist of the complement of both sets.
        return complement;
    }

    public void runSetOperations(){
        SetOperations<String> test = new SetOperations<>();
       
        ArrayList<String> set = new ArrayList<>();
        set.add("Monday");
        set.add("Tuesday");
        set.add("Wednesday");
        set.add("Thursday");
        set.add("Friday");
        set.add("Saturday");
        set.add("Sunday");

        ArrayList<String> subset = new ArrayList<>();
        subset.add("Monday");
        subset.add("Tuesday");
        subset.add("Wednesday");
        subset.add("Thursday");

        System.out.println("Set: " + set);
        System.out.println("Subset: " + subset);

        System.out.println("Union: " + test.union(set, subset));
        System.out.println("Intersect: " + test.intersect(set, subset));
        System.out.println("Complement: " + test.complement(set, subset));
    }
}