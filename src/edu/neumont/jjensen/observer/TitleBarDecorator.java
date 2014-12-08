package edu.neumont.jjensen.observer;

import edu.neumont.csc415.Desktop;
import edu.neumont.csc415.DesktopColor;
import edu.neumont.csc415.DesktopGraphics;
import edu.neumont.csc415.Point;

/**
 * Created by jjensen on 11/14/14.
 */
public class TitleBarDecorator extends WindowComponentDecorator {

    public TitleBarDecorator(AWindow windowComponent, Desktop desktop, Point point1, Point point2) {
        super(desktop, new Point(point1.getX(), point1.getY() - 50), new Point(point2.getX(), point1.getY()));
        this.windowComponent = windowComponent;
    }

    @Override
    public void paint(DesktopGraphics desktopGraphics) {

        desktopGraphics.fillRectangle(new Point(point1.getX(),point1.getY()), new Point(point2.getX(), point2.getY()), DesktopColor.RED);
        String title = "Title";
        int x = point1.getX();
        for(int i = 0; i < title.length(); i++) {
            x += desktop.getCharWidth(title.charAt(i));

            desktopGraphics.drawChar(title.charAt(i),new Point(x, point1.getY() + desktop.getCharHeight()), DesktopColor.BLACK);
        }
        windowComponent.paint(desktopGraphics);

    }

    @Override
    public void update(char theChar) {

    }
}
