/**
 * Created by hexatorn on 2016-10-16.
 */

package hexatorn.CubeWindow;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import hexatorn.Point;

class Animator {

    private int degrees_AngleOfView = 45;
    private Point point00 = new Point();
    private Graphics gDc;
    private Component component;
    Delegate paintDelegate = new Delegate();


    Animator(Component component ){
        this.component = component;
        gDc = component.getGraphics();

        paintDelegate.addPaintMethod(new Refresh());
        paintDelegate.addPaintMethod(new WindowName());
        paintDelegate.addPaintMethod(new HelpLines());

    }

    void updatePoint00(){
        point00.setX(component.getSize().width/2);
        point00.setY(component.getSize().height/2);
    }

    class HelpLines implements PaintListener{

        @Override
        public void paintSomeone(Graphics gDC) {
            int height = component. getSize().height;
            int wedth = component.getSize().width;

            //x-axis
            gDC.drawLine(
                    0,
                    point00.getY(),
                    point00.getX()*2,
                    point00.getY());
            //x-axis
            gDC.drawLine(
                    point00.getX(),
                    0,
                    point00.getX(),
                    point00.getY()*2);
            //z-axis
            double radians_AngleOfView = Math.toRadians(degrees_AngleOfView);
            gDC.drawLine(
                    0,
                    point00.getY()+(int) (point00.getX()*Math.tan(radians_AngleOfView)),
                    point00.getX()*2,
                    point00.getY()-(int) (point00.getX()*Math.tan(radians_AngleOfView)));
            //System.out.println(Math.tan(radians_AngleOfView));
        }
    }

    class WindowName implements PaintListener{

        @Override
        public void paintSomeone(Graphics gDC) {
            gDc.drawString("Cube Window Project; punkt 00 "+point00.getX()+" "+point00.getY(),20,50);
        }
    }
    class Refresh implements PaintListener{

        @Override
        public void paintSomeone(Graphics gDC) {
            gDc.clearRect(0,0,component.getSize().width,component.getSize().height);
        }
    }

    interface PaintListener{
        void paintSomeone(Graphics gDC);
    }
    class Delegate{
        private List<PaintListener> listeners = new ArrayList<PaintListener>();

        void addPaintMethod(PaintListener toAdd){
            listeners.add(toAdd);
        }

        void paint(){
            for (PaintListener pl : listeners)
                pl.paintSomeone(gDc);
        }

    }
}
