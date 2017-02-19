package hexatorn.cubewindow.animator;

import hexatorn.cubewindow.View3D;
import hexatorn.util.PaintListener;
import hexatorn.util.shape.Point;

import java.awt.*;

/**
 * Created by hexatorn on 2017-02-19.
 */
public class DrawablePoint extends AbstractDraw implements PaintListener {

    private Point point;
    private int size = 200;

    public DrawablePoint(View3D.AngleOfView angleOfView, Point point) {
        super(angleOfView);
        this.point = point;
    }
    public DrawablePoint(View3D.AngleOfView angleOfView, int x, int y) {
        super(angleOfView);
        this.point = new Point(x,y);
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void paintSomeone(Graphics g) {
        g.fillOval(point.getDrowableX()-(size/2),point.getDrowableY()-(size/2),size,size);
    }


}
