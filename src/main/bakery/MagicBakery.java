package bakery;

import java.util.Collection;
import bakery.Customers;
import bakery.MagicBakery;
import util.CardUtils;
import util.ConsoleUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.List;


public class MagicBakery implements Serializable{

    private Customers customers;
    private Collection<Layer> layers;
    private Collection<Player> players;
    private Collection<Ingredient> pantry;
    private Collection<Ingredient> pantryDeck;
    private Collection<Ingredient> pantryDiscard;
    private Random random;
    private static final long serialVersionUID = 1L;

    
    public MagicBakery(long seed, String ingredientDeckFile, String layerDeckFile){
        
        Ingredient flour = new Ingredient("flour");
        Ingredient sugar = new Ingredient("sugar");
        Ingredient butter = new Ingredient("butter");
        Ingredient eggs = new Ingredient("butter");


        ArrayList<Ingredient> recipe = new ArrayList<Ingredient>();

        recipe.add(flour);
        recipe.add(sugar);
        recipe.add(butter);
        recipe.add(eggs);

        Layer cake = new Layer("cake", recipe);

    }

    public void bakeLayer(Layer layer){
    }

    private Ingredient drawFromPantryDeck(){
        return null;
    }

    public void drawFromPantry(String ingredientName){

    }

    public void drawFromPantry(Ingredient ingredient){

    }

    public boolean endTurn(){
        return false;
    }

    public List<Ingredient> fulfillOrder(CustomerOrder customer, boolean garnish){
        return null;
    }

    public int getActionsPermitted(){
        return 0;
    }

    public int getActionsRemaining(){
        return 0;
    }

    public Collection<Layer> getBakeableLayers(){
        return null;
    }

    public Player getCurrentPlayer(){
        return null;
    }

    public Customers getCustomers(){
        return customers;
    }

    public Collection<CustomerOrder> getFulfilableCustomers(){
        return null;
    }

    public Collection<CustomerOrder> getGarnishableCustomers(){
        return null;
    }

    public Collection<Layer> getLayers(){
        return null;
    }

    public Collection<Ingredient> getPantry(){
        return null;
    }

    public Collection<Player> getPlayers(){
        return null;
    }

    public static MagicBakery loadState(File file){
        return null;
    }

    public void passCard(Ingredient ingredient, Player recipient){
    }

    public void printCustomerServiceRecord(){

    }

    public void printGameState(){

    }

    public void refreshPantry(){

    }

    public void saveState(File file){

    }

    public void startGame (List<String> playerNames, String customerDeckFile){
        System.out.println(playerNames.toString());
        for (String name : playerNames){
            Player player = new Player(name);
            players.add(player);
        }
    }

    public enum ActionType{
        DRAW_INGREDIENT, PASS_INGREDIENT, BAKE_LAYER, FULFIL_ORDER, REFRESH_PANTRY;
    }

}
