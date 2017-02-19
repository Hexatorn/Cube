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

    @Override
    public void paintSomeone(Graphics g) {
        //x-axis
        g.drawLine(
                angleOfView.getPanelSize().width/2*-1,
                0,
                angleOfView.getPanelSize().width/2,
                0);
        //y-axis
        g.drawLine(
                0,
                angleOfView.getPanelSize().height/2*-1,
                0,
                angleOfView.getPanelSize().height/2);
        //z-axis
        double radians_AngleOfView = Math.toRadians(angleOfView.getDegrees());
        g.drawLine(
                angleOfView.getPanelSize().width/2*-1,
                (int)(angleOfView.getPanelSize().width/2*Math.tan(radians_AngleOfView)),
                angleOfView.getPanelSize().width/2,
                (int)(angleOfView.getPanelSize().width/2*Math.tan(radians_AngleOfView)*-1));
    }

    @Override
    public String toString() {
        return "Help Lines";
    }
}
