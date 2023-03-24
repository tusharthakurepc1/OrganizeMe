package com.tdl;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI_T {

    public void guiSettingFrame(){
        JFrame jfrm_set=new JFrame("Settings");
        jfrm_set.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm_set.setSize(800,620);
        jfrm_set.setResizable(false);

        JLabel logo=new JLabel("T");
        logo.setBounds(100,115,50,50);
        logo.setFont(new Font("Vardana",Font.BOLD,50));
        logo.setHorizontalAlignment(JLabel.CENTER);
        Border b1=BorderFactory.createLineBorder(Color.BLACK);
        logo.setBorder(b1);
        jfrm_set.add(logo);

        JLabel name=new JLabel("Tejasvi Kumar Thakur");
        name.setBounds(170,105,2000,50);
        name.setBackground(Color.RED);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("", Font.BOLD, 30));
        jfrm_set.add(name);

        JLabel tej=new JLabel("tejasvikumar108");
        tej.setBounds(175,145,400,25);
        tej.setFont(new Font("", Font.PLAIN, 15));
        tej.setBackground(Color.RED);
        tej.setForeground(Color.BLACK);
        jfrm_set.add(tej);


        JButton manage_ac;
        manage_ac=new JButton("Manage Account");
        manage_ac.setBackground(Color.decode("#E6E6FA"));
        manage_ac.setForeground(Color.BLACK);
        manage_ac.setBounds(550,110,150,30);
        manage_ac.setHorizontalAlignment(SwingConstants.CENTER);
        jfrm_set.add(manage_ac);

        JButton Signout;
        Signout=new JButton("Signout");
        Signout.setBackground(Color.decode("#E6E6FA"));
        Signout.setForeground(Color.BLACK);
        Signout.setBounds(550,150,150,30);
        Signout.setHorizontalAlignment(SwingConstants.CENTER);
        jfrm_set.add(Signout);


        JButton Update_Account_Detail;
        Update_Account_Detail=new JButton("Update Account Detail");
        Update_Account_Detail.setBackground(Color.decode("#E6E6FA"));
        Update_Account_Detail.setForeground(Color.BLACK);
        Update_Account_Detail.setFont(new Font("Vardana",Font.PLAIN,20));
        Update_Account_Detail.setBounds(150,250,250,40);
        Update_Account_Detail.setHorizontalAlignment(SwingConstants.CENTER);
        jfrm_set.add(Update_Account_Detail);

        JButton View_Detail;
        View_Detail=new JButton("View Detail");
        View_Detail.setBackground(Color.decode("#E6E6FA"));
        View_Detail.setForeground(Color.BLACK);
        View_Detail.setFont(new Font("Vardana",Font.PLAIN,20));
        View_Detail.setBounds(150,300,250,40);
        View_Detail.setHorizontalAlignment(SwingConstants.CENTER);
        jfrm_set.add(View_Detail);

        JButton Logout;
        Logout=new JButton("Logout");
        Logout.setBackground(Color.decode("#E6E6FA"));
        Logout.setForeground(Color.BLACK);
        Logout.setFont(new Font("Vardana",Font.PLAIN,20));
        Logout.setBounds(150,350,250,40);
        Logout.setHorizontalAlignment(SwingConstants.CENTER);
        jfrm_set.add(Logout);

        JButton Reset_Password;
        Reset_Password=new JButton("Reset Password");
        Reset_Password.setBackground(Color.decode("#E6E6FA"));
        Reset_Password.setForeground(Color.BLACK);
        Reset_Password.setFont(new Font("Vardana",Font.PLAIN,20));
        Reset_Password.setBounds(150,400,250,40);
        Reset_Password.setHorizontalAlignment(SwingConstants.CENTER);
        jfrm_set.add(Reset_Password);


        jfrm_set.setLayout(null);
        jfrm_set.setVisible(true);
    }


    public void notifyAlert(String msg,String time){
        JFrame jfrm_notify=new JFrame("Notification");
        jfrm_notify.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm_notify.setSize(300,200);
        jfrm_notify.setAlwaysOnTop(true);
        jfrm_notify.setResizable(false);

//        Get the Dimension of the Screen
        Dimension res=Toolkit.getDefaultToolkit().getScreenSize();
        double height=res.getHeight();
        double width=res.getWidth();
//        Set the frame at the bottom right corner.
        jfrm_notify.setLocation((int)width-300,(int)height-250);

        JLabel message=new JLabel("!!"+msg+"!!");
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

