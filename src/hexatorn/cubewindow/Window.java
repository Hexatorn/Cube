/**
 * Created by hexatorn on 2016-10-09.
 */
package hexatorn.cubewindow;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class Window extends JFrame{

    private JPanel panelView;

    private Window(){

        super("Cube");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280,800);
        setVisible(true);
        /**
         * Utworzenie Głównego widoku i dodanie do kontenera
         */
        panelView = new View3D();
        add(panelView);
        pack();
        /**
         * Utworzenie głównego menu
         */
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        /**
         * Utworzenie menu plik
         */
        JMenu mFile = new JMenu("Plik");
        mFile.setName("MiFile");
        menuBar.add(mFile);
        /**
         * Utworzenie menu widok
         */
        JMenu mView = new JMenu("Widok");
        mView.setName("mView");
        menuBar.add(mView);
        /**
         * Utworzenie i obsługa przycisku Plik -> Zapisz
         */
        JMenuItem mISave = new JMenuItem("Zapisz");
        mISave.setName("mISave");
        mFile.add(mISave);
        /**
         * Utworzenie i obsługa przycisku Plik -> Wczytaj
         */
        JMenuItem mIRead = new JMenuItem("Wczytaj");
        mIRead.setName("mIRead");
        mFile.add(mIRead);
        /**
         * Utworzenie i obsługa przycisku Plik -> Zamknij
         */
        {
            JMenuItem mIClose = new JMenuItem("Zamknij");
            AbstractAction actionClose = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            };
            mIClose.addActionListener(actionClose);
            mIClose.setName("mIClose");
            mFile.add(mIClose);
        }
        /**
         * Utworzenie i obsługa przycisku Widok->Osie współrzędnych
         */
        {
            JMenuItem mIShowCoordinateLine = new JCheckBoxMenuItem("Osie współrzędnych");
            ((JCheckBoxMenuItem) mIShowCoordinateLine).setState(true);
            AbstractAction actionShowCoordinateLine = new AbstractAction("Osie współrzędnych") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    View3D view3D = (View3D) panelView;
                    JCheckBoxMenuItem jCheckBoxMenuItem = (JCheckBoxMenuItem) mIShowCoordinateLine;
                    if (jCheckBoxMenuItem.getState() == true) {
                        view3D.getAnimator().setShowHelpLine();
                    }
                    if (jCheckBoxMenuItem.getState() == false) {
                        view3D.getAnimator().setHideHelpLine();
                    }
                    view3D.repaint();
                }
            };
            mIShowCoordinateLine.addActionListener(actionShowCoordinateLine);
            mIShowCoordinateLine.setName("mIShowCoordinateLine");
            mView.add(mIShowCoordinateLine);
        }
        /**
         * Utworzenie i obsługa przycisku Widok->Wiondows Name
         */
        {
            JMenuItem mIShowText = new JCheckBoxMenuItem("Windows Name");
            ((JCheckBoxMenuItem) mIShowText).setState(true);
            AbstractAction actionShowText = new AbstractAction("Windows Name") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    View3D view3D = (View3D) panelView;
                    JCheckBoxMenuItem jCheckBoxMenuItem = (JCheckBoxMenuItem) mIShowText;
                    if (jCheckBoxMenuItem.getState() == true) {
                        view3D.getAnimator().setShowWindowsName();
                        System.out.println("show");
                    }
                    if (jCheckBoxMenuItem.getState() == false) {
                        view3D.getAnimator().setHideWindowsName();
                        System.out.println("hide");
                    }
                    view3D.repaint();
                }
            };

            mIShowText.addActionListener(actionShowText);
            mIShowText.setName("mIShowText");
            mView.add(mIShowText);
        }







    }
    public static void main(String[] args) {
        System.out.println("Hello, Window");
        new Window();
    }
}
