package edu.neumont.jjensen.observer;

import edu.neumont.csc415.Desktop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by jjensen on 11/18/14.
 */
public class KeyboardFactory {

    public static AbstractKeyboard createKeyBoard(Desktop desktop) {
        AbstractKeyboard keyboard = null;
        String type = readConfigFile();
        if(type.equals("real")) {
            keyboard = new Keyboard(desktop);
        } else if(type.equals("mock")) {
            keyboard = new MockKeyboard(desktop);
        }
    return keyboard;
    }


    private static String readConfigFile() {
        String line = null;
        try(BufferedReader reader = new BufferedReader(new FileReader("keyboard.conf"))) {
            line = reader.readLine();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }
}
