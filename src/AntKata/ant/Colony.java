package AntKata.ant;

import AntKata.ant.Ant;
import AntKata.ant.CellType;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Colony {
    private List<Ant> ants;
    private Point position;
    private int foodCollected;


    public Colony(int nbAnts, Point position) {
        this.ants = new ArrayList<>();
        this.position = position;
        this.foodCollected = 0;
        for(int i = 0; i< nbAnts; i++)
        {
            ants.add(new Ant(position));
        }
    }

    public int next(List<Point> food) {
        for (Ant a : ants) {
            a.scatter();
            switch (a.getStatus()) {
                case WANDERING:
                    break;
                case RETURNING_COLONY:
                    break;
                case FETCHING_FOOD:
                    break;
                default:
            }

        }
        return foodCollected;
    }

    public List<Ant> getAnts() {
        return ants;
    }

    public int getPositionX() { return position.x; }

    public int getPositionY() {
        return position.y;
    }

}
