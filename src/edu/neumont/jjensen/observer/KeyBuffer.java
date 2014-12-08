package edu.neumont.jjensen.observer;

import java.util.*;

/**
 * Created by jjensen on 11/20/14.
 */
public class KeyBuffer {
    private Stack<Character> right;
    private Stack<Character> left;

    public KeyBuffer() {
        this.right = new Stack<>();
        this.left = new Stack<>();

        left.add('|');

    }

    public void add(char character) {
        Character temp = left.pop();
        //left.remove(temp);
        left.push(character);
        left.push(temp);
    }

    public Iterator<Character> getLeft() {
        return left.iterator();
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

    public void backspace() {
        if(left.size() > 1) {
            Character cursor = left.pop();
            left.pop();
            left.push(cursor);

        }
    }

    public void delete() {
        if(right.size() > 0) {
            right.pop();

        }
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