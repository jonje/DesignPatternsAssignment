package edu.neumont.jjensen.observer;


import edu.neumont.csc415.*;
import edu.neumont.csc415.Desktop;
import edu.neumont.csc415.Point;

import java.util.*;


/**
 * Created by jjensen on 11/5/14.
 */
public class Window extends AWindow implements INotifiable {
    private Desktop desktop;
    private AbstractKeyboard keyboard;
    private char theChar;
    private KeyBuffer keyBuffer;
    private int initialx;
    private int initialy;
    private KeyboardController keyboardController;
    private Character[][] characters;

    private int yBound;
    private int xBound;

    private int yIncrease = 25;
    private int xIncrease = 11;

    private List<Character> listOfChars;

    public Window(Desktop desktop, AbstractKeyboard keyboard, Point point1, Point point2) {
        super(desktop, point1, point2);
        listOfChars = new ArrayList<Character>();

        this.desktop = desktop;
        this.keyboard = keyboard;
        this.keyboard.register(this);

        this.point1 = point1;
        this.point2 = point2;

        this.xBound = point2.getX() -5;
        this.yBound = point2.getY() -5;

        this.characters = new Character[yBound][xBound];
        this.keyBuffer = new KeyBuffer();

        this.keyboardController = new KeyboardController(keyBuffer);
        initialx = point1.getX();
        initialy = point1.getY();

        initialx += xIncrease;
        initialy += yIncrease;

    }


    @Override
    public void paint(DesktopGraphics desktopGraphics) {
        desktopGraphics.fillRectangle(point1, point2, DesktopColor.DARK_GRAY);
        setupArray();

        for(int y = initialy; y < yBound; y += yIncrease) {
            for(int x = initialx; x < xBound; x += xIncrease) {

                if(characters[y][x] != null) {
                    desktopGraphics.drawChar(characters[y][x], new Point(x, y), DesktopColor.BLACK );

                }
            }
        }

    }

    private void setupArray() {
        characters = new Character[yBound][xBound];
        Iterator<Character> leftIterator = keyBuffer.iterator();


        int x = initialx;
        int y = initialy;
        boolean endNotFound = true;

        while(leftIterator.hasNext() && endNotFound) {
            Character character = leftIterator.next();

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

//        for( int y = initialy; y < yBound; y += yIncrease) {
//            for( int x = initialx; x < xBound; x += xIncrease) {
//                char character ='\0';
//
//                if(leftIterator.hasNext()) {
//                    character = leftIterator.next();
//
//
//                } else if(rightIterator.hasNext()) {
//                    character = rightIterator.next();
//                }
//
//                if(character == '#') {
//
//                    x = xBound;
//
//                } else {
//                    characters[y][x] = character;
//                }
//            }
//        }


    }

    @Override
    public void update(char theChar) {
        this.theChar = theChar;
        keyboardController.checkKey(theChar);

        desktop.repaint();

    }
}
