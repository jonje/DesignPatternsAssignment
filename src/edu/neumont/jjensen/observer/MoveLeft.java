package edu.neumont.jjensen.observer;

/**
 * Created by jjensen on 12/9/14.
 */
public class MoveLeft implements ICommand {
    private KeyBuffer keyBuffer;

    public MoveLeft(KeyBuffer keyBuffer) {
        this.keyBuffer = keyBuffer;
    }

    @Override
    public void Do() {
        keyBuffer.moveLeft();

    }

    @Override
    public void Undo() {
        keyBuffer.moveRight();

    }
}
