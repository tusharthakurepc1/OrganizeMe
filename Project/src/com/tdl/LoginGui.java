package com.tdl;


import javax.swing.*;
import java.awt.*;
import java.io.*;

/*
Gui Resolution    800x620.
 */

public class LoginGui {
    static boolean login_status=false;

    public void init_Login(){
        JLabel id_disp, password_disp, alert_tf;
        JTextField id_lbl, password_lbl;
        JButton signin_btn, signup_btn, signin_submit_btn;


        JFrame jfrm_login=new JFrame("Login");
        jfrm_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm_login.setResizable(false);
        jfrm_login.setSize(800,620);

        JLabel container=new JLabel();
        container.setBounds(100,50,600,450);
        container.setBackground(Color.decode("#33334d"));


//        LineBorder border_login=new LineBorder(Color.blue,2,true);        //Set the border-radius
//        container.setBorder(border_login);


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

        signup_btn.addActionListener(
                e->{
                    LoginGui o1=new LoginGui();
                    o1.init_Signup();
                    jfrm_login.dispose();
                }
        );


        id_disp=new JLabel("ID Number");
        id_disp.setBounds(270,200,100,20);
        id_disp.setForeground(Color.WHITE);
        jfrm_login.add(id_disp);


        id_lbl=new JTextField();
        id_lbl.setBounds(270,220,260,40);
        jfrm_login.add(id_lbl);


        password_disp=new JLabel("Password");
        password_disp.setBounds(270,280,100,20);
        password_disp.setForeground(Color.WHITE);
        jfrm_login.add(password_disp);


        password_lbl=new JTextField();
        password_lbl.setBounds(270,300,260,40);
        jfrm_login.add(password_lbl);

        signin_submit_btn=new JButton("Login");
        signin_submit_btn.setBackground(Color.decode("#9400D3"));
        signin_submit_btn.setForeground(Color.WHITE);
        signin_submit_btn.setBounds(270,380,260,40);
        jfrm_login.add(signin_submit_btn);

        alert_tf=new JLabel();
        alert_tf.setBackground(Color.decode("#33334d"));
        alert_tf.setForeground(Color.decode("#ff4d4d"));
        alert_tf.setVisible(false);
        alert_tf.setHorizontalAlignment(JLabel.CENTER);
        alert_tf.setBounds(270,440,260,25);
        jfrm_login.add(alert_tf);

        signin_submit_btn.addActionListener(
                e->{
                    if(id_lbl.getText().equals("")){
                        alert_tf.setText("!!User Name!!");
                        alert_tf.setVisible(true);
                        return;
                    }
                    else if(password_lbl.getText().equals("")){
                        alert_tf.setText("!!Password!!");
                        alert_tf.setVisible(true);
                        return;
                    }
                    else{
                        int temp_id=0;
                        try {
                            temp_id = Integer.parseInt(id_lbl.getText());
                        }catch(NumberFormatException nfe){
                            alert_tf.setText("!! Enter the ID Correct !!");
                            alert_tf.setVisible(true);
                            return;
                        }

                        if(DataBaseOperation.readUserPass(temp_id,password_lbl.getText())){
                            alert_tf.setVisible(false);
//                            Make notification to greet successful login.
                            GUI_T o1=new GUI_T();
                            o1.notifyAlert("Login Sucessfully","");
                            LoginGui.login_status=true;
                            Home_Gui home=new Home_Gui();
                            int id=Integer.parseInt(id_lbl.getText());
                            home.homeGUI(id,password_lbl.getText());
                            jfrm_login.dispose();
                        }
                        else{
//                            System.out.println("Invalid Username or pass");
                            alert_tf.setText("!! Invalid ID or Password !!");
                            alert_tf.setVisible(true);
                        }
                    }
//                  System.out.println(id_lbl.getText()+" "+password_lbl.getText());

                }
        );



        container.setOpaque(true);
        jfrm_login.add(container);

        jfrm_login.setLayout(null);
        jfrm_login.setVisible(true);
    }

    public void init_Signup(){
//        Initialize the element of signup Page
        JButton signup_btn,signin_btn,signup_submit_btn;
        JLabel f_name_disp,m_name_disp,l_name_disp,age_disp,phone_num_disp,username_set_disp,password_set_disp, alert_tf;
        JTextField f_name_tf,m_name_tf,l_name_tf,age_tf,phone_num_tf,username_set_tf,password_set_tf;
        JRadioButton genderMaleRb,genderFemaleRb,genderOtherRb;


        JFrame jfrm_signup=new JFrame("Sign Up");
        jfrm_signup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm_signup.setResizable(false);
        jfrm_signup.setSize(800,620);



//        Outer Most Container
        JLabel container=new JLabel();
        container.setBounds(100,50,600,450);
        container.setBackground(Color.decode("#33334d"));


//        SignIn Button Nav
        signin_btn=new JButton("Signin");
        signin_btn.setBackground(Color.decode("#9400D3"));
        signin_btn.setForeground(Color.WHITE);
        signin_btn.setBounds(270,120,100,40);
        jfrm_signup.add(signin_btn);

//        SignUp Button Nav
        signup_btn=new JButton("Signup");
        signup_btn.setBackground(Color.decode("#DA70D6"));
        signup_btn.setForeground(Color.WHITE);
        signup_btn.setBounds(430,120,100,40);
        jfrm_signup.add(signup_btn);

        signin_btn.addActionListener(
                e->{
                    LoginGui o1=new LoginGui();
                    o1.init_Login();
                    jfrm_signup.dispose();
                }
        );

//        Label firstName
        f_name_disp=new JLabel("First Name");
        f_name_disp.setBounds(200,180,100,20);
        f_name_disp.setForeground(Color.WHITE);
        jfrm_signup.add(f_name_disp);

//        Label Middle Name
        m_name_disp=new JLabel("Middle Name");
        m_name_disp.setBounds(340,180,100,20);
        m_name_disp.setForeground(Color.WHITE);
        jfrm_signup.add(m_name_disp);

//        Label Last Name
        l_name_disp=new JLabel("Last Name");
        l_name_disp.setBounds(480,180,100,20);
        l_name_disp.setForeground(Color.WHITE);
        jfrm_signup.add(l_name_disp);

//        firstname Textfield
        f_name_tf=new JTextField();
        f_name_tf.setBounds(200,200,100,30);
        jfrm_signup.add(f_name_tf);

//        middlename Textfield
        m_name_tf=new JTextField();
        m_name_tf.setBounds(340,200,100,30);
        jfrm_signup.add(m_name_tf);

//        last name TextField
        l_name_tf=new JTextField();
        l_name_tf.setBounds(480,200,100,30);
        jfrm_signup.add(l_name_tf);

//        Age Label
        age_disp=new JLabel("Age");
        age_disp.setBounds(200,250,50,20);
        age_disp.setForeground(Color.WHITE);
        jfrm_signup.add(age_disp);

//        Age TextField
        age_tf=new JTextField();
        age_tf.setBounds(200,270,50,30);
        jfrm_signup.add(age_tf);


//        For the Gender    Radio Buttons
        genderMaleRb=new JRadioButton("M");
        genderMaleRb.setBounds(280,270,40,30);
        jfrm_signup.add(genderMaleRb);
        genderFemaleRb=new JRadioButton("F");
        genderFemaleRb.setBounds(330,270,40,30);
        jfrm_signup.add(genderFemaleRb);
        genderOtherRb=new JRadioButton("Ot");
        genderOtherRb.setBounds(380,270,40,30);
        jfrm_signup.add(genderOtherRb);

        genderMaleRb.addActionListener(
                e->{
                    genderFemaleRb.setSelected(false);
                    genderOtherRb.setSelected(false);
                }
        );
        genderFemaleRb.addActionListener(
                e->{
                    genderMaleRb.setSelected(false);
                    genderOtherRb.setSelected(false);
                }
        );
        genderOtherRb.addActionListener(
                e->{
                    genderMaleRb.setSelected(false);
                    genderFemaleRb.setSelected(false);
                }
        );


//        Phone Number Label
        phone_num_disp=new JLabel("Phone Number");
        phone_num_disp.setBounds(445,250,120,20);
        phone_num_disp.setForeground(Color.WHITE);
        jfrm_signup.add(phone_num_disp);

//        Phone num textfield
        phone_num_tf=new JTextField();
        phone_num_tf.setBounds(445,270,150,30);
        jfrm_signup.add(phone_num_tf);

//        Username Label
        username_set_disp=new JLabel("Username");
        username_set_disp.setBounds(200,320,150,20);
        username_set_disp.setForeground(Color.WHITE);
        jfrm_signup.add(username_set_disp);

//        Username TextField
        username_set_tf=new JTextField();
        username_set_tf.setBounds(200,340,150,30);
        jfrm_signup.add(username_set_tf);

//        Password Label
        password_set_disp=new JLabel("Password");
        password_set_disp.setBounds(435,320,150,20);
        password_set_disp.setForeground(Color.WHITE);
        jfrm_signup.add(password_set_disp);

//        Password TextField
        password_set_tf=new JTextField();
        password_set_tf.setBounds(435,340,150,30);
        jfrm_signup.add(password_set_tf);


/*
Submit Button
 */

        signup_submit_btn=new JButton("Signup");
        signup_submit_btn.setBackground(Color.decode("#DA70D6"));
        signup_submit_btn.setForeground(Color.WHITE);
        signup_submit_btn.setBounds(270,410,260,40);
        jfrm_signup.add(signup_submit_btn);

        alert_tf=new JLabel();
        alert_tf.setBounds(270,450,260,25);
        alert_tf.setBackground(Color.decode("#33334d"));
        alert_tf.setForeground(Color.decode("#ff4d4d"));
        alert_tf.setHorizontalAlignment(JTextField.CENTER);
        alert_tf.setVisible(false);
        jfrm_signup.add(alert_tf);

        signup_submit_btn.addActionListener(
                e -> {                      //lambda expression
                    if(f_name_tf.getText().equals("")){
                        alert_tf.setVisible(true);
                        alert_tf.setText("!!FirstName!!");
                        return;
                    }
                    else if(l_name_tf.getText().equals("")){
                        alert_tf.setVisible(true);
                        alert_tf.setText("!!LastName!!");
                        return;
                    }
                    else if(age_tf.getText().equals("")){
                        alert_tf.setVisible(true);
                        alert_tf.setText("!!Age!!");
                        return;
                    }
                    else if(!genderMaleRb.isSelected() && !genderFemaleRb.isSelected() && !genderOtherRb.isSelected()){
                        alert_tf.setVisible(true);
                        alert_tf.setText("!!Select Gender!!");
                        return;
                    }

                    else if(phone_num_tf.getText().equals("")){
                        alert_tf.setVisible(true);
                        alert_tf.setText("!!phone number!!");
                        return;
                    }
                    else if(username_set_tf.getText().equals("")){
                        alert_tf.setVisible(true);
                        alert_tf.setText("!!Username!!");
                        return;
                    }
                    else if(password_set_tf.getText().equals("")){
                        alert_tf.setVisible(true);
                        alert_tf.setText("!!Password!!");
                        return;
                    }

                    alert_tf.setVisible(false);

                    String gender;
                    if(genderMaleRb.isSelected())
                        gender=genderMaleRb.getText();
                    else if(genderFemaleRb.isSelected())
                        gender=genderFemaleRb.getText();
                    else
                        gender=genderOtherRb.getText();
                    Client obj_pass=new Client(f_name_tf.getText(),m_name_tf.getText(),l_name_tf.getText(),Integer.parseInt(age_tf.getText()),gender,phone_num_tf.getText(),username_set_tf.getText(),password_set_tf.getText());
                    DataBaseOperation.writeClientData(obj_pass);
//                    obj_pass.displayDetails();
                    GUI_T o1=new GUI_T();
                    o1.notifyAlert("Account Created Successfully","None");
                    init_Login();
                    jfrm_signup.dispose();
                }
        );

        container.setOpaque(true);
        jfrm_signup.add(container);

        jfrm_signup.setLayout(null);
        jfrm_signup.setVisible(true);
    }

    public void saveLoginInfo(int id,String pass){
        File file=new File("./src/login_info.txt");
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        }catch(IOException fnfe){
            System.out.println(fnfe);
        }

        String write_login_credential=Integer.toString(id)+"/TDL_PASS/"+pass;
        try{
            FileWriter fio_write=new FileWriter(file);
            fio_write.write(write_login_credential);
            fio_write.close();
            System.out.println("Login Save Credential");
            GUI_T msg=new GUI_T();
            msg.notifyAlert("Login Saved","");

        }catch(IOException fnfe1){
            System.out.println(fnfe1);
        }
    }

    public void retriveLoginInfo(){
        File file=new File("./src/login_info.txt");
        try{
            if(!file.exists()){
                file.createNewFile();
                LoginGui login=new LoginGui();
                login.init_Login();
            }
        }catch(IOException fnfe){
            System.out.println(fnfe);
        }

        try{
            StringBuilder login_credential=new StringBuilder("");
            FileReader read_login_credential=new FileReader(file);

            int i=0;
            while ((i = read_login_credential.read()) != -1)
                login_credential.append((char)i);


            String []login_split=login_credential.toString().split("/TDL_PASS/");

            if(login_split.length==2 && DataBaseOperation.readUserPass(Integer.parseInt(login_split[0]),login_split[1])){
                Home_Gui home=new Home_Gui();
                home.homeGUI(Integer.parseInt(login_split[0]),login_split[1]);
            }
            else{
                LoginGui login=new LoginGui();
                login.init_Login();
            }



        }catch(IOException fnfe1){
            System.out.println(fnfe1);
        }


    }

    public void removeLoginInfo(){
        File file=new File("./src/login_info.txt");
        try{
            if(!file.exists()){
                file.createNewFile();
                LoginGui login=new LoginGui();
                login.init_Login();
            }
        }catch(IOException fnfe){
            System.out.println(fnfe);
        }

        try{
            FileWriter fio_write=new FileWriter(file);
            fio_write.write("");
            fio_write.close();
            System.out.println("Remove Login Info");
            GUI_T msg=new GUI_T();
            msg.notifyAlert("Login Removed","");

        }catch(IOException fnfe1){
            System.out.println(fnfe1);
        }
    }

}



