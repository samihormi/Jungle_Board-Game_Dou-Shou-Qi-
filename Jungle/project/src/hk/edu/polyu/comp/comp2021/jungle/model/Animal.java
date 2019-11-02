package hk.edu.polyu.comp.comp2021.jungle.model;

public class Animal {
    private int rank;
    private Position P;
    private Player ply;
    private boolean isAlive;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Position getP() {
        return P;
    }

    public void setP(Position p) {
        P = p;
    }

    public Player getPly() {
        return ply;
    }

    public void setPly(Player ply) {
        this.ply = ply;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void changeIsAlive() {
        this.isAlive = !this.isAlive;
    }
}
