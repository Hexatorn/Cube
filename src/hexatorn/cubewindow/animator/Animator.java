package hexatorn.cubewindow.animator;
import hexatorn.cubewindow.View3D;
import hexatorn.util.Delegate;
import java.awt.*;

/**
 * Created by hexatorn on 2017-02-15.
 */
public class Animator {
    private Delegate paintDelegate = new Delegate();
    private View3D.AngleOfView angleOfView;
    public Animator(View3D.AngleOfView angleOfView) {
        this.angleOfView = angleOfView;
        paintDelegate.addMethod(new WindowName(angleOfView));
        paintDelegate.addMethod(new HelpLines(angleOfView));
        paintDelegate.addMethod(new DrawablePoint(angleOfView,100,200));
    }

    public void paint(Graphics g){
        paintDelegate.run(g);
    }

    public void setShowHelpLine(){
        paintDelegate.addMethod(new HelpLines(angleOfView));
    }

    public void setHideHelpLine(){
        paintDelegate.removeMethod(new HelpLines(angleOfView));
    }

    public  void  setShowWindowsName(){
        paintDelegate.addMethod(new WindowName(angleOfView));
    }

    public void setHideWindowsName(){
        paintDelegate.removeMethod(new WindowName(angleOfView));
    }

}
