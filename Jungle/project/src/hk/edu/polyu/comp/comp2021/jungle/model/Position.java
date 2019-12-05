package hk.edu.polyu.comp.comp2021.jungle.model;

/**
 * Create position from cartesian coordinates
 */
public class Position implements java.io.Serializable {
    private int x;
    private int y;

    /**
     * @param y position
     * @param x position
     */
    public Position(int y, int x) {
        setX(x);
        setY(y);
    }

    /**
     * @return x position
     */
    public int getX() {
        return x;
    }

    /**
     * @param x initialize x position
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return y position
     */
    public int getY() {
        return y;
    }

    /**
     * @param y initialize y position
     */
    public void setY(int y) {
        this.y = y;
    }
}
