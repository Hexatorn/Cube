/**
 * Created by hexatorn on 2016-10-09.
 */
package hexatorn.CubeWindow;
import javax.swing.*;

public class Window extends JFrame{

    private JPanel panelView;

    private Window(){



        super("Cube");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280,800);
        setVisible(true);


        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("menu");
        JMenuItem mItem01 = new JMenuItem("napis");

        setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(mItem01);

        panelView = new View3D();
        add(panelView);
        pack();
    }


    public static void main(String[] args) {

        System.out.println("Hello, Window");
        new Window();
    }
}
