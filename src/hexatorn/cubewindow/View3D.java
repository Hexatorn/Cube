/**
 * Created by Hexatorn on 2017-01-13.
 */

package hexatorn.cubewindow;

import hexatorn.point.Point;
import hexatorn.util.Delegate;
import hexatorn.util.PaintListener;

import javax.swing.*;
import java.awt.*;

class View3D extends JPanel {

    private int degrees_AngleOfView = 45;
    private Point point00 = new Point();
    private Delegate paintDelegate = new Delegate();
    private Color backgroundColor = Color.DARK_GRAY;
    private Color usingColor = new Color(255,205,100);

    /**
     * Konstruktor Panelu z Obiektem 3D
     */
    View3D(){
        setPreferredSize(new Dimension(400, 400));
        paintDelegate.addMethod(new WindowName());
        paintDelegate.addMethod(new HelpLines());
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        updatePoint00();
        setBackground(backgroundColor);
        g.setColor(usingColor);
        paintDelegate.run(g);
    }

    /**
     * Aktualizacja początkowego punktu osi współrzędnych
     */
    private void updatePoint00(){
        point00.setX(getSize().width/2);
        point00.setY(getSize().height/2);
    }

    /**
     * Klasa rysująca osie współrzędnych
     */
    class HelpLines implements PaintListener {

        @Override
        public void paintSomeone(Graphics g) {
            int height = getSize().height;
            int wedth = getSize().width;

            //x-axis
            g.drawLine(
                    0,
                    point00.getY(),
                    point00.getX()*2,
                    point00.getY());
            //x-axis
            g.drawLine(
                    point00.getX(),
                    0,
                    point00.getX(),
                    point00.getY()*2);
            //z-axis
            double radians_AngleOfView = Math.toRadians(degrees_AngleOfView);
            g.drawLine(
                    0,
                    point00.getY()+(int) (point00.getX()*Math.tan(radians_AngleOfView)),
                    point00.getX()*2,
                    point00.getY()-(int) (point00.getX()*Math.tan(radians_AngleOfView)));
            //System.out.println(Math.tan(radians_AngleOfView));
        }

        @Override
        public String toString() {
            return "Help Lines";
        }
    }

    /**
     * Klasa rysująca napis w oknie
     */
    class WindowName implements PaintListener{

        @Override
        public void paintSomeone(Graphics g) {
            g.drawString("Cube Window Project; punkt 00 "+point00.getX()+" "+point00.getY(),20,50);
        }

        @Override
        public String toString() {
            return "Windows Name";
        }
    }

    public void setShowHelpLine(){
        paintDelegate.addMethod(new HelpLines());
    }

    public void setHideHelpLine(){
        paintDelegate.removeMethod(new HelpLines());
    }

    public  void  setShowWindowsName(){
        paintDelegate.addMethod(new WindowName());
    }

    public void setHideWindowsName(){
        paintDelegate.removeMethod(new WindowName());
    }

}
