package patterns.mvc.controller;

import patterns.mvc.model.Model;
import patterns.mvc.view.UserView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Controller {
    private Model model;
    private UserView view;

    public Controller(Model model, UserView view) {
        this.model = model;
        this.view = view;
        this.view.addListener(new Listener());
    }


    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                int pin;
                String textPin=view.returnText().getText();
                pin=Integer.parseInt(textPin);
                view.getInfo().setText("Got it: "+pin+" Waiting..");

                var ref = new Object() {
                    String resultMessage;
                };

                Thread thread = new Thread(()->{
                    boolean result= model.getPin() == pin;
                    if(result){
                       ref.resultMessage = "Right";
                    }else {
                        ref.resultMessage ="Wrong, try again";
                    }
                    view.getInfo().setText(ref.resultMessage);
                });
                thread.start();

            } catch (NumberFormatException ex) {
                System.out.println(ex);
            }
        }
    }
}

