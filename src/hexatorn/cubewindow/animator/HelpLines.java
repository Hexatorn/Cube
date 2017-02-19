package hexatorn.cubewindow.animator;
import hexatorn.cubewindow.View3D;
import hexatorn.util.PaintListener;

import java.awt.*;

/**
 * Klasa rysująca osie współrzędnych
 */
 public class HelpLines extends AbstractDraw implements PaintListener {
    public HelpLines(View3D.AngleOfView angleOfView) {
        super(angleOfView);
    }
    public HelpLines(View3D view3D) {
        super(view3D);
    }

    @Override
    public void paintSomeone(Graphics g) {
        //x-axis
        g.drawLine(
                0,
                angleOfView.getPoint00().getY(),
                angleOfView.getPoint00().getX()*2,
                angleOfView.getPoint00().getY());
        //y-axis
        g.drawLine(
                angleOfView.getPoint00().getX(),
                0,
                angleOfView.getPoint00().getX(),
                angleOfView.getPoint00().getY()*2);
        //z-axis
        double radians_AngleOfView = Math.toRadians(angleOfView.getDegrees());
        g.drawLine(
                0,
                angleOfView.getPoint00().getY()+(int) (angleOfView.getPoint00().getX()*Math.tan(radians_AngleOfView)),
                angleOfView.getPoint00().getX()*2,
                angleOfView.getPoint00().getY()-(int) (angleOfView.getPoint00().getX()*Math.tan(radians_AngleOfView)));
    }

    @Override
    public String toString() {
        return "Help Lines";
    }
}
