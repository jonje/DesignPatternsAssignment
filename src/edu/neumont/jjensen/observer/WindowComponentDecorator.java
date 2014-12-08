package edu.neumont.jjensen.observer;

import edu.neumont.csc415.Desktop;
import edu.neumont.csc415.IPaintable;
import edu.neumont.csc415.Point;

/**
 * Created by jjensen on 11/14/14.
 */
public abstract class WindowComponentDecorator extends AWindow {
    protected AWindow windowComponent;

    public WindowComponentDecorator(Desktop desktop, Point point1, Point point2) {
        super(desktop,point1, point2);
    }
}
