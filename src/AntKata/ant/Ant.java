package AntKata.ant;

import AntKata.Random.RNG;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Ant {
    private Point position;
    private Status status;
    private Point lastKnownFoodPosition;
    private Point colony;

    // TODO Attributs

    public Ant(Point colony) {

        this.position = colony ;
        this.status = Status.WANDERING;
        this.lastKnownFoodPosition = null;
        this.colony = colony;

    }

    void scatter() {
        int randomX = RNG.random(-1, 1);
        int randomY = RNG.random(-1, 1);
        int x = this.position.x - this.colony.x;
        int y = this.position.y - this.colony.y;
        int newX=this.getPositionX();
        int newY=this.getPositionY();

        switch(this.getStatus()) {
            case WANDERING:
                this.position = new Point(this.getPositionX()+randomX, this.getPositionY()+randomY);
                break;
            case RETURNING_COLONY:

                this.position = new Point(this.getPositionX()-randomX, this.getPositionY()-randomY);
                break;
            case FETCHING_FOOD:
                this.position = new Point(this.getPositionX()+randomX, this.getPositionY()+randomY);
                break;
            default:
        }

    }

    // TODO Méthodes de classes

    public int getPositionX() {
        return this.position.x;
    }

    public int getPositionY() {
        return this.position.y;
    }

    public Point getPosition() {
        return this.position;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setPosition(Point point) {
        this.position = new Point(point.x, point.y);
    }


    public Point getLastKnownFoodPosition() {
        return lastKnownFoodPosition;
    }
    public void setLastKnownFoodPosition(Point point) {
        this.lastKnownFoodPosition = point;
    }

    public Point getColonyPosition() {
        return colony;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean AntOnColony(){
        return this.position.equals(this.colony);
    }

    public boolean AntOnFood(List<Point> Food){
            boolean bool = false;
            for(Point f: Food ){
                if(f.equals(this.position))
                {
                    bool = true;
                }
            }
        return bool;
        }


    public void AntOnAnt(List<Ant> colony) {
        List<Ant> colonyB = colony;
        colonyB.remove(this);
        for (Ant a : colonyB) {
            if (a.getPosition().equals(this.position)) {
                if(a.getLastKnownFoodPosition() == null && this.lastKnownFoodPosition != null){
                    a.setLastKnownFoodPosition(this.lastKnownFoodPosition);
                    a.setStatus(Status.FETCHING_FOOD);
                }
            }
        }
    }
}
