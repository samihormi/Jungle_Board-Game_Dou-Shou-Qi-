package hk.edu.polyu.comp.comp2021.jungle.model;

/**
 * Represents an animal inside the game
 * Each animal has a ranking a position and belongs to a palyer
 */
public class Animal implements java.io.Serializable {
    private int rank;
    private Position P;
    private Player ply;

    /**
     * @param rank assigns a rank to the animal from 1 to 8
     * @param P    assigns a position inside the board to the animal
     * @param ply  assigns the animal to one of the two player
     */
    public Animal(int rank, Position P, Player ply) {
        setRank(rank);
        setP(P);
        setPly(ply);

    }

    /**
     * @return returns the rank of the animal
     */
    public int getRank() {
        return rank;
    }

    /**
     * @param rank assigns a rank to an animal
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * @return returns the position of the animal
     */
    public Position getP() {
        return P;
    }

    /**
     * @param p assigns a position to the animal
     */
    public void setP(Position p) {
        P = p;
    }

    /**
     * @return returns the owner of the animal
     */
    public Player getPly() {
        return ply;
    }

    /**
     * @param ply assigns an owner to the animal
     */
    public void setPly(Player ply) {
        this.ply = ply;
    }
}