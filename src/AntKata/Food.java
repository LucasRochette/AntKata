package AntKata;

import java.awt.*;

public class Food {
    private Point position;
    private int lifetime;

    public Point getPosition() {
        return position;
    }

    public Food(int x, int y) {
        this.position = new Point(x, y);
        this.lifetime = 60000;
    }

    public boolean isAlive() {
        return this.lifetime > 0;
    }

    public void nextTurn() {
        this.lifetime --;
    }
}
