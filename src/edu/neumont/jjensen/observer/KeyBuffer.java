package edu.neumont.jjensen.observer;

import java.util.*;

/**
 * Created by jjensen on 11/20/14.
 */
public class KeyBuffer {
    private Stack<Character> right;
    private Stack<Character> left;

    private int windowHeight;

    public KeyBuffer( int windowSize) {
        this.right = new Stack<>();
        this.left = new Stack<>();
        this.windowHeight = windowSize;
        left.add('|');

    }

    public void add(char character) {
        Character temp = left.pop();
        //left.remove(temp);
        left.push(character);
        left.push(temp);
    }

    public Iterator<Character> getLeft() {
        Stack<Character> tempStack = new Stack<>();
        int stackSize = left.size();
        if(stackSize > windowHeight) {
            int difference = stackSize - windowHeight;
            for (int i = difference; i <= stackSize; i++) {
                tempStack.push(left.get(i));
            }
        } else {
            tempStack = left;
        }

        return tempStack.iterator();
    }

    public Iterator<Character> getRight() {

        Stack<Character> tempStack = new Stack<>();

        for(int i = right.size() -1; i >= 0; i-- ) {
            tempStack.push(right.get(i));
        }

        return tempStack.iterator();
    }

    public Iterator<Character> iterator() {
        return new StackIterator(getLeft(), getRight());
    }

    public void moveRight() {

        if(right.size() > 0) {
            Character cursor = left.pop();
            Character temp = right.pop();

            left.push(temp);
            left.push(cursor);

        }

    }

    public void moveLeft() {

        if(left.size() > 1) {
            Character cursor = left.pop();
            Character temp = left.pop();

            right.push(temp);
            left.push(cursor);
        } else {
            System.out.println("Reached end of document!");
        }

    }

    public char backspace() {
        char temp = '\0';
        if(left.size() > 1) {

            Character cursor = left.pop();
            temp = left.pop();
            left.push(cursor);

        }

        return temp;
    }

    public char delete() {
        char temp = '\0';
        if(right.size() > 0) {
            temp = right.pop();

        }

        return temp;
    }

    public int getLeftSize() {
        return left.size();
    }

    public class StackIterator implements Iterator<Character> {
        private Iterator<Character> left;
        private Iterator<Character> right;



        public StackIterator(Iterator<Character> left, Iterator<Character> right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean hasNext() {
            return left.hasNext() || right.hasNext();
        }

        @Override
        public Character next() {
            return left.hasNext() ? left.next() : right.next();
        }

        @Override
        public void remove() {

        }
    }

}