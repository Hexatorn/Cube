/**
 * Created by Hexatorn on 2017-01-13.
 */

package hexatorn.cubewindow;

import hexatorn.cubewindow.animator.Animator;
import javax.swing.*;
import java.awt.*;

public class View3D extends JPanel {

    private Animator animator = new Animator( new AngleOfView());
    private Color backgroundColor = Color.DARK_GRAY;
    private Color usingColor = new Color(255,205,100);

    /**
     * Konstruktor Panelu z Obiektem 3D
     */
    public View3D(){
        setPreferredSize(new Dimension(400, 400));
    }


    @Override
    /**
     * Rysowanie Komponentu
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(getSize().width/2,getSize().height/2);
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
        public int getDegrees(){
            return degrees;
        }
        public Dimension getPanelSize(){
            return getSize();
        }
    }
}
