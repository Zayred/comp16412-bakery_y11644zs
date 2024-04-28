package bakery;


import java.io.Serializable;


public class Ingredient implements Serializable, Comparable<Ingredient>{

    private String name;
    private static final long serialVersionUID = 1L;
    public static final Ingredient HELPFUL_DUCK = new Ingredient("helpful duck");

    public Ingredient(String name) {
        this.name = name;
    }

    public boolean equals(Object o){
        return false;
    }

    public int hashCode(){
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }

    public int compareTo(Ingredient o){
        return this.name.compareTo(o.name);
    }
}
