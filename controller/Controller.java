package patterns.mvc.controller;

import patterns.mvc.model.Model;

import java.util.concurrent.atomic.AtomicBoolean;

public class Controller {
    private Model model;

    public Controller(Model model){
        this.model=model;
    }
    public boolean checkPin(int pin){
        AtomicBoolean checkPinResult = new AtomicBoolean(false);
        Thread thread = new Thread(()->{
            checkPinResult.set(model.getPin() == pin);
        });
        thread.start();

        return checkPinResult.get();
    }
}
