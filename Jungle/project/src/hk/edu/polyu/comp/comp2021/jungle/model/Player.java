package hk.edu.polyu.comp.comp2021.jungle.model;

public class Player implements java.io.Serializable{
    private String name;
    private int id;


    public Player(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
