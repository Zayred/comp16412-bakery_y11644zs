package bakery;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;



public class CustomerOrder implements Serializable{

    private List<Ingredient> garnish;
    private int level;
    private String name;
    private List<Ingredient> recipe;
    private CustomerOrderStatus status;
    private static final long serialVersionUID = 1L;


    public CustomerOrder(String name, List<Ingredient> recipe, List<Ingredient> garnish, int level){
        this.name = name;
        this.recipe = recipe;
        this.garnish = garnish;
        this.level = level;
        this.status = CustomerOrderStatus.WAITING;
    }

    public void abandon(){
    }

    public boolean canFulfill(List<Ingredient> ingredients){
        return false;
    }

    public boolean canGarnish(List<Ingredient> ingredients){
        return false;
    }

    public List<Ingredient> fulfill(List<Ingredient> ingredients, boolean garnish){
        return null;
    }

    public List<Ingredient> getGarnish(){
        return garnish;
    }

    public String getGarnishDescription(){
        return "";
    }

    public int getLevel(){
        return 0;
    }

    public List<Ingredient> getRecipe(){
        return recipe;
    }

    public String getRecipeDescription(){
        return "";
    }

    public CustomerOrderStatus getStatus(){
            return status;
        }

    public void setStatus(CustomerOrderStatus status){
            this.status = status;
        }

    public String toString(){
        return "";
    }
    
    public enum CustomerOrderStatus{
        WAITING, FULFILLED, GARNISHED, IMPATIENT, GIVEN_UP;
    }

}