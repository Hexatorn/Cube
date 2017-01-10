/**
 * Created by hexatorn on 2016-10-09.
 */

package hexatorn.CubeWindow;

import javax.swing.*;
import java.awt.*;


public class Window extends JFrame{

    Animator animator;

    public Window(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280,800);
        setVisible(true);
        animator = new Animator(this);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("menu");
        JMenuItem mi01 = new JMenuItem("napis");

        menuBar.add(menu);
        menu.add(mi01);
        setJMenuBar(menuBar);

    }


    public void paint (Graphics gDC){
        if (animator == null)
            return;
        animator.updatePoint00();
        animator.paintDelegate.paint();
    }

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, Window");
        new Window();
    }
}
