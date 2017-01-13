/**
 * Created by hexatorn on 2016-10-09.
 */

package hexatorn.CubeWindow;

import javax.swing.*;
import java.awt.*;


public class Window extends JFrame{

    private Animator animator;

    private Window(){
        super("Cube");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280,800);
        setVisible(true);
        animator = new Animator(this);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("menu");
        JMenuItem mItem01 = new JMenuItem("napis");

        setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(mItem01);

    }


   public void paint (Graphics gDC){
        if (animator == null)
            return;
        /**
         * aktualizacja początku osi współrzędnych
         */
        animator.updatePoint00();
        /**
         * Wywołanie delagaty z metodami rysującymi/przerysowywującymi poszczególne fragmenty okna
         */
        animator.paintDelegate.paint();
    }

    public static void main(String[] args) {
        int i = 1;
        System.out.println(i);
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, Window");
        new Window();
    }
}
