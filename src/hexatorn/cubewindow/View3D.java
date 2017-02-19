/**
 * Created by Hexatorn on 2017-01-13.
 */

package hexatorn.cubewindow;

import hexatorn.cubewindow.animator.Animator;
import hexatorn.draw.point.Point;
import javax.swing.*;
import java.awt.*;

public class View3D extends JPanel {

    private AngleOfView angleOfView = new AngleOfView();
    private Animator animator = new Animator(this);
    private Color backgroundColor = Color.DARK_GRAY;
    private Color usingColor = new Color(255,205,100);

    /**
     * Konstruktor Panelu z Obiektem 3D
     */
    public View3D(){
        System.out.println("Rozpoczecie tworzenia panela");
        setPreferredSize(new Dimension(400, 400));
        System.out.println("Zakoczenie tworzenia panela");
    }


    @Override
    /**
     * Rysowanie Komponentu
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.angleOfView.updatePoint00();
        setBackground(backgroundColor);
        g.setColor(usingColor);
        animator.paint(g);

    }

    public Animator getAnimator() {
        return animator;
    }

    /**
     * Aktualizacja początkowego punktu osi współrzędnych
     */


    public class AngleOfView{
        private int degrees = 45;
        public Point point00 = new Point();
        public void updatePoint00(){
            point00.setX(getSize().width/2);
            point00.setY(getSize().height/2);
        }
        public int getDegrees(){
            return degrees;
        }
        public Point getPoint00(){
            return point00;
        }
        public Dimension getPanelSize(){
            return getSize();
        }
    }

    public AngleOfView getAngleOfView() {
        return angleOfView;
    }
}
