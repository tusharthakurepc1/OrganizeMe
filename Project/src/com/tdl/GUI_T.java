package com.tdl;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI_T {

    public void guiSettingFrame(int id,String pass){

        Client data = DataBaseOperation.readStampData(id, pass);

        JFrame jfrm_setting=new JFrame("Settings");
        jfrm_setting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm_setting.setSize(800,620);
        jfrm_setting.setResizable(false);

        JLabel logo=new JLabel(""+data.f_name.charAt(0));
        logo.setBounds(100,115,50,50);
        logo.setFont(new Font("Vardana",Font.BOLD,50));
        logo.setHorizontalAlignment(JLabel.CENTER);
        Border b1=BorderFactory.createLineBorder(Color.BLACK);
        logo.setBorder(b1);
        jfrm_setting.add(logo);

        JLabel name=new JLabel(data.f_name+" "+data.m_name+" "+data.l_name);
        name.setBounds(170,105,2000,50);
        name.setBackground(Color.RED);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("", Font.BOLD, 30));
        jfrm_setting.add(name);

        JLabel tej=new JLabel("@"+data.username);
        tej.setBounds(175,145,400,25);
        tej.setFont(new Font("", Font.PLAIN, 15));
        tej.setBackground(Color.RED);
        tej.setForeground(Color.BLACK);
        jfrm_setting.add(tej);

        JButton back_btn=new JButton("Back");
        back_btn.setBounds(0,0,70,50);
        back_btn.setFont(new Font("Vardana",Font.PLAIN,15));
        jfrm_setting.add(back_btn);
        back_btn.addActionListener(
                e -> {
                    Home_Gui home=new Home_Gui();
                    home.homeGUI(id,pass);
                    jfrm_setting.dispose();
                }
        );


        JButton save_login_info;
        save_login_info=new JButton("Save Login Info");
        save_login_info.setBackground(Color.decode("#E6E6FA"));
        save_login_info.setForeground(Color.BLACK);
        save_login_info.setBounds(550,110,150,30);
        save_login_info.setHorizontalAlignment(SwingConstants.CENTER);
        jfrm_setting.add(save_login_info);
        save_login_info.addActionListener(
                e->{
                    LoginGui save_info=new LoginGui();
                    save_info.saveLoginInfo(data.client_id, data.pass);
                }
        );


        JButton remove_info;
        remove_info=new JButton("Remove Login Info");
        remove_info.setBackground(Color.decode("#E6E6FA"));
        remove_info.setForeground(Color.BLACK);
        remove_info.setBounds(550,150,150,30);
        remove_info.setHorizontalAlignment(SwingConstants.CENTER);
        jfrm_setting.add(remove_info);

        remove_info.addActionListener(
                e->{
                    LoginGui remove_login=new LoginGui();
                    remove_login.removeLoginInfo();
                }
        );


        JButton Update_Account_Detail;
        Update_Account_Detail=new JButton("Update Account Detail");
        Update_Account_Detail.setBackground(Color.decode("#E6E6FA"));
        Update_Account_Detail.setForeground(Color.BLACK);
        Update_Account_Detail.setFont(new Font("Vardana",Font.PLAIN,20));
        Update_Account_Detail.setBounds(150,250,250,40);
        Update_Account_Detail.setHorizontalAlignment(SwingConstants.CENTER);
        jfrm_setting.add(Update_Account_Detail);

        Update_Account_Detail.addActionListener(
                e->{
                    GUI_Settings update_sett_frame=new GUI_Settings();
                    update_sett_frame.updateDetails(data);

                    jfrm_setting.dispose();
                }
        );

        JButton View_Detail;
        View_Detail=new JButton("View Detail");
        View_Detail.setBackground(Color.decode("#E6E6FA"));
        View_Detail.setForeground(Color.BLACK);
        View_Detail.setFont(new Font("Vardana",Font.PLAIN,20));
        View_Detail.setBounds(150,300,250,40);
        View_Detail.setHorizontalAlignment(SwingConstants.CENTER);
        jfrm_setting.add(View_Detail);

        View_Detail.addActionListener(
                e -> {
                    GUI_Settings display=new GUI_Settings();
                    display.displayData(data);
                    jfrm_setting.dispose();
                }
        );

        JButton Logout;
        Logout=new JButton("Logout");
        Logout.setBackground(Color.decode("#E6E6FA"));
        Logout.setForeground(Color.BLACK);
        Logout.setFont(new Font("Vardana",Font.PLAIN,20));
        Logout.setBounds(150,350,250,40);
        Logout.setHorizontalAlignment(SwingConstants.CENTER);
        jfrm_setting.add(Logout);
        Logout.addActionListener(
                e -> {
                    LoginGui login=new LoginGui();
                    login.init_Login();

                    jfrm_setting.dispose();
                }
        );


        JButton Reset_Password;
        Reset_Password=new JButton("Reset Password");
        Reset_Password.setBackground(Color.decode("#E6E6FA"));
        Reset_Password.setForeground(Color.BLACK);
        Reset_Password.setFont(new Font("Vardana",Font.PLAIN,20));
        Reset_Password.setBounds(150,400,250,40);
        Reset_Password.setHorizontalAlignment(SwingConstants.CENTER);
        jfrm_setting.add(Reset_Password);

        Reset_Password.addActionListener(
                e->{
                    GUI_Settings password_jfrm=new GUI_Settings();
                    password_jfrm.updatePassword(data);

                    jfrm_setting.dispose();
                }
        );




        jfrm_setting.setLayout(null);
        jfrm_setting.setVisible(true);
    }



    public void notifyAlert(String msg,String time){
        JFrame jfrm_notify=new JFrame("Notification");
        jfrm_notify.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jfrm_notify.setSize(300,200);
        jfrm_notify.setAlwaysOnTop(true);
        jfrm_notify.setResizable(false);

//        Get the Dimension of the Screen
        Dimension res=Toolkit.getDefaultToolkit().getScreenSize();
        double height=res.getHeight();
        double width=res.getWidth();
//        Set the frame at the bottom right corner.
        jfrm_notify.setLocation((int)width-300,(int)height-250);

        JLabel message=new JLabel(msg);
        message.setBounds(35,5,200,100);
        message.setHorizontalAlignment(JLabel.CENTER);
        jfrm_notify.add(message);


        JButton btn_next=new JButton("Ok");
        btn_next.setBounds(115,115,50,25);
        jfrm_notify.add(btn_next);

        btn_next.addActionListener(
                e->{
                    jfrm_notify.dispose();
                }
        );

        jfrm_notify.setLayout(null);
        jfrm_notify.setVisible(true);
    }
}


class Client{
    protected int client_id;
    protected String f_name,m_name,l_name;
    protected int age;
    protected String gender,phone_num;
    protected String username,pass;

    Client(){
        client_id=0;f_name="";m_name="";l_name="";age=0;gender=null;phone_num="xxx";username="";pass="";
    }
    Client(String f,String m,String l,int a,String g,String pn,String u,String p){
        f_name=f;   m_name=m;   l_name=l;
        age=a;
        gender=g;
        phone_num=pn;
        username=u;
        pass=p;
    }

    Client(int id,String f,String m,String l,int a,String g,String pn,String u,String p){
        client_id=id;
        f_name=f;   m_name=m;   l_name=l;
        age=a;
        gender=g;
        phone_num=pn;
        username=u;
        pass=p;
    }

    protected void displayDetails(){
        System.out.println();
        System.out.println(client_id+" | "+f_name+" | "+m_name+" | "+l_name+" | "+age+" | "+gender+" | "+phone_num+" | "+username+" | "+pass);
    }
}

class Task extends Client{
    //    int c_id_derived;
    int task_id;
    String time_of_start,time_reminder;
    String t_title,t_desc;
    String t_flag;              // IMP,HOME,STAR,DGC, etc

    Task(){
        task_id=0;
        time_reminder="";   time_of_start="";
        t_title=""; t_desc="";  t_flag="";
    }

    Task(String t_title,String time_of_start,String time_reminder,String t_desc,String t_flag){
        this.t_title=t_title;
        this.time_of_start=time_of_start;
        this.time_reminder=time_reminder;
        this.t_desc=t_desc;
        this.t_flag=t_flag;
    }

    Task(Client c){
        this.client_id=c.client_id;
        this.f_name=c.f_name;   this.m_name=c.m_name;   this.l_name=c.l_name;
        this.age=c.age;     this.phone_num=c.phone_num;
        this.username=c.username;   this.pass=c.pass;

        task_id=0;
        t_title=""; t_desc="";  t_flag="";
    }

    Task(Client c,String t_title,String time_of_start,String time_reminder,String t_desc,String t_flag){
        this.client_id=c.client_id;
        this.f_name=c.f_name;   this.m_name=c.m_name;   this.l_name=c.l_name;
        this.age=c.age;     this.phone_num=c.phone_num;
        this.username=c.username;   this.pass=c.pass;

        task_id=0;
        this.t_title=t_title; this.time_of_start=time_of_start; this.time_reminder=time_reminder;
        this.t_desc=t_desc;  this.t_flag=t_flag;
    }

    @Override
    protected void displayDetails(){
        super.displayDetails();
        System.out.println(task_id+" "+t_title+" "+time_of_start+" "+time_reminder+" "+t_desc+" "+t_flag);
    }

}