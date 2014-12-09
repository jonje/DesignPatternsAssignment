package edu.neumont.jjensen.observer;

/**
 * Created by jjensen on 12/9/14.
 */
public class Delete implements ICommand {
    private KeyBuffer keyBuffer;
    private char character;

    public Delete(KeyBuffer keyBuffer) {
        this.keyBuffer = keyBuffer;
    }

    @Override
    public void Do() {
        character = keyBuffer.delete();

    }

    @Override
    public void Undo() {
        keyBuffer.add(character);

    }
}
