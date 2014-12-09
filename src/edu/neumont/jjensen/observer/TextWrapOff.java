package edu.neumont.jjensen.observer;

import java.util.Iterator;

/**
 * Created by jjensen on 12/9/14.
 */
public class TextWrapOff implements ITextWrapper {
    @Override
    public Character[][] loadText(int initialx, int initialy, Iterator<Character> iterator, int xBound, int yBound, int xIncrease, int yIncrease) {
        Character[][] characters = new Character[yBound][xBound];
        int x = initialx;
        int y = initialy;
        boolean endNotFound = true;

        while(iterator.hasNext() && endNotFound) {
            Character character = iterator.next();

            if(x >= xBound) {
                x = initialx;
                y += yIncrease;

            } else if(y >= yBound) {
                endNotFound = false;
            }


            if(character.equals('#')) {
                x = initialx;
                y += yIncrease;

            } else {
                characters[y][x] = character;
                x += xIncrease;

            }

        }
        return characters;
    }
}
