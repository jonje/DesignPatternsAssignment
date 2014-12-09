package edu.neumont.jjensen.observer;

import edu.neumont.csc415.Desktop;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

/**
 * Created by jjensen on 11/24/14.
 */
public class KeyboardController {
    private KeyBuffer keyBuffer;
    private Stack<ICommand> undo;
    private Stack<ICommand> redo;

    public KeyboardController(KeyBuffer keyBuffer) {
        this.keyBuffer = keyBuffer;

        this.undo = new Stack<>();
        this.redo = new Stack<>();

    }

    public void checkKey(char key) {
        ICommand command = null;
        switch ((int)key) {
            // Enter key
            case 10:
                command = new AddChar('#', keyBuffer);
                command.Do();
                undo.push(command);

                break;

            //Left Arrow
            case 17:
                command = new MoveLeft(keyBuffer);
                command.Do();
                undo.push(command);
                break;

            // Right Arrow
            case 19:
                command = new MoveRight(keyBuffer);
                command.Do();
                undo.push(command);
                break;

            // Backspace key
            case 8:
                command = new Backspace(keyBuffer);
                command.Do();
                undo.push(command);
                break;

            // F12 key for delete command
            case 123:
                command = new Delete(keyBuffer);
                command.Do();
                undo.push(command);
                break;

            // + key redo
            case 43:
                if(redo.size() > 0) {
                    command = redo.pop();
                    command.Do();
                    undo.push(command);

                }

                break;
            // - key undo
            case 45:
                if(undo.size() > 0) {
                    command = undo.pop();
                    command.Undo();
                    redo.push(command);
                }

                break;

            default:
                command = new AddChar(key, keyBuffer);
                command.Do();
                undo.push(command);

        }
    }

}
