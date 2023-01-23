package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EducatorGUI extends JFrame {
    private JPanel wrapper;
    private JButton btn_out;

    public EducatorGUI(){
        add(wrapper);
        setSize(700,600);
        setLocation(Helper.screenCenter("x" ,getSize()), Helper.screenCenter("y" , getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);



        btn_out.addActionListener(e -> {
            dispose();
            LoginGUI loginGUI = new LoginGUI();

        });
    }
}
