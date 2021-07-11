package patterns.mvc;

import patterns.mvc.controller.Controller;
import patterns.mvc.model.Model;
import patterns.mvc.view.UserView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model=new Model();
        UserView userView = new UserView();
        Controller controller = new Controller(model,userView);

        SwingUtilities.invokeLater(()->{
            userView.init();
        });
    }
}
