package edu.neumont.jjensen.observer;

import edu.neumont.csc415.Desktop;
import edu.neumont.csc415.DesktopGraphics;
import edu.neumont.csc415.Point;

/**
 * Created by jjensen on 11/14/14.
 */
public abstract class AWindow implements WindowComponent {
    protected Point point1;
    protected Point point2;
    protected Desktop desktop;

    public AWindow(Desktop desktop, Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        this.desktop = desktop;
    }

    public abstract void paint(DesktopGraphics desktopGraphics);
    public abstract void update(char theChar);

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }


}
