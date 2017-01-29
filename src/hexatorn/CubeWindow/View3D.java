/**
 * Created by Hexatorn on 2017-01-13.
 */

package hexatorn.CubeWindow;

import hexatorn.point.Point;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

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
        paintDelegate.addPaintMethod(new WindowName());
        paintDelegate.addPaintMethod(new HelpLines());
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        updatePoint00();
        paintDelegate.paint(g);
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
    class HelpLines implements PaintListener{

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
        paintDelegate.addPaintMethod(new HelpLines());
    }

    public void setHideHelpLine(){
        paintDelegate.removePaintMethod(new HelpLines());
    }

    /**
     * Obsługa Delegt podobnie jak w C#
     * Tablica Metod wywoływanych jedną komendą.
     */
    interface PaintListener{
        void paintSomeone(Graphics g);
    }
    class Delegate{
        private List<PaintListener> listeners = new ArrayList<>();

        void addPaintMethod(PaintListener toAdd) {
            listeners.add(toAdd);
        }
        void removePaintMethod(PaintListener toRemove){
            List<PaintListener> objectToRemove = new ArrayList<>();
            for(PaintListener pl : listeners)
                if(toRemove.toString()==pl.toString())
                    objectToRemove.add(pl);
            for (PaintListener rmPL : objectToRemove)
                listeners.remove(rmPL);
        }
        void paint(Graphics g){
            setBackground(backgroundColor);
            g.setColor(usingColor);
            for (PaintListener pl : listeners)
                pl.paintSomeone(g);
        }

    }
}
