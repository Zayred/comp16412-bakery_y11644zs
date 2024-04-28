package bakery;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;


public class Layer extends Ingredient implements Serializable{

    private List<Ingredient> recipe;
    private static final long serialVersionUID = 1L;

    public Layer(String name, List<Ingredient> recipe){
        super(name);
        this.recipe = recipe;
    }

    public boolean canBake(List<Ingredient> ingredients){
        return false;
    }

    public List<Ingredient> getRecipe(){
        return recipe;
    }

    public String getRecipeDescription(){
        String recipeDescription = "";
        for(Ingredient ingredient : recipe){
            recipeDescription += ingredient + "\n";
        }
        return recipeDescription;

    }

    public int hashCode(){
        return 0;
    }
    
}
