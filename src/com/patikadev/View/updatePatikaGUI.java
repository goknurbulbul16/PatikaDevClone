package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Patika;

import javax.swing.*;
public class updatePatikaGUI extends JFrame {
    private JPanel wrapper;
    private JTextField fld_patika_name;
    private JButton btn_update;
    private Patika patika;

    public updatePatikaGUI(Patika patika){
        this.patika = patika;

        add(wrapper);
        setSize(350,200);
        int x = Helper.screenCenter("x", getSize());
        int y = Helper.screenCenter("y", getSize());
        setLocation(x , y);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);

        setVisible(true);

        fld_patika_name.setText(patika.getName());
        btn_update.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_patika_name)){
                Helper.showMessage("fill");
            }else{
                if (Patika.update(patika.getId(), fld_patika_name.getText())){
                    Helper.showMessage("done");
                }
                dispose();
            }

        });
    }
}
