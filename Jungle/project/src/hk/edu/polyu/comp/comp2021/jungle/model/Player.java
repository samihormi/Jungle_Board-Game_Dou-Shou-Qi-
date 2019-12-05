package hk.edu.polyu.comp.comp2021.jungle.model;

/**
 * Initializes the Player value
 */
public class Player implements java.io.Serializable {
    private String name;
    private int id;

    /**
     * @param name player's name
     * @param id   [layer's id
     */
    public Player(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * @return player's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name initializes player's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return player's id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id initializes player's id
     */
    public void setId(int id) {
        this.id = id;
    }
}
