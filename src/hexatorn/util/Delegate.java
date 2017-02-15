package hexatorn.util;

import hexatorn.util.PaintListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hexatorn on 2017-02-15.
 */
public class Delegate {
    private List<PaintListener> listeners = new ArrayList<>();

    public void addMethod(PaintListener toAdd) {
        listeners.add(toAdd);
    }

    public void removeMethod(PaintListener toRemove) {
        List<PaintListener> objectToRemove = new ArrayList<>();
        for (PaintListener pl : listeners)
            if (toRemove.toString() == pl.toString())
                objectToRemove.add(pl);
        for (PaintListener rmPL : objectToRemove)
            listeners.remove(rmPL);
    }

    public void run(Graphics g) {
        for (PaintListener pl : listeners)
            pl.paintSomeone(g);
    }
}
