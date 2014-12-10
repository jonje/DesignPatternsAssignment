package edu.neumont.jjensen.observer;

import java.util.Iterator;

/**
 * Created by jjensen on 12/9/14.
 */
public class TextWrapOn implements ITextWrapper {




    @Override
    public Character[][] loadText(int initialx, int initialy, Iterator<Character> iterator, int xBound, int yBound, int xIncrease, int yIncrease) {
        Character[][] characters = new Character[yBound][xBound];
        int x = initialx;
        int y = initialy;
        boolean endNotFound = true;
        String word = "";

        while(iterator.hasNext() && endNotFound) {
            Character character = iterator.next();

            if(x > xBound) {
                int tempX = x;
                int tempY = y;
                x = initialx;
                y += yIncrease;

                if(word.length() > 0) {

                    for(int i = 0; i < word.length(); i++) {
                        tempX -= xIncrease;
                        characters[tempY][tempX] = null;

                    }

                    for(int i = 0; i < word.length(); i++) {
                        char thisCharacter = word.charAt(i);
                        characters[y][x] = thisCharacter;
                        x += xIncrease;
                    }

                }

                if(character.equals('#')) {
                    x = initialx;
                    y += yIncrease;

                } else if(character.equals(' ')){
                    word = "";
                    characters[y][x] = character;
                    x += xIncrease;
                } else {
                    characters[y][x] = character;

                    x += xIncrease;
                    word += character;

                }

            } else if(y > yBound) {
                endNotFound = false;

            } else {
                if(character.equals('#')) {
                    x = initialx;
                    y += yIncrease;

                } else if(character.equals(' ')){
                    word = "";
                    characters[y][x] = character;
                    x += xIncrease;

                } else {
                    characters[y][x] = character;

                    x += xIncrease;
                    word += character;

                }
            }

        }
        return characters;
    }
}
