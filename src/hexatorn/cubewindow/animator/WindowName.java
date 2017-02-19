package hexatorn.cubewindow.animator;

import hexatorn.cubewindow.View3D;
import hexatorn.util.PaintListener;

import java.awt.*;

/**
 * Klasa rysująca napis w oknie
 */
public class WindowName extends AbstractDraw implements PaintListener {

    int x = 20;
    int y = 50;

    public WindowName(View3D.AngleOfView angleOfView) {
        super(angleOfView);
    }
    public WindowName(View3D.AngleOfView angleOfView, int x, int y) {
        super(angleOfView);
        this.x = x;
        this.y = y;
    }

    @Override
    public void paintSomeone(Graphics g) {
        g.drawString("Cube Window Project; punkt 00 "+angleOfView.getPanelSize().width/2+" "+angleOfView.getPanelSize().height/2,
                (angleOfView.getPanelSize().width/2*-1)+x,
                (angleOfView.getPanelSize().height/2*-1)+y);
    }

    @Override
    public String toString() {
        return "Windows Name";
    }
}
