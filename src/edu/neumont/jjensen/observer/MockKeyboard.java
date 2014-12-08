package edu.neumont.jjensen.observer;

import edu.neumont.csc415.Desktop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by jjensen on 11/18/14.
 */
public class MockKeyboard extends AbstractKeyboard {
    public MockKeyboard(Desktop desktop) {
        super(desktop);
        new Thread(new CheckerThread()).start();
    }


    private class CheckerThread implements Runnable {

        @Override
        public void run() {
            boolean running = true;
            while(running) {
                try(BufferedReader reader = new BufferedReader(new FileReader("TestFile.txt"))) {
                    String line = null;

                    while((line = reader.readLine()) != null) {
                        for(int i = 0; i < line.length(); i++) {
                            notifyAllSubscribers(line.charAt(i));
                            Thread.sleep(1000);
                        }
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}
