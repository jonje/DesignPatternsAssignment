package edu.neumont.jjensen.observer;

import edu.neumont.csc415.Desktop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjensen on 11/18/14.
 */
public abstract class AbstractKeyboard {
    private List<INotifiable> subscribers;
    protected Desktop desktop;

    public AbstractKeyboard (Desktop desktop){
        subscribers = new ArrayList<INotifiable>();
        this.desktop = desktop;

    }

    public void register(INotifiable subscriber) {
        subscribers.add(subscriber);
    }

    public void unRegister(INotifiable subscriber) {
        subscribers.remove(subscriber);

    }

    public void notifyAllSubscribers(char theChar){
        for(INotifiable subscriber : subscribers) {
            subscriber.update(theChar);
        }
    }

    private class CheckerThread implements Runnable {


        @Override
        public void run() {

        }
    }
}
