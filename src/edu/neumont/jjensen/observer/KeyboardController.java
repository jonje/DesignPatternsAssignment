package edu.neumont.jjensen.observer;

import edu.neumont.csc415.Desktop;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by jjensen on 11/24/14.
 */
public class KeyboardController {
    private KeyBuffer keyBuffer;

    public KeyboardController(KeyBuffer keyBuffer) {
        this.keyBuffer = keyBuffer;

    }

    public void checkKey(char key) {
        switch ((int)key) {
            case 10:
                keyBuffer.add('#');
                break;

            case 17:

                keyBuffer.moveLeft();
                break;

            case 19:

                keyBuffer.moveRight();
                break;

            case 8:
                keyBuffer.backspace();
                break;

            case 123:

                keyBuffer.delete();
                break;

            default:

                keyBuffer.add(key);

        }
    }

}
