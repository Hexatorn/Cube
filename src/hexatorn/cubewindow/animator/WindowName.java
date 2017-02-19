package hexatorn.cubewindow.animator;

import hexatorn.cubewindow.View3D;
import hexatorn.util.PaintListener;

import java.awt.*;

/**
 * Klasa rysująca napis w oknie
 */
public class WindowName extends AbstractDraw implements PaintListener {

    public WindowName(View3D.AngleOfView angleOfView) {
        super(angleOfView);
    }

    @Override
    public void paintSomeone(Graphics g) {
        //g.drawString("Cube Window Project; punkt 00 "+angleOfView.getPoint00().getX()+" "+angleOfView.getPoint00().getY(),20,50);
        g.drawString("Cube Window Project; punkt 00 ",20,50);
    }

    @Override
    public String toString() {
        return "Windows Name";
    }
}
