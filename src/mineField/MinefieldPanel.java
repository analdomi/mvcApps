package mineField;

import mvc.AppFactory;
import mvc.AppPanel;
import mvc.Model;
import stopLight.StoplightFactory;

import javax.swing.*;
import java.awt.*;


public class MinefieldPanel extends AppPanel {
    private JButton change;
    public MinefieldPanel(AppFactory factory) {
        super(factory);

        //this.setLayout(new BorderLayout());
        change = new JButton("Change");
        change.addActionListener(this);
        //JPanel buttonPanel = new JPanel();
        //buttonPanel.setLayout(new FlowLayout());
        controlPanel.add(change);
        //add(buttonPanel);
        //add(view);
    }

    public static void main(String[] args) {
        AppFactory factory = new MinefieldFactory();
        AppPanel panel = new MinefieldPanel(factory);
        panel.display();
    }

}
