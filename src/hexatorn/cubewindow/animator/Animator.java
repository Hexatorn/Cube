package hexatorn.cubewindow.animator;
import hexatorn.cubewindow.View3D;
import hexatorn.util.Delegate;
import java.awt.*;

/**
 * Created by hexatorn on 2017-02-15.
 */
public class Animator {
    private Delegate paintDelegate = new Delegate();
    private View3D view3D;
    public Animator(View3D view3D) {
        this.view3D = view3D;
        paintDelegate.addMethod(new WindowName(view3D));
        paintDelegate.addMethod(new HelpLines(view3D));
    }

    public void paint(Graphics g){
        paintDelegate.run(g);
    }

    public void setShowHelpLine(){
        paintDelegate.addMethod(new HelpLines(view3D));
    }

    public void setHideHelpLine(){
        paintDelegate.removeMethod(new HelpLines(view3D));
    }

    public  void  setShowWindowsName(){
        paintDelegate.addMethod(new WindowName(view3D));
    }

    public void setHideWindowsName(){
        paintDelegate.removeMethod(new WindowName(view3D));
    }

}
