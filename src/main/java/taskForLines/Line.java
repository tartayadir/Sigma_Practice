package taskForLines;

import java.io.Serializable;
import java.util.Objects;

public class Line extends PointAndLines implements Serializable {

    private double k,b;
    private int countOfPointWhichHas = 0;
    private int x,y;
    private boolean OX = false , OY = false;

    public Line(Point p1, Point p2) {

        int x1 = p1.getX(),x2 = p2.getX();
        int y1 = p1.getY(),y2 = p2.getY();

        if (x1 == x2){
            OY = true;
            this.x = (int)x1;

        }else if(y1 == y2){
            OX = true;
            this.y = (int) y1;
        }else {

            k = (y2-y1)*(x2-x1);
            b = y2 - k*x2;
        }

    }

    public boolean lineHasPoint(Point point , boolean callFromMethodOfPointClass){

        if (this.OX && point.getY() == this.y ){
            if(!callFromMethodOfPointClass)countOfPointWhichHas++;
            return true;
        }

        if (this.OY && point.getX() == this.x){
            if(!callFromMethodOfPointClass)countOfPointWhichHas++;
            return true;
        }

        if (point.getY() == Math.round(point.getX()*k + b)){
            if(!callFromMethodOfPointClass)countOfPointWhichHas++;
            return true;
        }
        return false;
    }

    public int getCountOfPointWhichHas() {return countOfPointWhichHas;}

    public double getK() {return k;}
    public void setK(int k) {this.k = k;}

    public double getB() {return b;}
    public void setB(int b) {this.b = b;}

    public boolean isOX() {return OX;}
    public boolean isOY() {return OY;}

    public int getX() {return x;}
    public int getY() {return y;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return getK() == line.getK() && getB() == line.getB() &&
                this.isOX() == line.isOX() && this.isOY() == line.isOY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getK(), this.getB());
    }

    @Override
    public String toString() {
        return "Line{" +
                "k=" + k +
                ", b=" + b +
                '}';
    }
}
