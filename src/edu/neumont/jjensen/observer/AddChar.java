package edu.neumont.jjensen.observer;

/**
 * Created by jjensen on 12/9/14.
 */
public class AddChar implements ICommand {
    private char character;
    private KeyBuffer keyBuffer;

    public AddChar(char character, KeyBuffer keyBuffer) {
        this.character = character;
        this.keyBuffer = keyBuffer;
    }

    @Override
    public void Do() {
        keyBuffer.add(character);
    }

    @Override
    public void Undo() {
        keyBuffer.backspace();

    }
}
