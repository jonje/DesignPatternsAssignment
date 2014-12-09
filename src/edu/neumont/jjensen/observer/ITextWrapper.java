package edu.neumont.jjensen.observer;

import java.util.Iterator;

/**
 * Created by jjensen on 12/9/14.
 */
public interface ITextWrapper {

    public Character[][] loadText(int initialx, int initialy, Iterator<Character> iterator, int xBound, int yBound, int xIncrease, int yIncrease);
}
