package edu.neumont.jjensen.observer;

/**
 * Created by jjensen on 12/9/14.
 */
public interface ICommand {

    public void Do();
    public void Undo();
}
