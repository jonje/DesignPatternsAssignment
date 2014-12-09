package edu.neumont.jjensen.observer;

/**
 * Created by jjensen on 12/9/14.
 */
public class MoveRight implements ICommand {
    private KeyBuffer keyBuffer;

    public MoveRight(KeyBuffer keyBuffer) {
        this.keyBuffer = keyBuffer;
    }

    @Override
    public void Do() {
        keyBuffer.moveRight();


    }

    @Override
    public void Undo() {
        keyBuffer.moveLeft();
    }
}
