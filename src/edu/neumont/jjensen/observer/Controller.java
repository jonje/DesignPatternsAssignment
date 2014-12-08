package edu.neumont.jjensen.observer;

import edu.neumont.csc415.Desktop;
import edu.neumont.csc415.Point;

/**
 * Created by jjensen on 11/5/14.
 */
public class Controller {
    public static void main(String[] args) {

        Desktop desktop = new Desktop(1000, 1000);
        AbstractKeyboard keyboard = KeyboardFactory.createKeyBoard(desktop);
        AWindow window = WindowFactory.createWindow(desktop, keyboard, new Point(200, 200), new Point(600, 700), DecoratorType.BORDER, DecoratorType.TITLE_BAR);

        desktop.registerPaintable(window);


    }
}
