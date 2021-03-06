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
    {
        size = 6;
    }

    public DrawablePoint(View3D.AngleOfView angleOfView, Point point) {
        super(angleOfView);
        this.point = point;
    }
    public DrawablePoint(View3D.AngleOfView angleOfView, int x, int y) {
        super(angleOfView);
        this.point = new Point(x,y);
    }

    @Override
    public void paintSomeone(Graphics g) {
        g.fillOval(point.getDrawableX()-(size/2),point.getDrawableY()-(size/2),size+1,size+1);
    }


}
