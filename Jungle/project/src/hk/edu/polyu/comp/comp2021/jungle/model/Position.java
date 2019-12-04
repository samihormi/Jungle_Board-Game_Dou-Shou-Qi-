package hk.edu.polyu.comp.comp2021.jungle.model;

public class Position {
    private int x;
    private int y;

    public Position(int y, int x){
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
