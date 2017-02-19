package hexatorn.cubewindow.animator;
import hexatorn.cubewindow.View3D;

/**
 * Created by hexatorn on 2017-02-19.
 */
public abstract class AbstractDraw {
    View3D.AngleOfView angleOfView;
    public AbstractDraw(View3D view3D){
        this.angleOfView = view3D.getAngleOfView();
    }
    public AbstractDraw(View3D.AngleOfView angleOfView){
        this.angleOfView = angleOfView;
    }
}
