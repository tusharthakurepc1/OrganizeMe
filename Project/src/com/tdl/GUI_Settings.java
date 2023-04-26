package com.tdl;

import javax.swing.*;
import java.awt.*;

public class GUI_Settings {

    public void displayData(Client data_cl){
        JFrame jfrm_display_details=new JFrame("Settings");
        jfrm_display_details.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm_display_details.setSize(800,620);


        JLabel greet_lbl,client_id_lbl,name_lbl,age_lbl,gender_lbl,phone_num_lbl,username_lbl;

        greet_lbl =new JLabel("Account Details");
        greet_lbl.setBounds(300,70,500,30);
        greet_lbl.setFont(new Font("Vardana",Font.PLAIN,30));
        jfrm_display_details.add(greet_lbl);


        client_id_lbl =new JLabel("Id:                     "+data_cl.client_id);
        client_id_lbl.setBounds(200,150,500,30);
        client_id_lbl.setFont(new Font("Vardana",Font.PLAIN,20));
        jfrm_display_details.add(client_id_lbl);

        name_lbl =new JLabel("Name:                "+data_cl.f_name+" "+data_cl.m_name+" "+data_cl.l_name);
        name_lbl.setBounds(200,200,500,30);
        name_lbl.setFont(new Font("Vardana",Font.PLAIN,20));
        jfrm_display_details.add(name_lbl);

        age_lbl =new JLabel("Age:                   "+data_cl.age);
        age_lbl.setBounds(200,250,500,30);
        age_lbl.setFont(new Font("Vardana",Font.PLAIN,20));
        jfrm_display_details.add(age_lbl);

        gender_lbl =new JLabel("Gender:              "+data_cl.gender);
        gender_lbl.setBounds(200,300,500,30);
        gender_lbl.setFont(new Font("Vardana",Font.PLAIN,20));
        jfrm_display_details.add(gender_lbl);

        phone_num_lbl =new JLabel("Contact No:        "+data_cl.phone_num);
        phone_num_lbl.setBounds(200,350,500,30);
        phone_num_lbl.setFont(new Font("Vardana",Font.PLAIN,20));
        jfrm_display_details.add(phone_num_lbl);

        username_lbl =new JLabel("UserName:          "+data_cl.username);
        username_lbl.setBounds(200,400,500,30);
        username_lbl.setFont(new Font("Vardana",Font.PLAIN,20));
        jfrm_display_details.add(username_lbl);


        JButton back_btn=new JButton("OK");
        back_btn.setBounds(350,450,70,50);
        back_btn.setFont(new Font("Vardana",Font.PLAIN,15));
        jfrm_display_details.add(back_btn);
        back_btn.addActionListener(
                e -> {
                    GUI_T settings=new GUI_T();
                    settings.guiSettingFrame(data_cl.client_id,data_cl.pass);
                    jfrm_display_details.dispose();
                }
        );


        jfrm_display_details.setLayout(null);
        jfrm_display_details.setVisible(true);
    }

    public void updateDetails(Client data_cl){
        JFrame jfrm_update_details=new JFrame("Settings");
        jfrm_update_details.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm_update_details.setSize(800,620);

        JLabel greet_lbl,client_id_lbl,name_lbl,age_lbl,gender_lbl,phone_num_lbl,username_lbl;
        JTextField f_name_tf,m_name_tf,l_name_tf,age_tf,gender_tf,phone_num_tf,username_tf;

        JButton back_btn=new JButton("Back");
        back_btn.setBounds(0,0,70,50);
        back_btn.setFont(new Font("Vardana",Font.PLAIN,15));
        jfrm_update_details.add(back_btn);
        back_btn.addActionListener(
                e -> {
                    GUI_T settings=new GUI_T();
                    settings.guiSettingFrame(data_cl.client_id,data_cl.pass);
                    jfrm_update_details.dispose();
                }
        );

        greet_lbl =new JLabel("Update Details");
        greet_lbl.setBounds(300,70,500,30);
        greet_lbl.setFont(new Font("Vardana",Font.PLAIN,30));
        jfrm_update_details.add(greet_lbl);

        name_lbl =new JLabel("Name");
        name_lbl.setBounds(200,200,500,30);
        name_lbl.setFont(new Font("Vardana",Font.PLAIN,20));
        jfrm_update_details.add(name_lbl);

        f_name_tf =new JTextField();
        f_name_tf.setBounds(350,200,100,30);
        jfrm_update_details.add(f_name_tf);

        m_name_tf =new JTextField();
        m_name_tf.setBounds(470,200,100,30);
        jfrm_update_details.add(m_name_tf);

        l_name_tf =new JTextField();
        l_name_tf.setBounds(590,200,100,30);
        jfrm_update_details.add(l_name_tf);

        age_lbl =new JLabel("Age");
        age_lbl.setBounds(200,250,500,30);
        age_lbl.setFont(new Font("Vardana",Font.PLAIN,20));
        jfrm_update_details.add(age_lbl);

        age_tf =new JTextField();
        age_tf.setBounds(350,250,100,30);
        jfrm_update_details.add(age_tf);

        gender_lbl =new JLabel("Gender");
        gender_lbl.setBounds(200,300,500,30);
        gender_lbl.setFont(new Font("Vardana",Font.PLAIN,20));
        jfrm_update_details.add(gender_lbl);

        gender_tf =new JTextField();
        gender_tf.setBounds(350,300,100,30);
        jfrm_update_details.add(gender_tf);

        phone_num_lbl =new JLabel("Contact No");
        phone_num_lbl.setBounds(200,350,500,30);
        phone_num_lbl.setFont(new Font("Vardana",Font.PLAIN,20));
        jfrm_update_details.add(phone_num_lbl);

        phone_num_tf =new JTextField();
        phone_num_tf.setBounds(350,350,100,30);
        jfrm_update_details.add(phone_num_tf);

        username_lbl =new JLabel("UserName");
        username_lbl.setBounds(200,400,500,30);
        username_lbl.setFont(new Font("Vardana",Font.PLAIN,20));
        jfrm_update_details.add(username_lbl);

        username_tf =new JTextField();
        username_tf.setBounds(350,400,100,30);
        jfrm_update_details.add(username_tf);


        JButton submit=new JButton("Update");
        submit.setBounds(320,470,150,40);
        jfrm_update_details.add(submit);

//        JTextField f_name_tf,m_name_tf,l_name_tf,age_tf,gender_tf,phone_num_tf,username_tf;

        submit.addActionListener(
                e -> {
                    Client update_buffer=new Client();

                    if(f_name_tf.getText().equals(""))
                        update_buffer.f_name=data_cl.f_name;
                    else   update_buffer.f_name=f_name_tf.getText();

                    if(m_name_tf.getText().equals(""))
                        update_buffer.m_name=data_cl.m_name;
                    else    update_buffer.m_name=m_name_tf.getText();

                    if(l_name_tf.getText().equals(""))
                        update_buffer.l_name=data_cl.l_name;
                    else    update_buffer.l_name=l_name_tf.getText();

                    if(age_tf.getText().equals(""))
                        update_buffer.age=data_cl.age;
                    else{
                        int temp_age=0;
                        try{
                            temp_age=Integer.parseInt(age_tf.getText());
                        }catch (NumberFormatException nfe){
                            System.out.println("Invalid Input Format");
                        }
                        update_buffer.age=temp_age;
                    }

                    if(gender_tf.getText().equals(""))
                        update_buffer.gender=data_cl.gender;
                    else    update_buffer.gender=gender_tf.getText();

                    if(phone_num_tf.getText().equals(""))
                        update_buffer.phone_num=data_cl.phone_num;
                    else    update_buffer.phone_num=phone_num_tf.getText();

                    if(username_tf.getText().equals(""))
                        update_buffer.username=data_cl.username;
                    else    update_buffer.username=username_tf.getText();

                    DataBaseOperation.updateClientDetails(data_cl.client_id,data_cl.pass,update_buffer);


                    GUI_T nofity_update=new GUI_T();
                    nofity_update.notifyAlert("Update Sucessfully","");

                    GUI_T settings=new GUI_T();
                    settings.guiSettingFrame(data_cl.client_id,data_cl.pass);
                    jfrm_update_details.dispose();
                }
        );





        jfrm_update_details.setLayout(null);
        jfrm_update_details.setVisible(true);
    }

    public void updatePassword(Client data_cl){
        JFrame jfrm_update_password=new JFrame("Settings");
        jfrm_update_password.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm_update_password.setSize(800,620);

        JButton back_btn=new JButton("Back");
        back_btn.setBounds(0,0,70,50);
        back_btn.setFont(new Font("Vardana",Font.PLAIN,15));
        jfrm_update_password.add(back_btn);
        back_btn.addActionListener(
                e -> {
                    GUI_T settings=new GUI_T();
                    settings.guiSettingFrame(data_cl.client_id,data_cl.pass);
                    jfrm_update_password.dispose();
                }
        );


        JLabel password_lbl1,password_lbl2,password_lbl3,alert;
        JTextField password_tf1,password_tf2,password_tf3;

        password_lbl3=new JLabel("Old Password");
        password_lbl3.setFont(new Font("Vardana",Font.PLAIN,15));
        password_lbl3.setBounds(200,150,200,40);
        jfrm_update_password.add(password_lbl3);

        password_tf3=new JTextField();
        password_tf3.setBounds(400,150,200,40);
        jfrm_update_password.add(password_tf3);


        password_lbl1=new JLabel(" Enter Password");
        password_lbl1.setFont(new Font("Vardana",Font.PLAIN,15));
        password_lbl1.setBounds(200,200,200,40);
        jfrm_update_password.add(password_lbl1);

        password_tf1=new JTextField();
        password_tf1.setBounds(400,200,200,40);
        jfrm_update_password.add(password_tf1);

        password_lbl2=new JLabel("Confirm Password");
        password_lbl2.setFont(new Font("Vardana",Font.PLAIN,15));
        password_lbl2.setBounds(200,250,200,40);
        jfrm_update_password.add(password_lbl2);

        password_tf2=new JTextField();
        password_tf2.setBounds(400,250,200,40);
        jfrm_update_password.add(password_tf2);

        alert=new JLabel();
        alert.setForeground(Color.decode("#33334d"));
        alert.setBounds(300,450,300,40);
        jfrm_update_password.add(alert);
        alert.setVisible(false);

        JButton submit=new JButton("Update");
        submit.setBounds(400,320,100,40);
        jfrm_update_password.add(submit);


        submit.addActionListener(
                e->{
                    if(password_tf3.getText().equals(data_cl.pass) && password_tf1.getText().equals(password_tf2.getText())){
                        alert.setVisible(false);
                        DataBaseOperation.updateClientPassword(data_cl.client_id,data_cl.pass,password_tf2.getText());

                        GUI_T notify_password_updated=new GUI_T();
                        notify_password_updated.notifyAlert("Password Updated","");

                        LoginGui login =new LoginGui();
                        login.init_Login();
                        jfrm_update_password.dispose();

                    }
                    else{
                        alert.setVisible(true);
                        alert.setText("Password Credential Incorrect");
                    }
                }
        );


        jfrm_update_password.setLayout(null);
        jfrm_update_password.setVisible(true);
    }


}