package patterns.mvc.controller;

import patterns.mvc.model.Model;

import java.util.concurrent.atomic.AtomicBoolean;


public class Controller {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public String checkPin(int pin) {
       // AtomicBoolean checkPinResult = new AtomicBoolean(false);
        var ref = new Object() {
            String resultMessage = null;
        };

        Thread thread = new Thread(() -> {
            boolean result= model.getPin() == pin;


            if(result){
                ref.resultMessage = "Right";
            }else {
                ref.resultMessage ="Wrong, try again";
            }




        });
        thread.start();
        return ref.resultMessage;
    }
}

