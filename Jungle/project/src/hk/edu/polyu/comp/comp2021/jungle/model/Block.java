package hk.edu.polyu.comp.comp2021.jungle.model;

public class Block {

    private Animal a;
    private int blockType;//0=plain, 1=river, 2=trap, 3=goal(we have to consider the team)

    public Block(){
        this.a=null;
        this.blockType=0;
    }

    public Block(Animal a, int blockType){
        this.a = a;
        this.blockType= blockType;
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
}
