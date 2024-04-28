package util;

import java.util.Collection;

import bakery.MagicBakery;
import bakery.CustomerOrder;
//import bakery.ActionType;
import bakery.MagicBakery;
import bakery.Player;
import bakery.Ingredient;
import bakery.MagicBakery.ActionType;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.io.Console;


public class ConsoleUtils {

    private Console console;

    public ConsoleUtils(){

    }

    public String readLine(){
        Console console = System.console();
        return console.readLine();
    }

    public String readLine(String fmt, Object[] args){
        Console console = System.console();
        return console.readLine();
    }

    public ActionType promptForAction(String prompt, MagicBakery bakery){
        return null;
    }

    public CustomerOrder promptForCustomer(String prompt, Collection<CustomerOrder> customers){
        return null;
    }

    public Player promptForExistingPlayer(String prompt, MagicBakery bakery){
        return null;
    }

    public File promptForFilePath(String prompt){;
        File file = new File(prompt);
        return file;
    }

    public Ingredient promptForIngredient(String prompt, Collection<Ingredient> ingredients){
        return null;
    }

    public List<String> promptForNewPlayers(String prompt){
        Console console = System.console();
        String inputStr = console.readLine("Enter the number of players: " + prompt);
        int numberOfPlayers = Integer.parseInt(inputStr);
        List<String> playerList = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++){
            String player = console.readLine("Enter the name of player " + (i + 1) + ": ");
            playerList.add(player);
        }
        return playerList;
        //return null;  ----------- CHECK THIS WHOLE METHOD WITH SAFWAN
        
    }

    public boolean promptForStartLoad(String prompt){
        Console console = System.console();
        String input;
        input = console.readLine(prompt + " Start/Load");
        System.out.println(input);
        if (input.toLowerCase().equals("start")){
            return true;
        } else{
            return false;
        }
    }

    public boolean promptForYesNo(String prompt){
        Console console = System.console();
        String input;
        input = console.readLine(prompt + " Yes/No");
        System.out.println(input);
        if (input.toLowerCase().equals("Yes")){
            return true;
        } else{
            return false;
        }
    }

    private Object promptEnumerateCollection(String prompt, Collection<Object> collection) {
        return null;
    }
}
