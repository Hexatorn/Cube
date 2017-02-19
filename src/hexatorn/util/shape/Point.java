/**
 * Created by hexatorn on 2016-10-16.
 */
package hexatorn.util.shape;

public class Point {

    protected int x;
    protected int y;
    public Point(){

    }
    public Point(int x , int y ){
        setX(x);
        setY(y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {

        return x;
    }

    public int getY() {
        return y;
    }
}
