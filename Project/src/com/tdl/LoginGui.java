package com.tdl;

import com.mysql.cj.log.Log;

import javax.swing.*;
//import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Gui Resolution    800x620.
 */

public class LoginGui {

    public void init_Login(){
        JLabel username_disp, password_disp, alert_tf;
        JTextField username_lbl, password_lbl;
        JButton signin_btn, signup_btn, signin_submit_btn;


        JFrame jfrm_login=new JFrame("Login");
        jfrm_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                    jfrm_login.setVisible(false);
                }
        );


        username_disp=new JLabel("Username");
        username_disp.setBounds(270,200,100,20);
        username_disp.setForeground(Color.WHITE);
        jfrm_login.add(username_disp);


        username_lbl=new JTextField();
        username_lbl.setBounds(270,220,260,40);
        jfrm_login.add(username_lbl);


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
                    if(username_lbl.getText().equals("")){
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
                        if(DataBaseOperation.readUserPass(username_lbl.getText(),password_lbl.getText())){
                            alert_tf.setVisible(false);
                            System.out.println("Sucessfully Login");
                        }
                        else{
//                            System.out.println("Invalid Username or pass");
                            alert_tf.setText("!!Invalid Username or Password!!");
                            alert_tf.setVisible(true);
                        }
                    }
//                  System.out.println(username_lbl.getText()+" "+password_lbl.getText());

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
                    jfrm_signup.setVisible(false);
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

                    obj_pass.displayDetails();

                }
        );

        container.setOpaque(true);
        jfrm_signup.add(container);

        jfrm_signup.setLayout(null);
        jfrm_signup.setVisible(true);
    }




    public void homeGUI(){
        JFrame jfrm_home=new JFrame("Home");
        jfrm_home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm_home.setSize(800,620);

        JLabel container_left=new JLabel();
        container_left.setBounds(10,10,300,560);
        container_left.setBackground(Color.decode("#B8C7F4"));

        JLabel name=new JLabel("Manasvi Kumar Thakur");
        name.setBounds(20,7,280,80);
        name.setBackground(Color.black);
        name.setFont(new Font("Verdana", Font.BOLD, 17));
        name.setHorizontalAlignment(SwingConstants.RIGHT);
        jfrm_home.add(name);

        JLabel email=new JLabel("manasvikumar108@gmail.com");
        email.setBounds(20,25,250,80);
        email.setBackground(Color.BLACK);
        email.setForeground(Color.GRAY);
        email.setFont(new Font("Rockwell", Font.PLAIN, 12));
        email.setHorizontalAlignment(SwingConstants.RIGHT);
        jfrm_home.add(email);

        JButton Home;
        Home=new JButton("Home");
        Home.setBackground(Color.decode("#E6E6FA"));
        Home.setForeground(Color.BLACK);
        Home.setBounds(20,100,280,40);
        Home.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_home.add(Home);

        JButton Tasks;
        Tasks=new JButton("Tasks");
        Tasks.setBackground(Color.decode("#E6E6FA"));
        Tasks.setForeground(Color.BLACK);
        Tasks.setBounds(20,150,280,40);
        Tasks.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_home.add(Tasks);

        JButton Important;
        Important=new JButton("Important");
        Important.setBackground(Color.decode("#E6E6FA"));
        Important.setForeground(Color.BLACK);
        Important.setBounds(20,200,280,40);
        Important.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_home.add(Important);

        JButton Planned;
        Planned=new JButton("Planned");
        Planned.setBackground(Color.decode("#E6E6FA"));
        Planned.setForeground(Color.BLACK);
        Planned.setBounds(20,250,280,40);
        Planned.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_home.add(Planned);

        JButton Groceries;
        Groceries=new JButton("Groceries");
        Groceries.setBackground(Color.decode("#E6E6FA"));
        Groceries.setForeground(Color.BLACK);
        Groceries.setBounds(20,300,280,40);
        Groceries.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_home.add(Groceries);

        JButton Settings;
        Settings=new JButton("Settings");
        Settings.setBackground(Color.decode("#E6E6FA"));
        Settings.setForeground(Color.BLACK);
        Settings.setBounds(20,350,280,40);
        Settings.setHorizontalAlignment(SwingConstants.LEFT);
        jfrm_home.add(Settings);

        container_left.setOpaque(true);
        jfrm_home.add(container_left);

        JLabel container_right=new JLabel();
        container_right.setBounds(320,10,450,560);
        container_right.setBackground(Color.decode("#B8C7F4"));

//        JButton Add;
//        Add=new JButton("ADD");
//        Add.setBackground(Color.decode("#36454F"));
//        Add.setForeground(Color.white);
//        Add.setBounds(600,300,60,20);
//        jfrm_home.add(Add);

        JTextField Add_tasks=new JTextField();
        Add_tasks.setBounds(340,500,400,50);
//        Add_tasks.add(Add);
        jfrm_home.add(Add_tasks);

        container_right.setOpaque(true);
        jfrm_home.add(container_right);


        jfrm_home.setLayout(null);
        jfrm_home.setVisible(true);

    }
}


