/**
 * Created by hexatorn on 2016-10-09.
 */
package hexatorn.CubeWindow;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class Window extends JFrame{

    private JPanel panelView;

    private Window(){



        super("Cube");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280,800);
        setVisible(true);


        JMenuBar menuBar = new JMenuBar();
        JMenu mFile = new JMenu("Plik");
        JMenu mView = new JMenu("Widok");
        JMenuItem mISave = new JMenuItem("Zapisz");
        JMenuItem mIRead = new JMenuItem("Wczytaj");
        JMenuItem mIClose = new JMenuItem("Zamknij");
        JMenuItem mIShowCoordinateLine = new JCheckBoxMenuItem(new AbstractAction("Osie współrzędnych") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((View3D)panelView).setShowHelpLine();
                ((View3D)panelView).repaint();
            }
        });
        JMenuItem mIShowText = new JCheckBoxMenuItem("Tekst");


        setJMenuBar(menuBar);
        menuBar.add(mFile);
        menuBar.add(mView);
        mFile.add(mISave);
        mFile.add(mIRead);
        mFile.add(mIClose);
        mView.add(mIShowCoordinateLine);
        mView.add(mIShowText);



        panelView = new View3D();
        add(panelView);
        pack();
    }


    public static void main(String[] args) {

        System.out.println("Hello, Window");
        new Window();
    }
}
