package hk.edu.polyu.comp.comp2021.jungle.model;

public class Block implements java.io.Serializable{

    private Animal a;
    private int blockType;//0=plain, 1=river, 2=trap, 3=goal(we have to consider the team)
    private Player player; //to determine which player's goal
    public Block(){
        this.a = null;
        this.blockType = 0;
        this.player = null;
    }

    public Block(Animal a, int blockType){
        this.a = a;
        this.blockType= blockType;
        this.player=null;
    }

    public Animal getA() {
        return a;
    }

    public void setA(Animal a) {
        this.a = a;
    }

    public int getBlockType() {
        return blockType;
    }

    public void setBlockType(int blockType) {
        this.blockType = blockType;
    }

    public void setPlayer(Player player){
        this.player=player;
    }

    public Player getPlayer(){
        return player;
    }
}
