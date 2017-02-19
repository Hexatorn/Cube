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

    public DrawablePoint(View3D view3D, Point point) {
        super(view3D);
        this.point = point;
    }
    public DrawablePoint(View3D view3D, int x, int y) {
        super(view3D);
        this.point = new Point(x,y);
    }
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
        //g.translate(angleOfView.point00.getX(), angleOfView.point00.getY());
        g.fillOval(point.getX()-(size/2),point.getY()-(size/2),size,size);
    }
}
