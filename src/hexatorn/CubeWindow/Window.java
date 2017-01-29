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
        mFile.setName("MiFile");
        JMenu mView = new JMenu("Widok");
        mView.setName("mView");
        JMenuItem mISave = new JMenuItem("Zapisz");
        mISave.setName("mISave");
        JMenuItem mIRead = new JMenuItem("Wczytaj");
        mIRead.setName("mIRead");
        JMenuItem mIClose = new JMenuItem("Zamknij");
        mIClose.setName("mIClose");
        JMenuItem mIShowCoordinateLine = new JCheckBoxMenuItem("Osie współrzędnych");
        ((JCheckBoxMenuItem)mIShowCoordinateLine).setState(true);
        AbstractAction actionShowCoordinateLine = new AbstractAction("Osie współrzędnych") {
            @Override
            public void actionPerformed(ActionEvent e) {
                View3D view3D = (View3D)panelView;
                JCheckBoxMenuItem jCheckBoxMenuItem = (JCheckBoxMenuItem) mIShowCoordinateLine;
                if(jCheckBoxMenuItem.getState()==true) {
                    view3D.setShowHelpLine();
                }
                if(jCheckBoxMenuItem.getState()==false) {
                    view3D.setHideHelpLine();
                }
                view3D.repaint();
            }
        };
        mIShowCoordinateLine.addActionListener(actionShowCoordinateLine);
        mIShowCoordinateLine.setName("mIShowCoordinateLine");
        JMenuItem mIShowText = new JCheckBoxMenuItem("Windows Name");
        ((JCheckBoxMenuItem)mIShowText).setState(true);
        AbstractAction actionShowText = new AbstractAction("Windows Name") {
            @Override
            public void actionPerformed(ActionEvent e) {
                View3D view3D = (View3D)panelView;
                JCheckBoxMenuItem jCheckBoxMenuItem = (JCheckBoxMenuItem) mIShowText;
                if(jCheckBoxMenuItem.getState()==true) {
                    view3D.setShowWindowsName();
                    System.out.println("show");
                }
                if(jCheckBoxMenuItem.getState()==false) {
                    view3D.setHideWindowsName();
                    System.out.println("hide");
                }
                view3D.repaint();
            }
        };
        mIShowText.addActionListener(actionShowText);
        mIShowText.setName("mIShowText");

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
