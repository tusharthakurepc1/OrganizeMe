package com.tdl;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Groceries_Gui {

    public void groceriesGUI(int id,String pass){
        JFrame jfrm_groceries=new JFrame("Groceries");
        jfrm_groceries.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm_groceries.setSize(800,620);
        jfrm_groceries.setResizable(false);


        JLabel container_left=new JLabel();
        container_left.setBounds(10,10,300,560);
        container_left.setBackground(Color.decode("#33334d"));

        JLabel icon=new JLabel("M");
        icon.setBounds(20,25,50,50);
        icon.setForeground(Color.white);
        icon.setOpaque(true);
        icon.setBackground(Color.black);
        icon.setFont(new Font("Verdana", Font.BOLD, 37));
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        Border b = BorderFactory.createLineBorder(Color.darkGray);
        icon.setBorder(b);
        jfrm_groceries.add(icon);


        JLabel name=new JLabel("Manasvi Kumar Thakur");
        name.setBounds(20,7,280,80);
        name.setForeground(Color.white);
        name.setFont(new Font("Verdana", Font.BOLD, 17));
        name.setHorizontalAlignment(SwingConstants.RIGHT);
        jfrm_groceries.add(name);

        JLabel email=new JLabel("manasvikumar108@gmail.com");
        email.setBounds(20,25,250,80);
        email.setForeground(Color.GRAY);
        email.setFont(new Font("Rockwell", Font.PLAIN, 12));
        email.setHorizontalAlignment(SwingConstants.RIGHT);
        jfrm_groceries.add(email);

        JButton home;
        home=new JButton("Home");
        home.setBackground(Color.decode("#E6E6FA"));
        home.setForeground(Color.BLACK);
        home.setBounds(20,100,280,40);
        home.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_groceries.add(home);
        home.addActionListener(
                e->{
                    Home_Gui o1=new Home_Gui();
                    o1.homeGUI(id,pass);
                    jfrm_groceries.dispose();
                }
        );

//        JButton tasks;
//        tasks=new JButton("Tasks");
//        tasks.setBackground(Color.decode("#E6E6FA"));
//        tasks.setForeground(Color.BLACK);
//        tasks.setBounds(20,150,280,40);
//        tasks.setHorizontalAlignment(SwingConstants.LEFT);
//        jfrm_home.add(tasks);

        JButton important;
        important=new JButton("Important");
        important.setBackground(Color.decode("#E6E6FA"));
        important.setForeground(Color.BLACK);
        important.setBounds(20,150,280,40);
        important.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_groceries.add(important);
        important.addActionListener(
                e->{
                    Important_Gui o1=new Important_Gui();
                    o1.importantGUI(id,pass);
                    jfrm_groceries.dispose();
                }
        );

        JButton planned;
        planned=new JButton("Planned");
        planned.setBackground(Color.decode("#E6E6FA"));
        planned.setForeground(Color.BLACK);
        planned.setBounds(20,200,280,40);
        planned.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_groceries.add(planned);
        planned.addActionListener(
                e->{
                    Planned_Gui o1=new Planned_Gui();
                    o1.plannedGUI(id,pass);
                    jfrm_groceries.dispose();
                }
        );

        JButton groceries;
        groceries=new JButton("Groceries");
        groceries.setBackground(Color.decode("#E6E6FA"));
        groceries.setForeground(Color.BLACK);
        groceries.setBounds(20,250,280,40);
        groceries.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_groceries.add(groceries);

        JButton settings;
        settings=new JButton("Settings");
        settings.setBackground(Color.decode("#E6E6FA"));
        settings.setForeground(Color.BLACK);
        settings.setBounds(20,300,280,40);
        settings.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_groceries.add(settings);
        settings.addActionListener(
                e->{
                    GUI_T o1=new GUI_T();
                    o1.guiSettingFrame(id, pass);
                    jfrm_groceries.dispose();
                }
        );


        container_left.setOpaque(true);
        jfrm_groceries.add(container_left);

        JLabel container_right=new JLabel();
        container_right.setBounds(320,10,450,560);
        container_right.setBackground(Color.decode("#33334d"));

        JLabel imp_label=new JLabel("Groceries");
        imp_label.setBounds(340,7,280,80);
        imp_label.setForeground(Color.white);
        imp_label.setBackground(Color.white);
        imp_label.setFont(new Font("Verdana", Font.PLAIN, 37));
        imp_label.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_groceries.add(imp_label);


        JTextField add_text_field=new JTextField();
        JButton add_btn=new JButton("ADD");
        add_text_field.add(add_btn);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBounds(340,500,410,60);
        panel.setBackground(Color.white);
        panel.add(add_text_field, BorderLayout.CENTER);
        panel.add(add_btn,BorderLayout.EAST);
        add_btn.setBackground(Color.black);
        add_btn.setForeground(Color.WHITE);
        add_btn.setSize(10,10);
        jfrm_groceries.add(panel);


        container_right.setOpaque(true);
        jfrm_groceries.add(container_right);


        jfrm_groceries.setLayout(null);
        jfrm_groceries.setVisible(true);

    }
}

