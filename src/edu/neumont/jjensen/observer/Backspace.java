package edu.neumont.jjensen.observer;

/**
 * Created by jjensen on 12/9/14.
 */
public class Backspace implements ICommand {
    private KeyBuffer keyBuffer;
    private char key;

    public Backspace(KeyBuffer keyBuffer) {
        this.keyBuffer = keyBuffer;
    }

    @Override
    public void Do() {
        key = keyBuffer.backspace();

    }

    @Override
    public void Undo() {
        keyBuffer.add(key);

    }
}
