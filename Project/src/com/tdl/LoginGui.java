package com.tdl;

import javax.swing.*;
//import javax.swing.border.LineBorder;
import java.awt.*;

/*
Gui Resolution    800x620.
 */

public class LoginGui {

    public void init_Login(){
        System.out.println("Login GUI.");
        JFrame jfrm_login=new JFrame("Login");
        jfrm_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm_login.setSize(800,620);

        JLabel container=new JLabel();
        container.setBounds(100,50,600,450);
        container.setBackground(Color.decode("#33334d"));


//        LineBorder border_login=new LineBorder(Color.blue,2,true);        //Set the border-radius
//        container.setBorder(border_login);


        JButton signin_btn,signup_btn;
        signin_btn=new JButton("Signin");
        signin_btn.setBackground(Color.decode("#9400D3"));
        signin_btn.setForeground(Color.WHITE);
        signin_btn.setBounds(270,120,100,40);
        jfrm_login.add(signin_btn);

        signup_btn=new JButton("Signup");
        signup_btn.setBounds(430,120,100,40);
        signup_btn.setBackground(Color.decode("#DA70D6"));
        signup_btn.setForeground(Color.WHITE);
        jfrm_login.add(signup_btn);


        JLabel username_disp;
        username_disp=new JLabel("Username");
        username_disp.setBounds(270,200,100,20);
        username_disp.setForeground(Color.WHITE);
        jfrm_login.add(username_disp);

        JTextField username_lbl;
        username_lbl=new JTextField();
        username_lbl.setBounds(270,220,260,40);
        jfrm_login.add(username_lbl);

        JLabel password_disp;
        password_disp=new JLabel("Password");
        password_disp.setBounds(270,280,100,20);
        password_disp.setForeground(Color.WHITE);
        jfrm_login.add(password_disp);

        JTextField password_lbl;
        password_lbl=new JTextField();
        password_lbl.setBounds(270,300,260,40);
        jfrm_login.add(password_lbl);

        JButton signin_submit_btn=new JButton("Login");
        signin_submit_btn.setBackground(Color.decode("#9400D3"));
        signin_submit_btn.setForeground(Color.WHITE);
        signin_submit_btn.setBounds(270,380,260,40);
        jfrm_login.add(signin_submit_btn);

        container.setOpaque(true);
        jfrm_login.add(container);

        jfrm_login.setLayout(null);
        jfrm_login.setVisible(true);
    }

    public void init_Signup(){
        System.out.print("Signup GUI");
        JFrame jfrm_sp=new JFrame("Signup");
        jfrm_sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm_sp.setSize(800,620);

        JLabel container=new JLabel();
        container.setBounds(100,50,600,450);
        container.setBackground(Color.decode("#33334d"));



        JButton signin_btn;
        signin_btn=new JButton("Signin");
        signin_btn.setBackground(Color.decode("#9400D3"));
        signin_btn.setForeground(Color.WHITE);
        signin_btn.setBounds(270,120,100,40);
        jfrm_sp.add(signin_btn);

        JButton signup_btn;
        signup_btn=new JButton("Signup");
        signup_btn.setBackground(Color.decode("#DA70D6"));
        signup_btn.setForeground(Color.WHITE);
        signup_btn.setBounds(430,120,100,40);
        jfrm_sp.add(signup_btn);

        JLabel f_name_disp,m_name_disp,l_name_disp;
        f_name_disp=new JLabel("First Name");
        f_name_disp.setBounds(200,180,100,20);
        f_name_disp.setForeground(Color.WHITE);
        jfrm_sp.add(f_name_disp);

        m_name_disp=new JLabel("Middle Name");
        m_name_disp.setBounds(340,180,100,20);
        m_name_disp.setForeground(Color.WHITE);
        jfrm_sp.add(m_name_disp);

        l_name_disp=new JLabel("Last Name");
        l_name_disp.setBounds(480,180,100,20);
        l_name_disp.setForeground(Color.WHITE);
        jfrm_sp.add(l_name_disp);

        JTextField f_name_tf,m_name_tf,l_name_tf;
        f_name_tf=new JTextField();
        f_name_tf.setBounds(200,200,100,30);
        jfrm_sp.add(f_name_tf);

        m_name_tf=new JTextField();
        m_name_tf.setBounds(340,200,100,30);
        jfrm_sp.add(m_name_tf);

        l_name_tf=new JTextField();
        l_name_tf.setBounds(480,200,100,30);
        jfrm_sp.add(l_name_tf);

        JLabel age_disp=new JLabel("Age");
        age_disp.setBounds(200,250,50,20);
        age_disp.setForeground(Color.WHITE);
        jfrm_sp.add(age_disp);

        JTextField age_tf=new JTextField();
        age_tf.setBounds(200,270,50,30);
        jfrm_sp.add(age_tf);


//        For the Gender .
//      ----------------

        JLabel phone_num_disp=new JLabel("Phone Number");
        phone_num_disp.setBounds(445,250,120,20);
        phone_num_disp.setForeground(Color.WHITE);
        jfrm_sp.add(phone_num_disp);

        JTextField phone_num_tf=new JTextField();
        phone_num_tf.setBounds(445,270,150,30);
        jfrm_sp.add(phone_num_tf);

        JLabel username_set_disp=new JLabel("Username");
        username_set_disp.setBounds(200,320,150,20);
        username_set_disp.setForeground(Color.WHITE);
        jfrm_sp.add(username_set_disp);

        JTextField username_set_tf=new JTextField();
        username_set_tf.setBounds(200,340,150,30);
        jfrm_sp.add(username_set_tf);

        JLabel password_set_disp=new JLabel("Password");
        password_set_disp.setBounds(435,320,150,20);
        password_set_disp.setForeground(Color.WHITE);
        jfrm_sp.add(password_set_disp);

        JTextField password_set_tf=new JTextField();
        password_set_tf.setBounds(435,340,150,30);
        jfrm_sp.add(password_set_tf);


/*
Submit Button
 */


        JButton signup_submit_btn=new JButton("Signup");
        signup_submit_btn.setBackground(Color.decode("#DA70D6"));
        signup_submit_btn.setForeground(Color.WHITE);
        signup_submit_btn.setBounds(270,410,260,40);
        jfrm_sp.add(signup_submit_btn);


        container.setOpaque(true);
        jfrm_sp.add(container);

        jfrm_sp.setLayout(null);
        jfrm_sp.setVisible(true);
    }
}