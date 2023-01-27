package com;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class gui_home {
    public static void main(String[] args) {
        home obj1 = new home();
    }
}

class home extends JFrame{
    public home(){
        JLabel header = new JLabel("To Do List");
        add(header);

        setTitle("To Do List");
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}