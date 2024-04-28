package util;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Integer;

import bakery.Ingredient;
import bakery.Layer;
import bakery.CustomerOrder;

/**
 * The CardUtils class provides utility methods for reading and parsing files related to a bakery system.
 * @author Zarif 
 * @version 1.8
 */
public class CardUtils {


    private CardUtils(){
    }


    /**
     * Reads a customer file and returns a list of customer orders.
     *
     * @param path   the path to the customer file
     * @param layers a collection of layers used for parsing customer orders
     * @return a list of customer orders read from the file, or null if an error occurs
     */
    public static List<CustomerOrder> readCustomerFile(String path, Collection<Layer> layers) {
        
        BufferedReader reader;


        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            
            List<CustomerOrder> listForCustomerFile = new ArrayList<>();
            Boolean firstLine = true;

            while (line != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                CustomerOrder order = stringToCustomerOrder(line, layers);
                    if (order != null) {
                            listForCustomerFile.add(order);
                        }
            }
        
            return listForCustomerFile;

        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads an ingredient file and returns a list of ingredients.
     *
     * @param path the path to the ingredient file
     * @return a list of ingredients read from the file, or null if an error occurs
     */
    public static List<Ingredient> readIngredientFile(String path){
        BufferedReader reader;
        
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            
            List<Ingredient> listForIngredientFile = new ArrayList<Ingredient>();
            Boolean firstLine = true;

            while (line != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                listForIngredientFile.addAll(stringToIngredients(line));
            }
            reader.close();
            System.out.println(listForIngredientFile.size()); 
            return listForIngredientFile;

        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Reads a layer file and returns a list of layers.
     *
     * @param path the path to the layer file
     * @return a list of layers read from the file, or null if an error occurs
     */
    public static List<Layer> readLayerFile(String path){
        BufferedReader reader;
        
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            
            List<Layer> listForLayerFile = new ArrayList<Layer>();
            Boolean firstLine = true;

            while (line != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                listForLayerFile.addAll(stringToLayers(line));
            }
            reader.close();
            System.out.println(listForLayerFile.size());
            
            return listForLayerFile;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Converts a string representation of a customer order to a CustomerOrder object.
     *
     * @param str    the string representation of the customer order
     * @param layers a collection of layers used for parsing the customer order
     * @return the CustomerOrder object created from the string representation, or null if the string is invalid
     */
    private static CustomerOrder stringToCustomerOrder(String str, Collection<Layer> layers){
        List<CustomerOrder> listOfICustomerOrder = new ArrayList<CustomerOrder>();
        String[] parts = str.split(",");
        if (parts.length < 3) { /// check why he included part.length > 4
            System.err.println("Invalid line: " + str);
            return null;
        } else {


            int level = Integer.parseInt(parts[0].strip());
            String name = parts[1].strip();
            String[] ingredients = parts[2].split(",");
            String[] garnishes = parts[3].split(",");

            ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
            ArrayList<Ingredient> garnishList = new ArrayList<Ingredient>();

            for(String item : ingredients){
                boolean isLayer = false;
                for (Layer layer : layers){
                    if (item.equals(layer.toString())){
                        ingredientList.add(layer);
                        isLayer = true;
                        break;
                    }
                }
                if (isLayer == true){
                    ingredientList.add(new Ingredient(item));
                }
            }

            for(String item : garnishes){
                boolean isLayer = false;
                for (Layer layer : layers){
                    if (item.equals(layer.toString())){
                        garnishList.add(layer);
                        isLayer = true;
                        break;
                    }
                }
                if (isLayer == true){
                    garnishList.add(new Ingredient(item));
                }
            }
        
            return new CustomerOrder(name, ingredientList, garnishList, level);
        }
    }

    /**
     * Converts a string representation of an ingredient to an Ingredient object.
     *
     * @param str the string representation of the ingredient
     * @return the Ingredient object created from the string representation
     */
    private static List<Ingredient> stringToIngredients(String str){
        List<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
        String[] parts = str.split(",");
        if (parts.length == 2) {
            String name = parts[0].strip();
            int recipe = Integer.parseInt(parts[1].strip());
            for (int i = 0; i < recipe; i++) {
                listOfIngredients.add(new Ingredient(name));
            }
        }
        return listOfIngredients;
    }


    /**
     * Converts a string representation of a layer to a Layer object.
     *
     * @param str the string representation of the layer
     * @return the Layer object created from the string representation
     */
    private static List<Layer> stringToLayers(String str){
        List<Layer> listOfLayers = new ArrayList<Layer>();
        String[] parts = str.split(",");
        if (parts.length == 2) {
            String layer = parts[0].strip();
            String[] ingredients = parts[1].split(",");

            List<Ingredient> ingredientList = new ArrayList<Ingredient>();
            for (String ingr : ingredients) {
                ingredientList.add(new Ingredient(ingr));
            }

            for (int i = 0; i < 4; i++){
                listOfLayers.add(new Layer(layer,new ArrayList<> (ingredientList)));
            }
        }
        return listOfLayers;
    }
    
}
    

