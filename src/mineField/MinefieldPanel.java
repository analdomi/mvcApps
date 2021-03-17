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

        // add buttons to control panel
        String[] buttons = {"NW", "N", "NE", "W", "E", "SW", "S", "SE"};
        for(String buttonName : buttons) {
            JButton btn = new JButton(buttonName);
            btn.addActionListener(this);
            JPanel btnPanel = new JPanel();
            btnPanel.setLayout(new FlowLayout());
            btnPanel.add(btn);
            controlPanel.add(btnPanel);
        }
    }

    public static void main(String[] args) {
        AppFactory factory = new StoplightFactory();
        AppPanel panel = new stopLight.StoplightPanel(factory);
        panel.display();
    }

}
