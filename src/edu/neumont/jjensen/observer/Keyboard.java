package edu.neumont.jjensen.observer;

import edu.neumont.csc415.Desktop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjensen on 11/5/14.
 */
public class Keyboard extends AbstractKeyboard {

    public Keyboard (Desktop desktop){
        super(desktop);

        new Thread(new CheckerThread()).start();
    }


    private class CheckerThread implements Runnable {

        @Override
        public void run() {
            boolean running = true;

            while(running){
                if(desktop.hasKeysQueued()) {
                    int key = desktop.getKeyCode();
                    System.out.println(key);
                    notifyAllSubscribers((char) key);

                }

            }
        }
    }
}
