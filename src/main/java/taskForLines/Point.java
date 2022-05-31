package taskForLines;

import java.io.Serializable;
import java.util.Objects;

public class Point extends PointAndLines implements Serializable {

    private int x,y;
    private int countOfLiensPass = 0;

    public Point (int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean checkLienContainsPointAndAnother(Line line){
        return line.getCountOfPointWhichHas()>1 && line.lineHasPoint(this,true);
    }

    public void increaseCountOfLiensPass(){this.countOfLiensPass++;}

    public int getCountOfLiensPass() {return countOfLiensPass;}

    public int getX() {return x;}
    public void setX(int x) {this.x = x;}

    public int getY() {return y;}
    public void setY(int y) {this.y = y;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null) return false;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return this.getX() == point.getX() && this.getY() == point.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getX(), this.getY());
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
