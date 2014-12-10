package edu.neumont.jjensen.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

        ArrayList<Character> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        Iterator<Character> newIterator = list.iterator();

        int lines = getLines(list.iterator(), xBound - initialx);

        int heightWindow = yBound - initialy;

        int charHeight = 25;

        int maxLines = heightWindow / charHeight;
        maxLines +=3;

        int offset = lines - maxLines;
        System.out.println(offset);

        if(offset >= 0) {
            int offsetCharCount = getCharCount(offset, list.iterator(), xBound - initialx);

            System.out.println(offsetCharCount);
            for(int i = 0; i < offsetCharCount; i++) {
                newIterator.next();

            }
        }

        boolean a = newIterator.hasNext();

        while(newIterator.hasNext() && endNotFound) {
            Character character = newIterator.next();

            if(x >= xBound) {
                x = initialx;
                y += yIncrease;

            } else if(y >= yBound) {
                endNotFound = false;

            } else {
                if(character.equals('#')) {
                    x = initialx;
                    if(y < yBound) {
                        y += yIncrease;

                    }

                } else {
                    characters[y][x] = character;
                    x += xIncrease;

                }
            }




        }
        return characters;
    }


    public int getLines(Iterator<Character> iterator, int xBound) {

        int x = 0;
        int y = 0;
        int yIncrease = 1;
        int xIncrease = 11;
        int charCount = 0;

        while(iterator.hasNext()) {
            Character character = iterator.next();

            if(character.equals('#') || x > xBound) {
                x = 0;
                y += yIncrease;

            } else {

                x += xIncrease;
                charCount++;

            }

        }
        return y;
    }

    public int getCharCount(int lines, Iterator<Character> iterator, int xBound) {

        int x = 0;
        int y = 0;
        int yIncrease = 1;
        int xIncrease = 11;
        int charCount = 0;

        while(iterator.hasNext() && lines != y) {
            Character character = iterator.next();

            if(x > xBound) {
                x = 0;
                y += yIncrease;

            }


            if(character.equals('#')) {
                x = 0;
                y += yIncrease;

            } else {

                x += xIncrease;
                charCount++;

            }

        }
        return charCount;
    }
}
