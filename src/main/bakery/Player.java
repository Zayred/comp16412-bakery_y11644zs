package bakery;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Player implements Serializable{

    private List<Ingredient> hand;
    private String name;
    private static final long serialVersionUID = 1L;


    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addToHand(List<Ingredient> ingredients){
        hand.addAll(ingredients);
    }

    public void addToHand(Ingredient ingredient){
        hand.add(ingredient);
        
    }

    public boolean hasIngredient(Ingredient ingredient){
        return false;
    }
    
    public void removeFromHand(Ingredient ingredient){
        hand.remove(ingredient);
        
    }

    public List<Ingredient> getHand(){
        List<Ingredient> handCopy = new ArrayList<>(hand);
        //List<Ingredient> sortedCollection = Collections.sort(handCopy);
        return handCopy;
    }

    public String getHandStr(){
        return "";
    }

    public String toString(){
        return "";
    }

}
