
package patterns.mvc.view;

import patterns.mvc.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserView extends JFrame {
    private JTextArea text;
    private JButton sendButton = new JButton("Send");
    private JLabel info;

    public JButton getSendButton() {
        return sendButton;
    }

    public JTextArea returnText() {
        return text;
    }

    public JLabel getInfo() {
        return info;
    }

    public void init() {
        setSize(400, 300);
        text = new JTextArea();
        info = new JLabel("Info");
        add(text, BorderLayout.CENTER);
        add(sendButton, BorderLayout.SOUTH);
        add(info, BorderLayout.NORTH);

        setVisible(true);
    }

    public void addListener(ActionListener listenForCalcButton) {
        sendButton.addActionListener(listenForCalcButton);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}