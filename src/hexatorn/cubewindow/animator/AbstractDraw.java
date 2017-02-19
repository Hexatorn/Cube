package hexatorn.cubewindow.animator;
import hexatorn.cubewindow.View3D;

/**
 * Created by hexatorn on 2017-02-19.
 */
public abstract class AbstractDraw {
    View3D.AngleOfView angleOfView;
    protected int size;

    public AbstractDraw(View3D.AngleOfView angleOfView){
        this.angleOfView = angleOfView;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
