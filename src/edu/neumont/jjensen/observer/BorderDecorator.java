package edu.neumont.jjensen.observer;

import edu.neumont.csc415.Desktop;
import edu.neumont.csc415.DesktopColor;
import edu.neumont.csc415.DesktopGraphics;
import edu.neumont.csc415.Point;

/**
 * Created by jjensen on 11/14/14.
 */
public class BorderDecorator extends WindowComponentDecorator {

    public BorderDecorator(AWindow windowComponent, Desktop desktop,Point point1, Point point2) {
        super(desktop, new Point(point1.getX() -5, point1.getY()-5), new Point(point2.getX() +5, point2.getY() +5));
        this.windowComponent = windowComponent;
    }

    @Override
    public void paint(DesktopGraphics desktopGraphics) {
        //Paint border

        desktopGraphics.fillRectangle(new Point(point1.getX(),point1.getY()), new Point(point2.getX(), point2.getY()), DesktopColor.BLACK);
        windowComponent.paint(desktopGraphics);

    }

    @Override
    public void update(char theChar) {

    }
}
