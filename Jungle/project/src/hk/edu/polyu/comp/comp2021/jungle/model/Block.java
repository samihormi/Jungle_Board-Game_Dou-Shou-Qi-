package hk.edu.polyu.comp.comp2021.jungle.model;

import org.jetbrains.annotations.Nullable;

/**
 * Creates the blocks making up the game board
 * Assigns a type to each block
 * Assigns a side of the board to each player
 */
public class Block implements java.io.Serializable{

    @Nullable
    private Animal a;
    private int blockType;//0=plain, 1=river, 2=trap, 3=goal(we have to consider the team)
    @Nullable
    private Player player; //to determine which player's goal

    /**
     * Constructor of the class
     */
    public Block(){
        this.a = null;
        this.blockType = 0;
        this.player = null;
    }

    /**
     *
     * @return animal existing on block
     */
    public Animal getA() {
        return a;
    }

    /**
     *
      * @param a initializes animal
     */
    public void setA(Animal a) {
        this.a = a;
    }

    /**
     *
     * @return type of block
     */
    public int getBlockType() {
        return blockType;
    }

    /**
     *
     * @param blockType initializes blockType
     */
    public void setBlockType(int blockType) {
        this.blockType = blockType;
    }

    /**
     *
     * @param player initializes player
     */
    public void setPlayer(Player player){
        this.player=player;
    }

    /**
     *
     * @return player on particular block
     */
    public Player getPlayer(){
        return player;
    }
}
