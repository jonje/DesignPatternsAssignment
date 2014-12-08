package edu.neumont.jjensen.observer;

import edu.neumont.csc415.DesktopGraphics;
import edu.neumont.csc415.IPaintable;

/**
 * Created by jjensen on 11/13/14.
 */
public interface WindowComponent extends IPaintable {
    public void paint(DesktopGraphics desktopGraphics);

}
