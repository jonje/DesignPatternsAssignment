package edu.neumont.jjensen.observer;

import edu.neumont.csc415.Desktop;
import edu.neumont.csc415.Point;

/**
 * Created by jjensen on 11/17/14.
 */
public class WindowFactory {

    public static AWindow createWindow(Desktop desktop, AbstractKeyboard keyboard, Point point1, Point point2, DecoratorType...types){
        AWindow window = new Window(desktop, keyboard, point1, point2);

        for(int i = 0; i < types.length; i++) {
            if(types[i].equals(DecoratorType.BORDER)) {
                window = new BorderDecorator(window, desktop, window.getPoint1(), window.getPoint2());
            } else if(types[i].equals(DecoratorType.TITLE_BAR)) {
                window = new TitleBarDecorator(window, desktop, window.getPoint1(), window.getPoint2());
            }
        }

        return window;
    }
}