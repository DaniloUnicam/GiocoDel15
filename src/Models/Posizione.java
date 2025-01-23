package Models;

import Abstractions.Models.IPosition;

public class Posizione implements IPosition {
    private int x;
    private int y;

    public Posizione(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Posizione(Posizione pos) {
        this.x = pos.x;
        this.y = pos.y;
    }

    public boolean equals(Posizione pos) {
        return this.x == pos.x && this.y == pos.y;
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
